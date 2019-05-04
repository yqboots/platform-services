//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.7 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2019.05.05 时间 12:10:46 AM CST 
//


package com.yqboots.social.wechat.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="appId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mchId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nonceStr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sign" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="resultCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="errCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="errCodeDes" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deviceInfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="openId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isSubscribe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tradeType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tradeState" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bankType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="totalFee" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="feeType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cashFee" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cashFeeType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="settlementTotalFee" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="couponFee" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="couponCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="outTradeNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="attach" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="timeEnd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tradeStateDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "appId",
    "mchId",
    "nonceStr",
    "sign",
    "resultCode",
    "errCode",
    "errCodeDes",
    "deviceInfo",
    "openId",
    "isSubscribe",
    "tradeType",
    "tradeState",
    "bankType",
    "totalFee",
    "feeType",
    "cashFee",
    "cashFeeType",
    "settlementTotalFee",
    "couponFee",
    "couponCount",
    "transactionId",
    "outTradeNo",
    "attach",
    "timeEnd",
    "tradeStateDesc"
})
@XmlRootElement(name = "OrderQueryResponse")
public class OrderQueryResponse {

    @XmlElement(required = true)
    protected String appId;
    @XmlElement(required = true)
    protected String mchId;
    @XmlElement(required = true)
    protected String nonceStr;
    @XmlElement(required = true)
    protected String sign;
    @XmlElement(required = true)
    protected String resultCode;
    @XmlElement(required = true)
    protected String errCode;
    @XmlElement(required = true)
    protected String errCodeDes;
    @XmlElement(required = true)
    protected String deviceInfo;
    @XmlElement(required = true)
    protected String openId;
    @XmlElement(required = true)
    protected String isSubscribe;
    @XmlElement(required = true)
    protected String tradeType;
    @XmlElement(required = true)
    protected String tradeState;
    @XmlElement(required = true)
    protected String bankType;
    protected int totalFee;
    @XmlElement(required = true)
    protected String feeType;
    protected int cashFee;
    @XmlElement(required = true)
    protected String cashFeeType;
    protected int settlementTotalFee;
    protected int couponFee;
    protected int couponCount;
    @XmlElement(required = true)
    protected String transactionId;
    @XmlElement(required = true)
    protected String outTradeNo;
    @XmlElement(required = true)
    protected String attach;
    @XmlElement(required = true)
    protected String timeEnd;
    @XmlElement(required = true)
    protected String tradeStateDesc;

    /**
     * 获取appId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置appId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppId(String value) {
        this.appId = value;
    }

    /**
     * 获取mchId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMchId() {
        return mchId;
    }

    /**
     * 设置mchId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMchId(String value) {
        this.mchId = value;
    }

    /**
     * 获取nonceStr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNonceStr() {
        return nonceStr;
    }

    /**
     * 设置nonceStr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNonceStr(String value) {
        this.nonceStr = value;
    }

    /**
     * 获取sign属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSign() {
        return sign;
    }

    /**
     * 设置sign属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSign(String value) {
        this.sign = value;
    }

    /**
     * 获取resultCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * 设置resultCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultCode(String value) {
        this.resultCode = value;
    }

    /**
     * 获取errCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrCode() {
        return errCode;
    }

    /**
     * 设置errCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrCode(String value) {
        this.errCode = value;
    }

    /**
     * 获取errCodeDes属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrCodeDes() {
        return errCodeDes;
    }

    /**
     * 设置errCodeDes属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrCodeDes(String value) {
        this.errCodeDes = value;
    }

    /**
     * 获取deviceInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceInfo() {
        return deviceInfo;
    }

    /**
     * 设置deviceInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceInfo(String value) {
        this.deviceInfo = value;
    }

    /**
     * 获取openId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置openId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpenId(String value) {
        this.openId = value;
    }

    /**
     * 获取isSubscribe属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsSubscribe() {
        return isSubscribe;
    }

    /**
     * 设置isSubscribe属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsSubscribe(String value) {
        this.isSubscribe = value;
    }

    /**
     * 获取tradeType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradeType() {
        return tradeType;
    }

    /**
     * 设置tradeType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradeType(String value) {
        this.tradeType = value;
    }

    /**
     * 获取tradeState属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradeState() {
        return tradeState;
    }

    /**
     * 设置tradeState属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradeState(String value) {
        this.tradeState = value;
    }

    /**
     * 获取bankType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankType() {
        return bankType;
    }

    /**
     * 设置bankType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankType(String value) {
        this.bankType = value;
    }

    /**
     * 获取totalFee属性的值。
     * 
     */
    public int getTotalFee() {
        return totalFee;
    }

    /**
     * 设置totalFee属性的值。
     * 
     */
    public void setTotalFee(int value) {
        this.totalFee = value;
    }

    /**
     * 获取feeType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeType() {
        return feeType;
    }

    /**
     * 设置feeType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeType(String value) {
        this.feeType = value;
    }

    /**
     * 获取cashFee属性的值。
     * 
     */
    public int getCashFee() {
        return cashFee;
    }

    /**
     * 设置cashFee属性的值。
     * 
     */
    public void setCashFee(int value) {
        this.cashFee = value;
    }

    /**
     * 获取cashFeeType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCashFeeType() {
        return cashFeeType;
    }

    /**
     * 设置cashFeeType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCashFeeType(String value) {
        this.cashFeeType = value;
    }

    /**
     * 获取settlementTotalFee属性的值。
     * 
     */
    public int getSettlementTotalFee() {
        return settlementTotalFee;
    }

    /**
     * 设置settlementTotalFee属性的值。
     * 
     */
    public void setSettlementTotalFee(int value) {
        this.settlementTotalFee = value;
    }

    /**
     * 获取couponFee属性的值。
     * 
     */
    public int getCouponFee() {
        return couponFee;
    }

    /**
     * 设置couponFee属性的值。
     * 
     */
    public void setCouponFee(int value) {
        this.couponFee = value;
    }

    /**
     * 获取couponCount属性的值。
     * 
     */
    public int getCouponCount() {
        return couponCount;
    }

    /**
     * 设置couponCount属性的值。
     * 
     */
    public void setCouponCount(int value) {
        this.couponCount = value;
    }

    /**
     * 获取transactionId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * 设置transactionId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionId(String value) {
        this.transactionId = value;
    }

    /**
     * 获取outTradeNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutTradeNo() {
        return outTradeNo;
    }

    /**
     * 设置outTradeNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutTradeNo(String value) {
        this.outTradeNo = value;
    }

    /**
     * 获取attach属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttach() {
        return attach;
    }

    /**
     * 设置attach属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttach(String value) {
        this.attach = value;
    }

    /**
     * 获取timeEnd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeEnd() {
        return timeEnd;
    }

    /**
     * 设置timeEnd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeEnd(String value) {
        this.timeEnd = value;
    }

    /**
     * 获取tradeStateDesc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradeStateDesc() {
        return tradeStateDesc;
    }

    /**
     * 设置tradeStateDesc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradeStateDesc(String value) {
        this.tradeStateDesc = value;
    }

}
