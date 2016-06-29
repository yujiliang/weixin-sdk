package com.riversoft.weixin.pay.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @borball on 5/15/2016.
 */
public class OrderQueryRequest {

    @JsonProperty("sub_appid")
    private String subAppId;

    @JsonProperty("sub_mch_id")
    private String subMchId;

    @JsonProperty("transaction_id")
    private String transactionId;

    @JsonProperty("out_trade_no")
    private String tradeNumber;

    public String getSubAppId() {
        return subAppId;
    }

    public void setSubAppId(String subAppId) {
        this.subAppId = subAppId;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTradeNumber() {
        return tradeNumber;
    }

    public void setTradeNumber(String tradeNumber) {
        this.tradeNumber = tradeNumber;
    }
}
