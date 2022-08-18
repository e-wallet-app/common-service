package com.ewallet.agent.service.definition;

import com.ewallet.agent.dto.request.AgentReqDto;
import com.ewallet.agent.dto.response.AgentResDto;
import com.ewallet.agent.entity.Agent;

import java.util.List;

public interface AgentService {

    public Agent createAgent(AgentReqDto agentReqDto);
//    public List<Agent> findAll();
    public List<AgentResDto> getAllAgent();
    public AgentResDto findById(String id);

    public Agent updateAgent(Agent agent);

   public void delete(Long id);
}
