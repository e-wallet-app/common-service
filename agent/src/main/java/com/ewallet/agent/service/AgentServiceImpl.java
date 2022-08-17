package com.ewallet.agent.service;

import com.ewallet.agent.dto.request.AgentReqDto;
import com.ewallet.agent.dto.response.AgentResDto;
import com.ewallet.agent.entity.Agent;
import com.ewallet.agent.exceptions.AgentNotFoundException;
import com.ewallet.agent.repository.AgentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentServiceImpl implements AgentService{

    private AgentRepository agentRepository;

    AgentServiceImpl(AgentRepository agentRepository){
        this.agentRepository = agentRepository;
    }


    @Override
    public Agent createAgent(AgentReqDto agentReqDto) {
        Agent agent = new Agent();

        BeanUtils.copyProperties(agentReqDto,agent);
        agentRepository.save(agent);
        return agent;
    }

    @Override
    public List<Agent> findAll() {
        return agentRepository.findAll();
    }

    @Override
    public Agent findById(Long id)
    {
        Optional<Agent> agentId = agentRepository.findById(id);
        Agent agent = null;
        if (agentId.isPresent()){
            agent = agentId.get();
        }
        else {
            throw  new AgentNotFoundException("id not found  : "+id);
        }
        return agent;
    }

    @Override
    public void updateAgent(String id, AgentReqDto agentReqDto)
    {
        var agent = agentRepository.findById(Long.parseLong(id)).orElseThrow(() -> new RuntimeException("Not Found"));
        BeanUtils.copyProperties(agentReqDto,agent);
        agentRepository.save(agent);
    }

    @Override
    public Agent updateAgent(Agent agent) {
        agentRepository.save(agent);
        return agent;
    }

    @Override
    public void delete(Long id) {
        agentRepository.deleteById(id);
    }


}
