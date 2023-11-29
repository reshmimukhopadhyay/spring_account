package com.spring.account.service;

import com.spring.account.entity.Customer;
import com.spring.account.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void customerService_CreateCustomer_ReturnCustomerNotNull(){
        Customer customer = Customer.builder().name("Reshmi").emailId("reshmi@gmail.com").address("test address").build();

        when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(customer);

        Customer savedCustomer = customerService.saveCustomer(customer);
        Assertions.assertThat(savedCustomer).isNotNull();
    }

    public

}
