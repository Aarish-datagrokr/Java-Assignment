package org.datagrokr.assignment.SpringCalculator.CLI;

import org.datagrokr.assignment.SpringCalculator.SpringCalculatorApplication;
import org.springframework.boot.SpringApplication;


public class SpringCalculatorCLI {
    public static void runner(String[] args) {
        SpringApplication.run(SpringCalculatorApplication.class, args);
    }

}
