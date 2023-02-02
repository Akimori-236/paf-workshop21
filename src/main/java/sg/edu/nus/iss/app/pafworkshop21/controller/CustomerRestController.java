package sg.edu.nus.iss.app.pafworkshop21.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import sg.edu.nus.iss.app.pafworkshop21.model.Customer;
import sg.edu.nus.iss.app.pafworkshop21.service.CustomerService;

@RestController
@RequestMapping(path = "/api")
public class CustomerRestController {

    @Autowired
    private CustomerService custSvc;

    @GetMapping(path = "/customers")
    public ResponseEntity<List<Customer>> getCustomers(
            @RequestParam(value = "offset", defaultValue = "0") String offset,
            @RequestParam(value = "limit", defaultValue = "5") String limit) throws JsonProcessingException {
        List<Customer> customerList = custSvc.getAllCustomers(limit, offset);
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    // @GetMapping(path = "/customer/{customer_id}", consumes = "application/json")
    // public ResponseEntity<String> getCustomerById(@PathVariable String
    // customer_id) {
    // String jsonStr = customerRepo.getCustomerById(customer_id);
    // if (jsonStr == "" || jsonStr == null) {
    // return ResponseEntity
    // .status(HttpStatus.NOT_FOUND)
    // .contentType(MediaType.APPLICATION_JSON)
    // .body(JsonUtil.notFoundJson(customer_id));
    // }
    // return ResponseEntity
    // .status(HttpStatus.OK)
    // .contentType(MediaType.APPLICATION_JSON)
    // .body(jsonStr);
    // }

    // @GetMapping(path = "/customer/{customer_id}/orders", consumes =
    // "application/json")
    // public ResponseEntity<String> getCustomerOrders(@PathVariable String
    // customer_id) {
    // String jsonStr = customerSvc.getCustomerOrders(customer_id);
    // if (jsonStr == "" || jsonStr == null) {
    // return ResponseEntity
    // .status(HttpStatus.NOT_FOUND)
    // .contentType(MediaType.APPLICATION_JSON)
    // .body(JsonUtil.notFoundJson(customer_id));
    // }
    // return ResponseEntity
    // .status(HttpStatus.OK)
    // .contentType(MediaType.APPLICATION_JSON)
    // .body(jsonStr);
    // }
}
