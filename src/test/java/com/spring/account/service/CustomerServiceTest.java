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

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Test
    public void customerService_findAllCustomer_ReturnListOfCustomer(){
        Customer customer1 = Customer.builder().name("Reshmi").emailId("reshmi@gmail.com").address("test address").build();
        Customer customer2 = Customer.builder().name("Nanda").emailId("nanda@gmail.com").address("test address").build();
        when(customerRepository.findAll()).thenReturn(List.of(customer1,customer2));

        List<Customer> savedCustomer =customerService.findAllCustomer();
        Assertions.assertThat(savedCustomer.size()).isEqualTo(2);
    }

    @Test
    public void customerService_FindCustomerById_ReturnCustomerNotNull(){
        UUID customerId = UUID.randomUUID();
        Customer customer= Customer.builder().name("Reshmi").emailId("reshmi@gmail.com").address("test address").build();

        when(customerRepository.findById(customerId)).thenReturn(Optional.ofNullable(customer));

        Optional<Customer> savedCustomer = customerService.findCustomerById(customerId);

        Assertions.assertThat(savedCustomer).isNotNull();
    }

    @Test
    public void customerService_FindCustomerByEmailId_ReturnCustomerNotNull(){
        String customerEmail = "reshmi@gmail.com";
        Customer customer = Customer.builder().name("Reshmi").emailId("reshmi@gmail.com").address("test address").build();
        when(customerRepository.findCustomerByEmailId(customerEmail)).thenReturn(Optional.ofNullable(customer));

        Optional<Customer> savedCustomer = customerService.findCustomerByEmailId(customerEmail);

        Assertions.assertThat(savedCustomer).isNotNull();
    }

}
