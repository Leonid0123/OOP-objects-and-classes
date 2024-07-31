public class Employee {
    private String name;
    private Department department;

    public Employee(String name) {
        this(name, null);
    }

    public Employee(String name, Department department) {
        this.name = name;
        this.setDepartment(department);
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
        return department;
    }

    public void setDepartment(Department department) {
        if (department == null)
            this.department = null;
        else if (this.getName() == department.getBoss().getName())
            this.setBossDepartment(department);
        else
            this.department = new Department(department.getDepName(), department.getBoss());
    }

    private void setBossDepartment(Department department) {
        this.department = department;
    }
}
