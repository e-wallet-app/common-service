package com.ewallet.agent.service.implemention;

import com.ewallet.agent.dto.request.AgentReqDto;
import com.ewallet.agent.dto.response.AgentResDto;
import com.ewallet.agent.entity.Agent;
import com.ewallet.agent.enums.Gender;
import com.ewallet.agent.enums.Role;
import com.ewallet.agent.exceptions.AgentNotFoundException;
import com.ewallet.agent.repository.AgentRepository;
import com.ewallet.agent.repository.AttachmentRepository;
import com.ewallet.agent.service.definition.AgentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;
    private final AttachmentRepository attachmentRepository;

    AgentServiceImpl(AgentRepository agentRepository,AttachmentRepository attachmentRepository){
        this.agentRepository = agentRepository;
        this.attachmentRepository = attachmentRepository;
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
//            var resAgent = new AgentResDto();
//            BeanUtils.copyProperties(agent,resAgent);
//            var resAgent = entityToDto(agent);
            return entityToDto(agent);
        }

    @Override
    public Agent updateAgent(Agent agent) {
        agentRepository.save(agent);
        return agent;
    }

    @Override
    public void delete(String id) {
        agentRepository.deleteById(Long.parseLong(id));
    }

    @Override
    public AgentResDto entityToDto(Agent agent){

        var agentResponse = new AgentResDto();
        BeanUtils.copyProperties(agent,agentResponse);
        agentResponse.setBirthDate(agent.getBirthDate().toString());
        agentResponse.setRole(Role.ROLE_AGENT.toString());
        agentResponse.setStatus(agent.getStatus().toString());
        agentResponse.setGender(agent.getGender().toString());

        return agentResponse;

    }

    @Override
    public Agent dtoToEntity(AgentReqDto agentReqDto){

        Agent agent = new Agent();
        BeanUtils.copyProperties(agentReqDto,agent);
        var birthDay = LocalDateTime.parse(agentReqDto.getBirthDate());
        agent.setBirthDate(birthDay);
        agent.setRole(Role.ROLE_AGENT);
        agent.setGender(Gender.valueOf(agentReqDto.getGender()));

        return agent;
    }


}
