package com.example.employeewebapi.controller;

import com.example.employeewebapi.Model.Employee;
import com.example.employeewebapi.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepo employeeRepository;


    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        try {
            return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get the employee by id
     *
     * @param id
     * @return ResponseEntity
     */
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
        try {
            //check if employee exist in database
            Employee empObj = getEmployeeRecord(id);

            if (empObj != null) {
                return new ResponseEntity<>(empObj, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Create new employee
     *
     * @param employee
     * @return ResponseEntity
     */
    @PostMapping("/employee")
    public ResponseEntity<Employee> newEmployee(@RequestBody Employee employee) {
        try {
            Employee newEmployee = employeeRepository
                    .save(employee);
            return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Update employee record by using its id
     *
     * @param id
     * @param employee
     * @return
     */
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {

        //check if employee exist in database
        Employee empObj = getEmployeeRecord(id);

        if (empObj != null) {
            empObj.setFIRSTNAME(employee.getFIRSTNAME());
            empObj.setLASTNAME(employee.getLASTNAME());
            empObj.setEMAILADDRESS(employee.getEMAILADDRESS());
            empObj.setJOBTITLE(employee.getJOBTITLE());
            empObj.setDEPARTMENT(employee.getDEPARTMENT());
            empObj.setLOCATION(employee.getLOCATION());
            empObj.setMANAGERREPORTING(employee.getMANAGERREPORTING());
            empObj.setBIRTHDATE(employee.getBIRTHDATE());
            empObj.setSTARTDATE(employee.getSTARTDATE());
            empObj.setPHONE(employee.getPHONE());
            return new ResponseEntity<>(employeeRepository.save(empObj), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Delete Employee by Id
     *
     * @param id
     * @return ResponseEntity
     */
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable("id") long id) {
        try {
            //check if employee exist in database
            Employee emp = getEmployeeRecord(id);

            if (emp != null) {
                employeeRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * Method to get the employee record by id
     *
     * @param id
     * @return Employee
     */
    private Employee getEmployeeRecord(long id) {
        Optional<Employee> empObj = employeeRepository.findById(id);

        if (empObj.isPresent()) {
            return empObj.get();
        }
        return null;
    }

}
