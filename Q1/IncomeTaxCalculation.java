import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Employee {
    private String employeeId;
    private String employeeName;
    private long salary;
    private double tax;

    Employee(String employeeId, String employeeName, long salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.tax=0;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public long getSalary() {
        return salary;
    }

    public void setTax(double tax) {
        this.tax=tax;
    }

    public double getTax() {
        return this.tax;
    }
}

public class IncomeTaxCalculation {
    public static void calculateIncomeTax(List<Employee> employeeList) {
        for(int i=0;i<employeeList.size();i++) {
            long salary = employeeList.get(i).getSalary();
            double tax=0;
            if(salary <= 50000) {
                tax = 0;
            }
            if(salary > 50000 && salary <= 60000) {
                tax = 0.1 * (salary - 50000);
            }
            if(salary > 60000 && salary <= 150000) {
                tax = 0.2 * (salary - 60000);
            }
            if(salary > 150000) {
                tax = 0.3 * (salary - 150000);
            }
            employeeList.get(i).setTax(tax);
        }
        printEmployeeDetails(employeeList);
    }
    public static void printEmployeeDetails(List<Employee> employeeList)
    {
        for(int i=0;i<employeeList.size();i++) {
            String id = employeeList.get(i).getEmployeeId();
            String name = employeeList.get(i).getEmployeeName();
            long salary = employeeList.get(i).getSalary();
            double tax = employeeList.get(i).getTax();
            System.out.println("id       name       salary       tax");
            System.out.println(id+"       "+name+"       "+salary+"       "+tax);
        }
    }
    public static void main(String args[]) throws IOException {
        List<Employee> employeeList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("No of entries : ");
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++) {
            System.out.print("Enter entry no "+(i+1)+" : ");
            String entry = br.readLine();
            String entriesArray[] = entry.split(" ");

            employeeList.add(new Employee(entriesArray[0],entriesArray[1],Long.parseLong(entriesArray[2])));
        }
        calculateIncomeTax(employeeList);
        }
    }

