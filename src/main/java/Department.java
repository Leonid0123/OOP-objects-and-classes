public class Department {
    private String name;
    private Employee boss;

    public Department(String name, Employee boss) {
        this.setDepName(name);
        this.setBoss(boss);
    }

    @Override
    public String toString() {
         return "Department{" +
                "name='" + name + '\'' +
                ", boss=" + boss +
                '}';
    }

    public String getDepName() {
        return name;
    }

    public Employee getBoss() {
        return boss;
    }

    public void setDepName(String name) {
        this.name = name;
    }

    public void setBoss(Employee boss) {
        this.boss = new Employee(boss.getName(), boss.getDepartment());
        this.getBoss().setDepartment(this);
    }
}
