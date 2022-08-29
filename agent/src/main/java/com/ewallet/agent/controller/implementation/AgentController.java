package com.ewallet.agent.controller.implementation;

import com.ewallet.agent.controller.definition.IAgentController;
import com.ewallet.agent.dto.request.AgentReqDto;
import com.ewallet.agent.dto.response.AgentResDto;
import com.ewallet.agent.entity.Agent;
import com.ewallet.agent.exceptions.AgentNotFoundException;
import com.ewallet.agent.service.definition.AgentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgentController implements IAgentController {

    private AgentService agentService;

    private AgentController(AgentService agentService){
        this.agentService = agentService;
    }

    @Override
    public ResponseEntity<List<AgentResDto>> allAgent()
    {
        var agent =  agentService.getAllAgent();
        return ResponseEntity.ok(agent);
    }

    @Override
    public ResponseEntity<AgentResDto> getAgent(@PathVariable String id){
        var agent = agentService.findById(id);
        if(agent == null){
            throw new AgentNotFoundException("id not found ......");
        }
        return ResponseEntity.ok(agent);
    }

    @Override
    public ResponseEntity<String> createAgent(@RequestBody  AgentReqDto agentReqDto){
        agentService.createAgent(agentReqDto);
        return new ResponseEntity<>("Agent Created", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> updateAgent(@RequestBody Agent agent){
        Agent agents =  agentService.updateAgent(agent);
        return  ResponseEntity.ok("agent updated");
    }

    @Override
    public ResponseEntity<String> deleteAgent(@PathVariable String id){
        agentService.delete(id);
        return ResponseEntity.ok("agent deleted");
    }


}
