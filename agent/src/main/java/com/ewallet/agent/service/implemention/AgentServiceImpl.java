package com.ewallet.agent.service.implemention;

import com.ewallet.agent.dto.request.AgentReqDto;
import com.ewallet.agent.dto.response.AgentResDto;
import com.ewallet.agent.entity.Agent;
import com.ewallet.agent.exceptions.AgentNotFoundException;
import com.ewallet.agent.repository.AgentRepository;
import com.ewallet.agent.service.definition.AgentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;

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
    public List<AgentResDto> getAllAgent(){
        List<Agent> agentList = agentRepository.findAll();

        var resAgentList = new ArrayList<AgentResDto>();

        for(Agent agent: agentList){
            var resAgent = new AgentResDto();
            BeanUtils.copyProperties(agent,resAgent);
            resAgentList.add(resAgent);
        }

        return resAgentList;
    }

        @Override
        public AgentResDto findById(String id){
            var agent = agentRepository.findById(Long.parseLong(id)).orElseThrow(()-> new AgentNotFoundException("no found"));
            var resAgent = new AgentResDto();
            BeanUtils.copyProperties(agent,resAgent);
            return resAgent;
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
