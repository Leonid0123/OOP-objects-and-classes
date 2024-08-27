package ru.courses.company;

import java.util.Objects;

public class Employee {
    private final String name;
    private Department department;
    private boolean isBoss;

    public Employee(String name) {
        if (name != null) {
            this.name = name;
            this.isBoss = false;
        } else
            throw new IllegalArgumentException("Значение имени сотрудника не может быть равным Null. Укажите корректное значение.");
    }

    @Override
    public String toString() {
        if (department == null)
            return this.getName() + " работает в отделе " + this.getDepartment() + ", начальник которого " + this.getDepartment();
        if (this != department.getBoss())
            return this.getName() + " работает в отделе " + this.getDepartment().getDepName() + ", начальник которого " + this.getDepartment().getBoss().getName();
        else
            return this.getName() + " начальник отдела " + this.getDepartment().getDepName();
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        if (department != null)
            return department;
        else
            throw new IllegalArgumentException("Значение департамента не может быть равным Null. Укажите корректное значение.");
    }

    public void setDepartment(Department department) {
        if (department == null)
            throw new IllegalArgumentException("Значение департамента не может быть равным Null. Укажите корректное значение.");
        else if (this.isBoss)
            System.out.println("Сотрудник " + this.name + " является руководителем отдела " + this.getDepartment().getDepName() + ". Перевести сотрудника в другой отдел невозможно");
        else if (Objects.equals(this.getName(), department.getBoss().getName()))
            this.setBossDepartment(department);
        else {
            this.department = new Department(department.getDepName());
            this.department.setBoss(department.getBoss());
        }
    }

    void setBossDepartment(Department department) {
        this.department = department;
        this.isBoss = true;
    }
}
