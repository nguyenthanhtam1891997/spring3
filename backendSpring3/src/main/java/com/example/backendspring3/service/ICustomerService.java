package com.example.backendspring3.service;

import com.example.backendspring3.common.MyException;
import com.example.backendspring3.dto.CustomerDtoForm;
import com.example.backendspring3.dto.CustomerHandelDto;
import com.example.backendspring3.dto.JoinCustomerDto;
import com.example.backendspring3.model.Customer;
import com.example.backendspring3.model.OderBook;
import com.example.backendspring3.model.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
    Customer checkCustomer(String name);

    JoinCustomerDto joinCustomer();

    Customer getCheckCustomer();

    User getCheckUser();

    List<OderBook> getCheckOderBook();

    CustomerHandelDto add(CustomerDtoForm customerDtoForm);
}
