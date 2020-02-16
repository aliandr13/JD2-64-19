package by.it.academy.entity.Homework_Criteria;
import by.it.academy.util.HibernateUtil;

public class App {
    public static void main(String[] args) {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl().getINSTANCE();

        Department department = new Department("IT");
        Department department1 = new Department("HR");
        Department department2 = new Department("QR");

        employeeDao.createDepartment(department);
        employeeDao.createDepartment(department1);
        employeeDao.createDepartment(department2);

        employeeDao.create(new Employee("Vasya", "Vasilev", 100.0, 17L, department1));
        employeeDao.create(new Employee("Petya", "Petrov", 200.0, 35L, department2));
        employeeDao.create(new Employee("Alexey", "Alexeev", 250.0, 21L, department1));
        employeeDao.create(new Employee("Andrey", "Andreev", 450.0, 23L, department));
        employeeDao.create(new Employee("Ivan", "Ivanov", 250.0, 16L, department));
        employeeDao.create(new Employee("Elena", "Andreeva", 50.0, 27L, department2));

        System.out.println(employeeDao.getAll());
        System.out.println(employeeDao.getMinAge());
        System.out.println(employeeDao.getByAgeBetween(16, 20));

        HibernateUtil.shutdown();
    }
}
