package com.m2i.apifilrougecrm.repository;

import com.m2i.apifilrougecrm.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
