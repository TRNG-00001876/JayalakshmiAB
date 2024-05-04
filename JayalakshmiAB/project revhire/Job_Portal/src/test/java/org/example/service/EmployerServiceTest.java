package org.example.service;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class EmployerServiceTest {
    void testEmployerRegister() {
        // Mocking the User DAO
        User userDAO = mock(User.class);
        EmployerService employerService = new EmployerService(userDAO);

        // Creating a mock employer model
        EmployerModel employerModel = new EmployerModel("JohnDoe", "IT", "john@example.com", "ACME Corp", "password");

        // Calling the service method
        employerService.employerRegister(employerModel);

        // Verifying that the method in the User DAO is called with the correct argument
        verify(userDAO).EmployerRegister(employerModel);
    }

}