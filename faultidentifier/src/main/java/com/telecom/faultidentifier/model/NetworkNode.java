package com.telecom.faultidentifier.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class NetworkNode {
    @Id
    @NotBlank(message = "Node name cannot be empty")
    private String name;
    @NotBlank(message = "Node type cannot be empty")
    private String type;


    @Relationship(type = "CONNECTED_TO")
    private List<Connection> connections=new ArrayList<>();

    //needed for spring to make objects of this class
    /* spring makes objects by a process called reflection where
    they first create an empty object then they
    set values into the fields*/
    public NetworkNode(){

    }

    //if the user wants to create the object manually
    public NetworkNode(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }
}
