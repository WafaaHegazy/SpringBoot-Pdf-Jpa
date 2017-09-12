package me.aboullaite.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.aboullaite.model.Employee;
import me.aboullaite.repo.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repo;


    public List<Employee> findAll() {
        final List<Employee> employees = new ArrayList<Employee>();
        repo.findAll().forEach((e) -> employees.add(e));
        return employees;

    }
}
