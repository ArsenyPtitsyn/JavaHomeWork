package lesson4;

import java.util.Arrays;

public class HomeWork4 {
    public static void main(String[] args) {
        double averageAge, averageSalary;
        // 5. Create array of 5 employees
        Employee[] employees = new Employee[5];
        // Initialization
        employees[0] = new Employee("Pupkin Vasily Ivanovich", 32154, 1995);
        employees[1] = new Employee("Ivanov Ivan Ivanovich", 37162, 1975);
        employees[2] = new Employee("Popov Igor Konstantinovich", 57123, 1970);
        employees[3] = new Employee("Drozdov Nikolay Egorovich", 123427, 1968);
        employees[4] = new Employee("Terkin Vasily Nikolaevich", 27953, 1980);
        // 4. Use the methods to get the full name and age for all employees.
        printEmployeeInfo(employees[0]);
        printEmployeeInfo(employees[1]);
        printEmployeeInfo(employees[2]);
        printEmployeeInfo(employees[3]);
        printEmployeeInfo(employees[4]);

        System.out.println();

        // Output information about employees over 40 years of age
        employeesOverFortyYearsInfo(employees);

        System.out.println();

        // Salary increase for employees over 45 years of age
        System.out.println("Salary before: " + employees[2].getSalary() + " and " +
                employees[3].getSalary());
        Employee.increaseSalary(employees);
        System.out.println("Salary after: " + employees[2].getSalary() + " and " +
                employees[3].getSalary());

        System.out.println();

        // Averages of ages and salaries of all employees
        System.out.println("Average ages and salaries of all emloyees are: " +
                Employee.averageOfTheAges(employees) + " and " +
                Employee.averageOfTheSalaries(employees));

        System.out.println();

        // Output information about identification numbers of employees.
        printId(employees);
    }

    private static void employeesOverFortyYearsInfo(Employee[] e) {
        for(int i = 0; i < e.length; i++) {
            if(e[i].getAge() > 40)
                printEmployeeInfo(e[i]);
        }
    }

    private static void printEmployeeInfo(Employee e) {
        System.out.println(e.getFullName() + ". Age: " +
                e.getAge());
    }

    private static void printId(Employee[] e) {
        for(int i = 0; i < e.length; i++) {
            System.out.println(e[i].getFullName() + " id: " + e[i].getId());
        }
    }
}
