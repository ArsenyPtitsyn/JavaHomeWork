package lesson4;
// 1. Create class "Employee" with the fields: full name, salary and age.
public class Employee {

    private String fullName;
    private int birthDay;
    private int salary;
    private int id;

    private int year = 2020;
    private static int index = 0;
    // 2. The class constructor must fill this fields when creating the object
    // 8. Think through the constructor so that each employee is assigned a
    // personal unique identification sequence number when creating it
    public Employee(String fullName, int salary, int birthDay) {
        this.id = index++;
        this.fullName = fullName;
        this.salary = salary;
        this.birthDay = birthDay;
    }
    // 3. Inside the employee class, write methods that return the value of each field
    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return year - birthDay;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }
    // 6. Create method that increases the salary of all employees over 45 years of age by 5000.
    public static void increaseSalary(Employee[] e) {
        for(int i = 0; i < e.length; i++) {
            if(e[i].getAge() > 45)
                e[i].salary += 5000;
        }
    }
    // 7a. To calculate the average age.
    public static float averageOfTheAges(Employee[] e) {
        int sumOfAges = 0;
        for(int i = 0; i < e.length; i++) {
            sumOfAges += e[i].getAge();
        }
        return sumOfAges / (float)e.length;
    }
    // 7b. To calculate the average salary.
    public static float averageOfTheSalaries(Employee[] e) {
        int sumOfSalaries = 0;
        for(int i = 0; i < e.length; i++) {
            sumOfSalaries += e[i].salary;
        }
        return sumOfSalaries / (float)e.length;
    }
}
