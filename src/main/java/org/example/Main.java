package org.example;

public class Main {
    private static final Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("виталий", "Олегов", 1, 25794);
//        printEmployees(5); // Часть 1 и 2
//        getMax(2);
//        getMin(2);
//        System.out.println("Сумма зарплат по отделу составляет " + calculationSalarySum(5));
//        calculationAverageSalary(5);
//        getIncreaseSalary(4, 5);

        getNumber(46520); // Часть 3

    }


    public static void addEmployee(Employee employee) {
        boolean storageSpace = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                storageSpace = true;
                employees[i] = employee;
                break;
            }
        }
        if (!storageSpace) {
            System.out.println("Нет места для заполнения данных");
        }
    }

    public static void printEmployees(int department) {
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (employees[i].getDepartment() == department) {
                Employee employee = employees[i];
                System.out.println("Сотрудник отдела " + department + " " + employee.getFirstName() + " " + employee.getLastName() + ", зарплата: " + employee.getSalary());
            }
        }
    }

    public static int calculationSalarySum(int department) {
        int sum = 0;
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            Employee employee = employees[i];
            if (employee.getDepartment() == department)
                sum += employees[i].getSalary();
        }
        return sum;
    }

    public static void getMax(int department) {
        String name = "";
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (employees[i].getSalary() > maxValue && employees[i].getDepartment() == department) {
                maxValue = employees[i].getSalary();
                name = employees[i].getFirstName() + "" + employees[i].getLastName();
            }
        }
        if (name.equals("")) {
            System.out.println("В отделе нет сотрудников");
        } else {
            System.out.println("Сотрудником с максимальной зарплатой по отделу является " + name + ", его зарплата составляет " + maxValue + " рублей");
        }
    }


    public static void getMin(int department) {
        String name = "";
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (employees[i].getDepartment() == department && employees[i].getSalary() < minValue) {
                minValue = employees[i].getSalary();
                name = employees[i].getFirstName() + "" + employees[i].getLastName();
            }
        }
        if (name.equals("")) {
            System.out.println("В отделе нет сотрудников");
        } else {
            System.out.println("Сотрудником с минимальной зарплатой по отделу является " + name + ", его зарплата составляет " + minValue + " рублей");
        }
    }

    public static void calculationAverageSalary(int department) {
        int employeeInDepartment = 0;
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (employees[i].getDepartment() == department) {
                employeeInDepartment++;
            }
        }
        if (employeeInDepartment == 0) {
            System.out.println("В отделе нет сотрудников");
        } else {
            System.out.println("Средняя зарплата по отделу составляет " + calculationSalarySum(5) / employeeInDepartment);
        }
    }

    public static void getIncreaseSalary(int increment, int department) {
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (employees[i].getDepartment() == department) {
                System.out.println(employees[i].getSalary() + employees[i].getSalary() * (increment * 0.01));
            }
        }
    }

    public static void getNumber(int number) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getSalary() > number) {
                    System.out.println(" Id: " + employee.getId() + "; ФИО сотрудника: " + employee.getFirstName() + " " + employee.getLastName() + "; Зарплата сотрудника: " + employee.getSalary() + " — зарплата больше чем " + number);
                } else if (employee.getSalary() < number) {
                    System.out.println(" Id: " + employee.getId() + "; ФИО сотрудника: " + employee.getFirstName() + " " + employee.getLastName() + "; Зарплата сотрудника: " + employee.getSalary() + " — зарплата меньше " + number);
                } else
                    System.out.println(" Id: " + employee.getId() + "; ФИО сотрудника: " + employee.getFirstName() + " " + employee.getLastName() + "; Зарплата сотрудника: " + employee.getSalary() + " — зарплата равна " + number);
            }
        }
    }
}