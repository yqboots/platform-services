package com.yqboots.social.wechat.client.util;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

public class HttpClientUtils {
    private static final Logger LOG = LoggerFactory.getLogger(HttpClientUtils.class);

    public static CloseableHttpClient acceptsTrustedCertsHttpClient(String certPath, String partnerId)
            throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException, UnrecoverableKeyException, IOException {
        HttpClientBuilder b = HttpClientBuilder.create();

        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        loadCert(keyStore, certPath, partnerId);

        SSLContext sslContext = new SSLContextBuilder().loadKeyMaterial(keyStore, partnerId.toCharArray()).build();
        b.setSSLContext(sslContext);

        // here's the special part:
        //      -- need to create an SSL Socket Factory, to use our weakened "trust strategy";
        //      -- and create a Registry, to register it.
        //
        SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(
                sslContext, new String[]{"TLSv1"}, null, new DefaultHostnameVerifier()
        );
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", sslSocketFactory)
                .build();

        // now, we create connection-manager using our Registry.
        //      -- allows multi-threaded use
        PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        connMgr.setMaxTotal(200);
        connMgr.setDefaultMaxPerRoute(100);
        b.setConnectionManager(connMgr);

        // finally, build the HttpClient;
        return b.build();
    }

    private static void loadCert(KeyStore keyStore, String certPath, String partnerId)
            throws IOException {
        File cert;
        try {
            cert = ResourceUtils.getFile(certPath);
        } catch (FileNotFoundException e) {
            LOG.warn("wechat cert not found, some apis may not work", e);
            return;
        }

        try (
                FileInputStream fis = new FileInputStream(cert);
        ) {
            keyStore.load(fis, partnerId.toCharArray());
        } catch (CertificateException | NoSuchAlgorithmException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
