package com.ewallet.admin.service.definition;

import com.ewallet.admin.entity.NidCard;

import java.util.UUID;

public interface NidCardService
{
    NidCard getNidCard(UUID id);
}
