package com.telecom.faultidentifier.model;

public class FaultSeverity {
    String severity;

    public FaultSeverity(String severity) {
        this.severity = severity;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
}
