package ru.courses.company;

public class Department {
    private final String name;
    private Employee boss;

    public Department(String name) {
        if (name != null)
            this.name = name;
        else
            throw new IllegalArgumentException("Значение имени отдела не может быть равным Null. Укажите корректное значение.");
    }

    public String getDepName() {
        return name;
    }

    public Employee getBoss() {
        if (boss != null)
            return boss;
        else
            throw new IllegalArgumentException("Значение начальника отдела не может быть равным Null. Укажите корректное значение.");
    }

    void setBoss(Employee boss) {
        if (boss == null)
            throw new IllegalArgumentException("Значение начальника отдела не может быть равным Null. Укажите корректное значение.");
        else if (this.boss == null) {
            this.boss = new Employee(boss.getName());
            this.getBoss().setDepartment(this);
        } else {
            System.out.println("Отдел уже имеет начальника - " + this.getBoss());
        }
    }
}
