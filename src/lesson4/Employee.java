package lesson4;

public class Employee {
    private String surname;
    private String name;
    private String middleName;
    private int salary;
    private int age;

    public Employee(String surname, String name, String middleName, int salary, int age) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.salary = salary;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }
}
