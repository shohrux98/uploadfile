package com.malumot.baza.service;


import com.malumot.baza.domain.Employee;
import com.malumot.baza.repository.EmployeeRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee findById(Long id){
        return employeeRepository.findById(id).get();
    }

    public List<Employee> findByNameQuery(String name){
        return employeeRepository.findByNameQuery(name);
    }

    public List<Employee> findAllByParam(String name){
        return employeeRepository.findAllByLike(name);
    }

    public void delete(Long id){
        Employee employee = employeeRepository.getReferenceById(id);
        employeeRepository.delete(employee);
    }
    @Scheduled(cron = "0 38 01 * * *")
    public Employee saveSch(){
        Employee employee1 = new Employee();
        employee1.setName("SSSSSSSSSS");
        employee1.setLastName("LLLLLLLLLLL");
        return employeeRepository.save(employee1);
    }
}

