package org.datagrokr.assignment.SpringCalculator.SharedFunctions;

public class CalculationMethods {

    public String add(int num1, int num2) {
        return num1+" + "+num2+" = "+(num1+num2);
    }

    public String subtract(int num1, int num2) {
        return num1+" - "+num2+" = "+(num1-num2);
    }

    public String multiply(int num1, int num2) {
        return num1+" * "+num2+" = "+(num1*num2);
    }

    public String divide(int num1, int num2) {
        return num1+" / "+num2+" = "+(num1/num2);
    }



}
