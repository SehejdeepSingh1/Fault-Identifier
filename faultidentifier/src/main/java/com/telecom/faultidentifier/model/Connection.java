package com.telecom.faultidentifier.model;

import org.springframework.data.neo4j.core.schema.*;

@RelationshipProperties
public class Connection {
    @Id
    @GeneratedValue
    private Long id;
    private int since;

    @TargetNode
    private NetworkNode targetNode;

    public Connection(){

    }

    public Connection(int since, NetworkNode targetNode) {
        this.since = since;
        this.targetNode = targetNode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSince() {
        return since;
    }

    public void setSince(int since) {
        this.since = since;
    }

    public NetworkNode getTargetNode() {
        return targetNode;
    }

    public void setTargetNode(NetworkNode targetNode) {
        this.targetNode = targetNode;
    }
}
