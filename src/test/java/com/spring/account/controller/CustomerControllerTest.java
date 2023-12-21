package com.spring.account.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(controllers = CustomerController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

  /*  @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Autowired
    private ObjectMapper objectMapper;

    private Customer customer;



    @BeforeEach
    public void testInitialization(){
        UUID customerId = UUID.randomUUID();
        customer = Customer.builder().customerId(customerId).name("Reshmi").emailId("reshmi@gmail.com").build();
    }

    @Test
    public void customerController_CreateCustomer_ReturnCreated() throws Exception{
        when(customerService.saveCustomer(customer)).thenReturn(customer);

        ResultActions response = mockMvc.perform(post("/customer/register/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isOk());

    }
*/



}
