package com.admin.employment.mapper;

import com.admin.employment.dto.EmployeeDTO;
import com.admin.employment.entity.EmployeeEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public EmployeeEntity dtoToDomain(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setAge(employeeDTO.getAge());
        employeeEntity.setGender(employeeDTO.getGender());
        employeeEntity.setId(employeeDTO.getId());
        employeeEntity.setName(employeeDTO.getName());

        return employeeEntity;
    }

    public EmployeeDTO domainToDTO(EmployeeEntity employeeEntity) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setAge(employeeEntity.getAge());
        employeeDTO.setGender(employeeEntity.getGender());
        employeeDTO.setId(employeeEntity.getId());
        employeeDTO.setName(employeeEntity.getName());

        return employeeDTO;
    }
}
