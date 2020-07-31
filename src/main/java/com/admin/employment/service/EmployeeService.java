package com.admin.employment.service;

import com.admin.employment.dto.EmployeeDTO;
import com.admin.employment.entity.EmployeeEntity;
import com.admin.employment.mapper.EmployeeMapper;
import com.admin.employment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeDTO insertEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = employeeMapper.dtoToDomain(employeeDTO);
        return employeeMapper.domainToDTO(employeeRepository.save(employeeEntity));
    }

    public List<EmployeeDTO> searchEmployee(Integer minAge, Integer maxAge, String gender) {
        List<EmployeeEntity> employees = employeeRepository.searchByGenderAndAgeCriteria(gender, minAge, maxAge);
        if(CollectionUtils.isEmpty(employees)) {
            return Collections.EMPTY_LIST;
        }
        return employees.stream().map(emp -> employeeMapper.domainToDTO(emp)).collect(Collectors.toList());
    }
}
