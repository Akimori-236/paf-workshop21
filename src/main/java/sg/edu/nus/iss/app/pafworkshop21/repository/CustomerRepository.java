package sg.edu.nus.iss.app.pafworkshop21.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.app.pafworkshop21.model.Customer;

@Repository
public class CustomerRepository {
    
    @Autowired
    JdbcTemplate template;

    private String getAllSQL = "SELECT * FROM customers";

    public List<Customer> getAllCustomers(int limit, int offset) {
        List<Customer> customerList = new LinkedList<>();
        customerList = template.query(getAllSQL, BeanPropertyRowMapper.newInstance(Customer.class));
        return customerList;
    }
}
