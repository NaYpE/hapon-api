package com.hapon.shop.domain;

import java.time.LocalDateTime;
import java.util.List;

public class PurchaseDom {
    private int purchaseId;
    private String clientId;
    private LocalDateTime date;
    private String paymentMethod;
    private String comment;
    private boolean state;
    private List<PurchaseItem> items;

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public List<PurchaseItem> getItem() {
        return items;
    }

    public void setItem(List<PurchaseItem> items) {
        this.items = items;
    }
}
