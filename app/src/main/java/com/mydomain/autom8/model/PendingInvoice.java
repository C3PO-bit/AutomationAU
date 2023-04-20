package com.mydomain.autom8.model;

public class PendingInvoice {

    public final int id;
    public final String invoiceTitle;
    public final String invoiceDescription;
    public final String  invoicePrice;
    public final String invoiceDate;


    public PendingInvoice(int id, String invoiceTitle, String invoiceDescription, String invoicePrice, String invoiceDate) {
        this.id = id;
        this.invoiceTitle = invoiceTitle;
        this.invoiceDescription = invoiceDescription;
        this.invoicePrice = invoicePrice;
        this.invoiceDate = invoiceDate;
    }
}
