import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public final class Student {
    private final List<Integer> grades = new ArrayList<>();
    private final String name;
    private final Predicate<Integer> gradeValidator;

    public Student(String name, Predicate<Integer> gradeValidator) {
        this.name = name;
        this.gradeValidator = gradeValidator;
    }

    public void addGrade(int grade) {
        if (gradeValidator.test(grade))
            grades.add(grade);
        else
            System.out.println("Оценка " + grade + " не входит в указанный, при создании студента, диапазон");
    }

    public String toString() {
        return "Student{" + " grades =" + grades + ", name=" + name + '}';
    }
}