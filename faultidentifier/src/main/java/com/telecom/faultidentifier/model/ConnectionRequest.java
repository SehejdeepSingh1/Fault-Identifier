package com.telecom.faultidentifier.model;

public class ConnectionRequest {
    private String from;
    private String to;
    private int since;

    public ConnectionRequest() {

    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getSince() {
        return since;
    }

    public void setSince(int since) {
        this.since = since;
    }
}
