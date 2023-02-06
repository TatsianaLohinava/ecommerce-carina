package com.solvd.ecommerce.utils;

public enum ContextView {

    APP("NATIVE_APP"),
    WEB("CHROMIUM");

    private String contextName;

    ContextView(String contextName) {
        this.contextName = contextName;
    }

    public String getContextView() {
        return this.contextName;
    }

}