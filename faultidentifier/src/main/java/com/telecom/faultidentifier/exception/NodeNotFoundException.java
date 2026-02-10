package com.telecom.faultidentifier.exception;

import org.w3c.dom.Node;

public class NodeNotFoundException extends RuntimeException{
    public NodeNotFoundException(String message){
        super(message);
    }
}
