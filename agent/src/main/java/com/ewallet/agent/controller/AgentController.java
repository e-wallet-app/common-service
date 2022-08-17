package com.ewallet.agent.controller;

import com.ewallet.agent.dto.request.AgentReqDto;
import com.ewallet.agent.dto.response.AgentResDto;
import com.ewallet.agent.entity.Agent;
import com.ewallet.agent.exceptions.AgentNotFoundException;
import com.ewallet.agent.service.AgentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AgentController {

    private AgentService agentService;

    private AgentController(AgentService agentService){
        this.agentService = agentService;
    }

    @GetMapping("/agent")
    public ResponseEntity<List<Agent>> allAgent()
    {
        var agent =  agentService.findAll();
        return ResponseEntity.ok(agent);
    }

    @GetMapping("/agent/{id}")
    public ResponseEntity<Agent> getAgent(@PathVariable Long id){
        Agent agent = agentService.findById(id);
        if(agent == null){
            throw new AgentNotFoundException("id not found ......");
        }
        return ResponseEntity.ok(agent);
    }

    @PostMapping("/agent")
    public ResponseEntity<String> createAgent(@RequestBody  AgentReqDto agentReqDto){
        agentService.createAgent(agentReqDto);

        return new ResponseEntity<>("Agent Created", HttpStatus.CREATED);
    }

    @PutMapping("/agent")
    public ResponseEntity<String> updateAgent(@RequestBody Agent agent){
        Agent agents =  agentService.updateAgent(agent);
        return  ResponseEntity.ok("agent updated");
    }

    @DeleteMapping("/agent/{id}")
    public ResponseEntity<String> deleteAgent(@PathVariable Long id){
        agentService.delete(id);
        return ResponseEntity.ok("agent deleted");
    }


}
