public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Igor", grade -> grade >= 0 && grade <= 5);
        Student student2 = new Student("Oleg", grade -> grade % 2 == 0 && grade >= 1 && grade <= 100000);

        student1.addGrade(4); //оценка добавлена успешно
        student1.addGrade(6); //оценка не добавлена
        student1.addGrade(5); //оценка добавлена
        System.out.println(student1);

        student2.addGrade(8); //оценка добавлена успешно
        student2.addGrade(7); //оценка не добавлена
        student2.addGrade(100000); //оценка добавлена
        System.out.println(student2);
    }
}