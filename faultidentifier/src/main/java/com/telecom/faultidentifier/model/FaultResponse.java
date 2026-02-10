package com.telecom.faultidentifier.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class FaultResponse {
//    @Id
    String failedNode;
    List<String> impactedNodes;

    public FaultResponse(String failedNode, List<String> impactedNodes) {
        this.failedNode = failedNode;
        this.impactedNodes = impactedNodes;
    }

    public String getFailedNode() {
        return failedNode;
    }

    public void setFailedNode(String failedNode) {
        this.failedNode = failedNode;
    }

    public List<String> getImpactedNodes() {
        return impactedNodes;
    }

    public void setImpactedNodes(List<String> impactedNodes) {
        this.impactedNodes = impactedNodes;
    }
}
