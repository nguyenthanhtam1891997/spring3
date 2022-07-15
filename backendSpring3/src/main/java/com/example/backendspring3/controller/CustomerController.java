package com.example.backendspring3.controller;

import com.example.backendspring3.common.ControllerCommon;
import com.example.backendspring3.common.MyException;
import com.example.backendspring3.dto.CustomerDtoForm;
import com.example.backendspring3.dto.JoinCustomerDto;
import com.example.backendspring3.model.*;
import com.example.backendspring3.service.ICustomerService;
import com.example.backendspring3.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/customer")
@RestController
@CrossOrigin("*")
public class CustomerController extends ControllerCommon {

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
    public ResponseEntity<? extends Object> createCustomer(@Valid @RequestBody CustomerDtoForm customerDtoForm, BindingResult bindingResult) throws MyException {
        mapError.clear();
        mapSuccess.clear();
        if (bindingResult.hasFieldErrors()) {
            Map<String, Object> response = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                mapError.put(error.getField(), error.getDefaultMessage());
            });
            response.put("error", mapError);
            return ero("e1", response);
        } else {

//            Customer customer = new Customer();
//            customer.setName(customerDtoForm.getUsername());
//            customer.setPhone(customerDtoForm.getPhone());
//            customer.setAddress(customerDtoForm.getAddress());
//            List<Role> roleList = new ArrayList<>();
//            roleList.add(new Role(3L, RoleName.ROLE_USER));
//            User user = new User(customerDtoForm.getUsername(), customerDtoForm.getEmail(), passwordEncoder.encode(customerDtoForm.getPassword()), roleList);
//            userService.save(user);
//            customer.setUser(user);
//            customerService.save(customer);
//            return new ResponseEntity<>(HttpStatus.OK);

            try {
                return ok("s1", customerService.add(customerDtoForm));
            } catch (RuntimeException e) {
                throw new MyException("s1");
            }


        }
    }

    @GetMapping("")
    public ResponseEntity<?> checkCustomer(@RequestParam(value = "", required = true) String name) {
        Customer customer = customerService.checkCustomer(name);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }


    }

    @GetMapping("/join")
    public ResponseEntity<?> getJoin() throws MyException {

        JoinCustomerDto joinCustomerDto = customerService.joinCustomer();

//        joinCustomerDto = null;
        if (joinCustomerDto == null) {
            throw new MyException("e1");

        } else {
            return ok("s1", joinCustomerDto);
        }
//        return null;
    }


    @GetMapping("/role")
    public ResponseEntity<?> getRole() {

        User user = customerService.getCheckUser();
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
//        return null;
    }

    @GetMapping("/oder")
    public ResponseEntity<?> getOder() {
        List<OderBook> oderBook = customerService.getCheckOderBook();
        if (oderBook == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(oderBook, HttpStatus.OK);
        }
    }

}
