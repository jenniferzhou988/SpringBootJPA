package com.example.demo.service;

import com.example.demo.model.Emp;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class EmpService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper mapper;
    public EmployeeResponse getEmployeeById(int id){
        Optional<Emp> employee = employeeRepo.findById(id);
        EmployeeResponse employeeResponse = mapper.map(employee,EmployeeResponse.class);
        return employeeResponse;
    }
}
