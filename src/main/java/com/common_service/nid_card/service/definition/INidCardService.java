package com.common_service.nid_card.service.definition;

import com.common_service.nid_card.entity.NidCard;


import java.util.UUID;

public interface INidCardService
{
    NidCard getNidCard(UUID id);
}
