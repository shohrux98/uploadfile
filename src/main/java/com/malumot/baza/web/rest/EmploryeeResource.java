package com.malumot.baza.web.rest;


import com.malumot.baza.domain.Employee;
import com.malumot.baza.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmploryeeResource {

    private final EmployeeService employeeService;

    public EmploryeeResource(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @PostMapping("/emploryees")
    public ResponseEntity create(@RequestBody Employee employee){
        Employee employee1 = employeeService.save(employee);
        return ResponseEntity.ok(employee1);
    }

    @PutMapping("/emploryees")
    public ResponseEntity update(@RequestBody Employee employee){
        Employee employee1 = employeeService.save(employee);
        return ResponseEntity.ok(employee1);
    }

    @GetMapping("/emploryees")
    public ResponseEntity getAll(){
       List<Employee> employeeList = employeeService.findAll();
        return ResponseEntity.ok(employeeList);
    }
    @GetMapping("/emploryees/{name}")
    public ResponseEntity getAll(@PathVariable String name){
        List<Employee> employeeList = employeeService.findByNameQuery(name);
        return ResponseEntity.ok(employeeList);
    }
    @GetMapping("/emploryees/search")
    public ResponseEntity getAllSearch(@RequestParam String name){
        List<Employee> employeeList = employeeService.findAllByParam(name);
        return ResponseEntity.ok(employeeList);
    }

    @DeleteMapping("/emploryees/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.ok("Qator o`chirildi");
    }

}
