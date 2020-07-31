package com.admin.employment.repository;

import com.admin.employment.entity.CredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepository extends JpaRepository<CredentialEntity, Long> {
    CredentialEntity findByUsernameAndPassword(String userName, String password);
}

