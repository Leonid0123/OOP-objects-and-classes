public class Main {
    public static void main(String[] args) {
        //создание отдела с начальником. попытка изменить начальника отдела и попытка изменить отдел у начальника
        Department qaDep = new Department("Отдел обеспечения качества");
        qaDep.setBoss(new Employee("Игнат"));
        System.out.println(qaDep);
        System.out.println(qaDep.getBoss());
        qaDep.setBoss(new Employee("Андрей")); //проверка, возможно ли изменить начальника отдела
        qaDep.getBoss().setDepartment(new Department("Отдел DevOps")); //проверка, возможно ли изменить отдел у начальника

        //создание отдела с начальником. создание отдельного работника и зачисление его в ранее созданный отдел
        Department devDep = new Department("Отдел разработки");
        Employee employee1 = new Employee("Иван");
        devDep.setBoss(employee1);
        Employee employee2 = new Employee("Сергей");
        employee2.setDepartment(devDep);
        System.out.println(employee2);
    }
}