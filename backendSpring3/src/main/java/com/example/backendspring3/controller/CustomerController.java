package com.example.backendspring3.controller;

import com.example.backendspring3.dto.CustomerDtoForm;
import com.example.backendspring3.model.Customer;
import com.example.backendspring3.model.Role;
import com.example.backendspring3.model.RoleName;
import com.example.backendspring3.model.User;
import com.example.backendspring3.service.ICustomerService;
import com.example.backendspring3.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/customer")
@RestController
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private IUserService userService;

    private Map<String, String> mapError = new HashMap<>();
    private Map<String, String> mapSuccess = new HashMap<>();
    private static final String MESSAGE = "message";


    @PostMapping("/create")
    public ResponseEntity<Object> createCustomer(@Valid @RequestBody CustomerDtoForm customerDtoForm) {
        Customer customer = new Customer();
        customer.setName(customerDtoForm.getUsername());
        customer.setPhone(customerDtoForm.getPhone());
        customer.setAddress(customerDtoForm.getAddress());
        List<Role> roleList = new ArrayList<>();
        roleList.add(new Role(3L, RoleName.ROLE_USER));
        User user = new User(customerDtoForm.getUsername(), customerDtoForm.getEmail(), passwordEncoder.encode(customerDtoForm.getPassword()), roleList);
        userService.save(user);
        customer.setUser(user);
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
