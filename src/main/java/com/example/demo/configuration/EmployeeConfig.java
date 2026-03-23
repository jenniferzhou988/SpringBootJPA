package com.example.demo.configuration;

import com.example.demo.service.EmpService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

    @Bean
    public EmpService employeeBean(){
        return new EmpService();
    }

    @Bean
    public ModelMapper modelMapperBean(){
        return new ModelMapper();

    }
}
