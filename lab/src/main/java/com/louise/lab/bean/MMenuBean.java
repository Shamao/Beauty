package com.louise.lab.bean;

/**
 * @author lsd
 * @date 2018/2/7.
 */

public class MMenuBean {
    private String mTitle;
    private String mSchema;

    public MMenuBean(String title, String schema) {
        mTitle = title;
        mSchema = schema;
    }

    public String getSchema() {
        return mSchema;
    }

    public void setSchema(String schema) {
        mSchema = schema;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
