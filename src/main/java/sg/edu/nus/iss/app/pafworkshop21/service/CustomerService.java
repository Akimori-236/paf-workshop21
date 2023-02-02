package sg.edu.nus.iss.app.pafworkshop21.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sg.edu.nus.iss.app.pafworkshop21.model.Customer;
import sg.edu.nus.iss.app.pafworkshop21.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository custRepo;

    @Autowired
    ObjectMapper json;

    public List<Customer> getAllCustomers(String limit, String offset) throws JsonProcessingException {
        List<Customer> custList = custRepo.getAllCustomers(Integer.parseInt(limit), Integer.parseInt(offset));
        return custList;
    }

    public String getCustomerById(String customer_id) {
        return null;
    }

    public String getCustomerOrders(String customer_id) {
        return null;
    }

    
    
}
