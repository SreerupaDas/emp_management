package com.admin.employment.repository;

import com.admin.employment.entity.CredentialEntity;
import com.admin.employment.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    @Query("select e from EmployeeEntity e where upper(e.gender) = upper(?1) and e.age >= ?2 and e.age <= ?3")
    List<EmployeeEntity> searchByGenderAndAgeCriteria(String gender, int minAge, int maxAge);
}
