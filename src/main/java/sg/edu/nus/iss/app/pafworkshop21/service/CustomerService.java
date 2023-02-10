package sg.edu.nus.iss.app.pafworkshop21.service;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sg.edu.nus.iss.app.pafworkshop21.model.Customer;
import sg.edu.nus.iss.app.pafworkshop21.repository.CustomerRepository;
import sg.edu.nus.iss.app.pafworkshop21.util.JsonUtil;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository custRepo;

    @Autowired
    ObjectMapper json;

    public List<Customer> getAllCustomers(Integer limit, Integer offset) throws JsonProcessingException, SQLException, UnsupportedEncodingException {
        List<Customer> custList = custRepo.getAllCustomers(limit, offset);
        for (Customer cust : custList) {
            Blob blob = cust.getAttachments();
            String s = JsonUtil.blobToString(blob);
            cust.setAttachmentString(s);
            cust.setAttachments(null);
        }
        return custList;
    }

    public String getCustomerById(Integer customer_id) {
        return null;
    }

    public String getCustomerOrders(Integer customer_id) {
        return null;
    }


    public byte[] getAttachment(Integer customer_id) {
        return custRepo.getAttachment(customer_id);
    }
}