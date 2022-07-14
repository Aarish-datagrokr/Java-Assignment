package org.datagrokr.assignment.SpringCalculator;

import org.datagrokr.assignment.SpringCalculator.CLI.SpringCalculatorCLI;
import org.datagrokr.assignment.SpringCalculator.SharedFunctions.CalculationMethods;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringCalculatorApplication {
    @Bean
    public CalculationMethods getCalculationMethod() {
        return new CalculationMethods();
    }
	public static void main(String[] args) {
//		SpringApplication.run(SpringCalculatorApplication.class, args);
        SpringCalculatorCLI.runner(args);
	}

}
