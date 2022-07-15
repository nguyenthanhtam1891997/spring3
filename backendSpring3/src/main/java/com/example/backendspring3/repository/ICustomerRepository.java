package com.example.backendspring3.repository;

import com.example.backendspring3.dto.CustomerDtoForm;
import com.example.backendspring3.dto.JoinCustomerDto;
import com.example.backendspring3.model.Customer;

import com.example.backendspring3.model.OderBook;
import com.example.backendspring3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQueries;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c where c.name like %:name% ")
    Customer checkCustomer(@Param("name") String name);

//    CustomerDtoForm getTec

    @Query("select c.name as name,u.email as email,c.phone as phone,u.avatar as avatar " +
            "from Customer c " +
            "join c.user u " +
            "where u.id = 4 ")
    JoinCustomerDto joinCustomer();

    @Query("select c from Customer c where c.id=4 ")
    Customer getCheckCustomer();


    @Query("select u from User u where u.id=5 ")
    User getCheckUser();



    @Query("select o from OderBook o left join o.book b where b.id = 1")
    List<OderBook> getCheckOderBook();

}
