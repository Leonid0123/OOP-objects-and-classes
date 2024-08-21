import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String name;
    private final List<Integer> grades;

    public Student(String name, List<Integer> grades) {
        this.name = name;
        this.grades = new ArrayList<>();
        for (Integer grade : grades) {
            this.setGrades(grade);
        }
    }

    public Student(String name) {
        this(name, new ArrayList<>());
    }

    @Override
    public String toString() {
        return name + ": " + grades;
    }

    public void setGrades(int grade) {
        if (grade >= 2 && grade <= 5)
            this.grades.add(grade);
        else
            throw new IllegalArgumentException("Некорректное значение заданной оценки. Оценки должны быть в диапазоне от 2 до 5.");
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(this.grades);
    }
}
