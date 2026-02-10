package com.telecom.faultidentifier.Service;

import com.telecom.faultidentifier.Repository.FaultLogRepository;
import com.telecom.faultidentifier.Repository.NetworkRepository;
import com.telecom.faultidentifier.exception.NodeNotFoundException;
import com.telecom.faultidentifier.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.Configuration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class NetworkService {
    @Autowired
    private NetworkRepository networkRepository;

    @Autowired
    private FaultLogRepository faultLogRepository;

    public NetworkNode add(NetworkNode networkNode) {

        return networkRepository.save(networkNode);
    }

    public List<NetworkNode> getAllNodes() {
        return networkRepository.findAll();
    }

    public NetworkNode getNode(String name) {
        return networkRepository.findById(name).orElseThrow(()-> new RuntimeException("Node not found"));
    }

    public void deleteNode(String name) {
        networkRepository.deleteById(name);
    }

    public String connectNodes(String from, String to,int since){
        NetworkNode fromNode=networkRepository.findById(from).orElseThrow(()-> new RuntimeException("Node "+from+" not found"));
        NetworkNode toNode=networkRepository.findById(to).orElseThrow(()-> new RuntimeException("Node "+to+" not found"));

        Connection connection=new Connection(since,toNode);

        fromNode.getConnections().add(connection);
        networkRepository.save(fromNode);
        return "Nodes connected successfully";
    }

    public FaultResponse simulateFault(String name, String severity){
        if(!networkRepository.existsById(name)){
            throw new NodeNotFoundException("Node doesnt exist");
        }

        List<NetworkNode> impactedNodes=networkRepository.impactedNodes(name);
        List<String> impactedNames=impactedNodes.stream().map(NetworkNode::getName).toList();
        FaultLog log=new FaultLog(
                UUID.randomUUID().toString(),
                name,
                severity,
                LocalDateTime.now().toString()
        );
        faultLogRepository.save(log);
        return new FaultResponse(name,impactedNames);
    }



}
