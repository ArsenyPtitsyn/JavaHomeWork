package lesson4;

import java.util.Arrays;

public class HomeWork4 {

    // 6.	* Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
    // Метод должен принимать в качестве параметра массив сотрудников.
    // Вывести в main() возраст и зарплату сотрудника до и после вызова метода;
    private static void increaser(Employee[] emp, byte age, float increment){
        for (int i = 0; i < emp.length; i++) {
            if (emp[i].getAge() > age) {
                emp[i].setSalary(increment);
                emp[i].isSalaryChanged = true;
            }
        }
    }

    // 7.	** Написать методы (принимающие на вход массив сотрудников),
    // вычисляющие средний возраст и среднюю зарплату сотрудников,
    // вывести результаты работы в консоль.
    private static float averageSalary(Employee[] emp){
        float result = 0;
        for (int i = 0; i < emp.length; i++)
            result += emp[i].getSalary();

        return result / emp.length;
    }

    private static float averageAge(Employee[] emp){
        float result = 0;
        for (int i = 0; i < emp.length; i++)
            result += emp[i].getAge();

        return result / emp.length;
    }

    public static void main(String[] args) {
        // 1.	Создать класс "Сотрудник" с полями: ФИО, должность, телефон,
        // зарплата, возраст;
        Employee e = new Employee("Arseny", "Grigorievich",
                "Ptitsyn", "8(495)000-11-22",
                "physicist", 15000, 1982);

        // 4.	Вывести при помощи методов из пункта 3 ФИО и должность.
        System.out.println("Please welcome our " + e.getPosition() + ", " +
                e.getName() + " " + e.getSecondName() + " " + e.getSurname() + ".");

        // 5.	Создать массив из 5 сотрудников. С помощью цикла вывести
        // информацию только о сотрудниках старше 40 лет;

        Employee[] employees = {
                e,
                new Employee("Andrey", "Viktorovich",
                        "Bezrukov", "8(495)111-22-33",
                        "fitter", 52000, 1973),
                new Employee("Evgeniy", "Viktorovich",
                        "Del'finov", "8(495)222-33-44",
                        "project manager", 40000, 1963),
                new Employee("Natalia", "Pavlovna",
                        "Keks", "8(495)333-44-55",
                        "senior developer", 90000, 1990),
                new Employee("Tatiana", "Sergeevna",
                        "Krasotkina", "8(495)444-55-66",
                        "accountant", 50000, 1983)
        };

        for (int i = 0; i < employees.length; i++)
            if (employees[i].getAge() > 40)
                System.out.println(employees[i].getFullInfo());

        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < employees.length; i++)
            System.out.println(employees[i].getFullInfo());

        increaser(employees, (byte)45, 5000.0f);

        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < employees.length; i++)
            if (employees[i].isSalaryChanged)
                System.out.println(employees[i].getFullInfo());
        System.out.println("--------------------------------------------------------");
        System.out.println("Avg. age: " + averageAge(employees) + " years");
        System.out.println("Avg. salary: " + averageSalary(employees) + " RUR");
    }
}
