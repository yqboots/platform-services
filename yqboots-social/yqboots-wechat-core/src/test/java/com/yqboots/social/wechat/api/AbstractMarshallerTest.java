package com.yqboots.social.wechat.api;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.bind.Marshaller;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMarshallerTest {
    protected Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

    public void setUp() throws Exception {
        marshaller = new Jaxb2Marshaller();
        Map<String, Object> properties = new HashMap<>();
        properties.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setMarshallerProperties(properties);
    }
}
