package com.spring.account.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.account.entity.Customer;
import com.spring.account.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = CustomerControllerTest.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void customerController_CreateCustomer_ReturnCreated() throws Exception{
        Customer customer = Customer.builder().name("Reshmi").emailId("reshmi@gmail.com").address("test address").build();
        given(customerService.saveCustomer(ArgumentMatchers.any())).willAnswer(invocation -> invocation.getArgument(0));

        ResultActions response = mockMvc.perform(post("/customer/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customer)));
        response.andExpect(MockMvcResultMatchers.status().isCreated());

    }




}
