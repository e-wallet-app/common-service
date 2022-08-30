package com.common_service.nid_card.repository;


import com.common_service.nid_card.entity.NidCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface NidCardRepository extends JpaRepository<NidCard, UUID>
{
}
