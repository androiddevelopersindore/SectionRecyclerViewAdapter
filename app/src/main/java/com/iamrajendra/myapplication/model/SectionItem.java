package com.iamrajendra.myapplication.model;

/**
 * Created by rajendraverma on 11-08-2016.
 */
public class SectionItem {
private String header;
    private String item;

    public SectionItem(String header, String item) {
        this.header = header;
        this.item = item;
    }

    public SectionItem(String item) {
        this.item = item;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
