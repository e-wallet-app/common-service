package com.ewallet.agent.controller.definition;

import com.ewallet.agent.dto.request.AgentReqDto;
import com.ewallet.agent.dto.response.AgentResDto;
import com.ewallet.agent.entity.Agent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/agent/")
public interface IAgentController {

    @GetMapping("agent")
    public ResponseEntity<List<AgentResDto>> allAgent();

    @GetMapping("{id}")
    public ResponseEntity<AgentResDto> getAgent(@PathVariable String id);

    @PostMapping("agent")
    public ResponseEntity<String> createAgent(@RequestBody AgentReqDto agentReqDto);

    @PutMapping("/agent")
    public ResponseEntity<String> updateAgent(@RequestBody Agent agent);

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAgent(@PathVariable String id);
}
