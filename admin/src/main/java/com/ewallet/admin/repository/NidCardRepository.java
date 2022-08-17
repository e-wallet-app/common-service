package com.ewallet.admin.repository;

import com.ewallet.admin.entity.NidCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface NidCardRepository extends JpaRepository<NidCard, UUID>
{
}
