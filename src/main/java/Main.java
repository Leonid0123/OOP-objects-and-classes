import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Department dep0 = new Department("Отдел обеспечения качества", new Employee("Игнат"));
        System.out.println(dep0);
        System.out.println(dep0.getBoss());
        dep0.setBoss(new Employee("Андрей"));
        dep0.getBoss().setDepartment(new Department("Отдел DevOps", new Employee("Кирилл"))); 

        Employee employee1 = new Employee("Иван");
        System.out.println(employee1);

        Department department2 = new Department("Отдел разработки", employee1);
        Employee employee2 = new Employee("Сергей", department2);
        System.out.println(employee2);
        department2.setBoss(new Employee("Захар"));

        Department department1 = new Department("Отдел разработки", employee1);
        employee1.setDepartment(department1);
        System.out.println(employee1);
    }
}