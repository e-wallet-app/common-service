package com.common_service.nid_card.service.implementation;


import com.common_service.exceptions.NotFoundException;
import com.common_service.nid_card.entity.NidCard;
import com.common_service.nid_card.repository.NidCardRepository;
import com.common_service.nid_card.service.definition.INidCardService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class NidCardServiceImpl implements INidCardService
{

    private final NidCardRepository nidCardRepository;

    public NidCardServiceImpl(NidCardRepository nidCardRepository) {
        this.nidCardRepository = nidCardRepository;
    }

    @Override
    public NidCard getNidCard(UUID id)
    {
        var nidCard = nidCardRepository.findById(id).orElseThrow(() -> new NotFoundException("Nid card not found"));
        return nidCard;
    }
}
