package com.telecom.faultidentifier.Controller;

import com.telecom.faultidentifier.Service.NetworkService;
import com.telecom.faultidentifier.model.ConnectionRequest;
import com.telecom.faultidentifier.model.FaultResponse;
import com.telecom.faultidentifier.model.FaultSeverity;
import com.telecom.faultidentifier.model.NetworkNode;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nodes")
public class NetworkController {
    @Autowired
    private NetworkService networkService;

    @Value("${app.environment}")
    private String environment;

    @PostMapping
    public NetworkNode addUser(@Valid @RequestBody NetworkNode networkNode){

        return networkService.add(networkNode);
    }


    @GetMapping("/getAll")
    public List<NetworkNode> getAllNodes(){

        return networkService.getAllNodes();
    }

    @GetMapping("/{name}")
    public NetworkNode getUserByName(@PathVariable String name){
        return networkService.getNode(name);
    }

    @DeleteMapping("/delete/{name}")
    public String deleteNode(@PathVariable String name){
        networkService.deleteNode(name);
        return "Node deleted successfully";
    }

    @PostMapping("/connect")
    public ResponseEntity<String> connectNodes(
            @RequestBody ConnectionRequest request
            ){
        networkService.connectNodes(request.getFrom(), request.getTo(),request.getSince());
        return ResponseEntity.ok("Nodes connected successfully");
    }
    @PostMapping("/faults/{nodename}")
    public FaultResponse simulateFault(@PathVariable String nodename, @RequestBody FaultSeverity faultSeverity){
        return networkService.simulateFault(nodename,faultSeverity.getSeverity());
    }

    @GetMapping("/env")
    public String getEnvironment(){
        return "Running in : "+environment;
    }
}
