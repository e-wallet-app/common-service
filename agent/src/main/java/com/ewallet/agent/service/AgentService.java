package com.ewallet.agent.service;

import com.ewallet.agent.dto.request.AgentReqDto;
import com.ewallet.agent.dto.response.AgentResDto;
import com.ewallet.agent.entity.Agent;

import java.util.List;

public interface AgentService {

    public Agent createAgent(AgentReqDto agentReqDto);
    public List<Agent> findAll();
    public Agent findById(Long id);
    public void updateAgent(String id, AgentReqDto agentReqDto);

   public Agent updateAgent(Agent agent);

   public void delete(Long id);
}
