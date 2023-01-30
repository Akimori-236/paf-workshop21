package sg.edu.nus.iss.app.pafworkshop21.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.app.pafworkshop21.service.CustomerService;
import sg.edu.nus.iss.app.pafworkshop21.util.JsonUtil;

@RestController
@RequestMapping(path = "/api")
public class NorthwindRestController {

    @Autowired
    private CustomerService customerSvc;

    @GetMapping(path = "/customers", consumes = "application/json")
    public ResponseEntity<String> getCustomers(@RequestParam(defaultValue = "0") String offset,
            @RequestParam(defaultValue = "5") String limit) {
        String jsonStr = customerSvc.getCustomers(offset, limit);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonStr);
    }

    @GetMapping(path = "/customer/{customer_id}", consumes = "application/json")
    public ResponseEntity<String> getCustomerById(@PathVariable String customer_id) {
        String jsonStr = customerSvc.getCustomerById(customer_id);
        if (jsonStr == "" || jsonStr == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(JsonUtil.notFoundJson(customer_id));
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonStr);
    }

    @GetMapping(path = "/customer/{customer_id}/orders", consumes = "application/json")
    public ResponseEntity<String> getCustomerOrders(@PathVariable String customer_id) {
        String jsonStr = customerSvc.getCustomerOrders(customer_id);
        if (jsonStr == "" || jsonStr == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(JsonUtil.notFoundJson(customer_id));
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonStr);
    }
}
