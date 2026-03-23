package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeDAO;
import com.example.demo.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeDAO employeeDAO = new EmployeeDAO();

    public Employees getAllEmployees(){return employeeDAO.getAllEmployees();}

    public  void  addEmployee(Employee employee){employeeDAO.addEmployee(employee);}
}
