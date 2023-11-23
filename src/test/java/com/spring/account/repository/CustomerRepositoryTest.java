package com.spring.account.repository;

import com.spring.account.entity.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;


    @Test
    public void customerRepository_SaveCustomer_ReturnSavedCustomer(){

        //Arrange
        Customer customer = Customer.builder().name("Reshmi").emailId("reshmi@gmail.com").address("test address").build();
        //Act
        Customer saveCustomer = customerRepository.save(customer);
        //Assert
        Assertions.assertThat(saveCustomer).isNotNull();
    }


    @Test
    public void customerRepository_findAllCustomer_ReturnAllCustomerList(){
        Customer customer1 = Customer.builder().name("Reshmi").emailId("reshmi@gmail.com").address("test address").build();
        Customer customer2 = Customer.builder().name("Raji").emailId("raji@gmail.com").address("test address").build();

        customerRepository.save(customer1);
        customerRepository.save(customer2);

        List<Customer> customerList = customerRepository.findAll();

        Assertions.assertThat(customerList).isNotNull();
        Assertions.assertThat(customerList.size()).isEqualTo(2);
    }


    @Test
    public void customerRepository_getCustomerById_ReturnCustomer(){
        Customer customer = Customer.builder().name("Reshmi").emailId("reshmi@gmail.com").address("test address").build();

        customerRepository.save(customer);
        Customer customerId = customerRepository.getReferenceById(customer.getCustomerId());

        Assertions.assertThat(customerId).isNotNull();
    }

    @Test
    public void customerRepository_FindCustomerByEmailId_ReturnCustomerNotNull(){
        Customer customer = Customer.builder().name("Reshmi").emailId("reshmi@gmail.com").address("test address").build();

        customerRepository.save(customer);

        Customer customerEmail= customerRepository.findCustomerByEmailId(customer.getEmailId()).get();

        Assertions.assertThat(customerEmail.getEmailId()).isEqualTo("reshmi@gmail.com");
    }


    @Test
    public void customerRepository_UpdateCustomer_ReturnUpdatedCustomerNotNull(){
        Customer customer = Customer.builder().name("Reshmi").emailId("reshmi@gmail.com").address("test address").build();

        customerRepository.save(customer);

        Customer savedCustomer = customerRepository.findById(customer.getCustomerId()).get();

        savedCustomer.setAddress("Test1 address");

        Customer updatedCustomer = customerRepository.save(savedCustomer);

        Assertions.assertThat(updatedCustomer.getAddress()).isNotNull();
        Assertions.assertThat(updatedCustomer.getAddress()).isEqualTo("Test1 address");
    }


}
