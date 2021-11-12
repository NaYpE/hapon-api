package com.hapon.shop.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "purchases_products")
public class PurchasesProduct {

    @EmbeddedId
    private PurchasesProductPK id;
    private Integer amount;
    private Double total;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_purchase", insertable = false, updatable = false)
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private Producto producto;

    public PurchasesProductPK getId() {
        return id;
    }

    public void setId(PurchasesProductPK id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
