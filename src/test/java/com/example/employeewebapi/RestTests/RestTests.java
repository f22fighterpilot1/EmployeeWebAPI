package com.example.employeewebapi.RestTests;

import com.example.employeewebapi.Model.Employee;
import com.example.employeewebapi.Repository.EmployeeRepo;
import com.example.employeewebapi.controller.EmployeeController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
public class RestTests {

    @MockBean
    private EmployeeRepo employeeRepo;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setFIRSTNAME("firstNameTest");
        employee.setLASTNAME("lastNameTest");

        mockMvc.perform(post("/employee").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    void should_return_employee() throws Exception {
        long id = 1L;
        Employee employee = new Employee();
        employee.setFIRSTNAME("firstNameTest");
        employee.setLASTNAME("lastNameTest");

        when(employeeRepo.findById(id)).thenReturn(Optional.of(employee));
        mockMvc.perform(get("/employee/{id}", id)).andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname").value(employee.getFIRSTNAME()))
                .andExpect(jsonPath("$.lastname").value(employee.getLASTNAME()))
                .andExpect(jsonPath("$.employeeid").value(employee.getEMPLOYEEID()))
                .andDo(print());
    }
}
