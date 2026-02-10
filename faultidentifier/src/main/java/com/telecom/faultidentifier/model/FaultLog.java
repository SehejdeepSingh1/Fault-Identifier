package com.telecom.faultidentifier.model;

import org.springframework.data.annotation.Id;

public class FaultLog {
    @Id
    private String id;
    private String nodename;
    private String severity;
    private String timestamp;

    public FaultLog(){

    }

    public FaultLog(String id, String nodename, String severity, String timestamp) {
        this.id = id;
        this.nodename = nodename;
        this.severity = severity;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNodename() {
        return nodename;
    }

    public void setNodename(String nodename) {
        this.nodename = nodename;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
