package com.ewallet.admin.service.implementation;

import com.ewallet.admin.entity.NidCard;
import com.ewallet.admin.exceptions.NotFoundException;
import com.ewallet.admin.repository.NidCardRepository;
import com.ewallet.admin.service.definition.NidCardService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class NidCardServiceImpl implements NidCardService
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
