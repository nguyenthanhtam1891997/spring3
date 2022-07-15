package com.example.backendspring3.service.impl;

import com.example.backendspring3.common.MyException;
import com.example.backendspring3.dto.CustomerDtoForm;
import com.example.backendspring3.dto.CustomerHandelDto;
import com.example.backendspring3.dto.JoinCustomerDto;
import com.example.backendspring3.model.*;
import com.example.backendspring3.repository.ICustomerRepository;
import com.example.backendspring3.repository.IUserRepository;
import com.example.backendspring3.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAllPage(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }


    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer checkCustomer(String name) {
        return customerRepository.checkCustomer(name);
    }

    @Override
    public JoinCustomerDto joinCustomer() {
        System.out.println(customerRepository.joinCustomer().toString());
        return customerRepository.joinCustomer();
    }

    @Override
    public Customer getCheckCustomer() {
        return customerRepository.getCheckCustomer();
    }

    @Override
    public User getCheckUser() {
        return customerRepository.getCheckUser();
    }

    @Override
    public List<OderBook> getCheckOderBook() {
        return customerRepository.getCheckOderBook();
    }

    @Override
    public CustomerHandelDto add(CustomerDtoForm customerDtoForm)  {
//        try {throws MyException
            Customer customer = new Customer();
            customer.setName(customerDtoForm.getUserName());
            customer.setPhone(customerDtoForm.getPhone());
            customer.setAddress(customerDtoForm.getAddress());
            List<Role> roleList = new ArrayList<>();
            roleList.add(new Role(3L, RoleName.ROLE_USER));
            User user = new User(customerDtoForm.getUserName(), customerDtoForm.getEmail(), passwordEncoder.encode(customerDtoForm.getPassword()), roleList);
            userRepository.save(user);
            customer.setUser(user);
            customerRepository.save(customer);
            CustomerHandelDto customerHandelDto = new CustomerHandelDto(customer.getName(),customer.getPhone(),customer.getAddress());
            return customerHandelDto;

//        }catch (RuntimeException e){
//            e.printStackTrace();
//            throw new MyException("e1");
//        }



    }

//    @Override
//    public User getCheckUser() {
//        return customerRepository.getCheckUser();
//    }
}
