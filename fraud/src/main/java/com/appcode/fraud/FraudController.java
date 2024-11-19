package com.appcode.fraud;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

    private  final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponsec isFroudster(
            @PathVariable("customerId") Integer customerID){
        boolean isFraudulentCustomer = fraudCheckService.
                isFraudCustomer(customerID);
        log.info("frousd check request for customer {}", customerID);
        return new FraudCheckResponsec(isFraudulentCustomer);

    }
}
