package com.admin.employment.controller;

import com.admin.employment.dto.EmployeeDTO;
import com.admin.employment.dto.ErrorMessageDTO;
import com.admin.employment.service.EmployeeService;
import com.admin.employment.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ManageEmployeeController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        if(!loginService.isUserLoggedIn()) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorMessageDTO("User is not logged in."));
        }

        EmployeeDTO employee = employeeService.insertEmployee(employeeDTO);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/employee")
    public ResponseEntity searchEmployee(@RequestParam Integer minAge,
                                         @RequestParam Integer maxAge,
                                         @RequestParam String gender) {
        if(!loginService.isUserLoggedIn()) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorMessageDTO("User is not logged in."));
        }
        return ResponseEntity.ok().body(employeeService.searchEmployee(minAge, maxAge, gender));
    }
}
