package com.riversoft.weixin.pay.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @borball on 5/17/2016.
 */
public class RefundRequest {

    @JsonProperty("sub_appid")
    private String subAppId;

    @JsonProperty("sub_mch_id")
    private String subMchId;

    @JsonProperty("transaction_id")
    private String transactionId;

    @JsonProperty("out_trade_no")
    private String tradeNumber;

    @JsonProperty("out_refund_no")
    private String refundNumber;

    @JsonProperty("total_fee")
    private int totalFee;

    @JsonProperty("refund_fee")
    private int refundFee;

    @JsonProperty("refund_fee_type")
    private String refundFeeType;

    @JsonProperty("op_user_id")
    private String operatorId;

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

    public String getRefundNumber() {
        return refundNumber;
    }

    public void setRefundNumber(String refundNumber) {
        this.refundNumber = refundNumber;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public int getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(int refundFee) {
        this.refundFee = refundFee;
    }

    public String getRefundFeeType() {
        return refundFeeType;
    }

    public void setRefundFeeType(String refundFeeType) {
        this.refundFeeType = refundFeeType;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
}
