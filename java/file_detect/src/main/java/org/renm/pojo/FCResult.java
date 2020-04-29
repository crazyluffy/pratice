package org.renm.pojo;

public enum  FCResult{
    Y("Y"), N("N");

    private String value;
    private FCResult(String s){
        this.value = s;
    }

    public String getValue() {
        return value;
    }
}
