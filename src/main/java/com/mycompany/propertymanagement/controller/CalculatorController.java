package com.mycompany.propertymanagement.controller;


import com.mycompany.propertymanagement.DTO.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/CalculatorCNTRL")
public class CalculatorController {

    @GetMapping("/add/{num3}")
    //http://localhost:8080/api/v1/CalculatorCNTRL/add
    public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2,
                      @PathVariable("num3") Double num3){
        //http://localhost:8080/api/v1/CalculatorCNTRL/add?num1=2.5&num2=2.5
        return num1+num2;
    }

    @GetMapping("/sub/{num1}/{num2}")
    public Double subtract(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2){
        Double result;
        if (num1>num2){
            result = num1-num2;
        }else{
            result = num2-num1;
        }
        return result;
    }

    @PostMapping("/mul") //post mapping need json type to get send to the server, you need to define the key value different with GET as method not allowed
    public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calDTO){
        Double result;
        result = calDTO.getNum1() * calDTO.getNum2() * calDTO.getNum3() * calDTO.getNum4();
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

}
