package org.datagrokr.assignment.SpringCalculator;

import org.datagrokr.assignment.SpringCalculator.SharedFunctions.CalculationMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SpringCalculator {

    @Autowired
    private CalculationMethods calculationMethods;

    @GetMapping("/")
    public String check() {
        return "Working fine";
    }

    @GetMapping("/add")
    public String additionOfNumbers(@RequestHeader("num1") int num1, @RequestHeader("num2") int num2) {
        return calculationMethods.add(num1,num2);
    }

    @GetMapping("/subtract")
    public String subtractionOfNumbers(@RequestHeader("num1") int num1, @RequestHeader("num2") int num2) {
        return calculationMethods.subtract(num1,num2);
    }

    @GetMapping("/multiply")
    public String multiplicationOfNumbers(@RequestHeader("num1") int num1, @RequestHeader("num2") int num2) {
        return calculationMethods.multiply(num1,num2);
    }

    @GetMapping("/divide")
    public String divisionOfNumbers(@RequestHeader("num1") int num1, @RequestHeader("num2") int num2) {
        return calculationMethods.divide(num1,num2);
    }

}
