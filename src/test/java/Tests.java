import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.util.List;

public class Tests {

    @Test
    public void testEncapsulationGrades() {
        Student student = new Student("Paul");
        student.addGrade(4);
        List grades = student.getGrades();
        grades.add(5);
        Assertions.assertNotEquals(student.getGrades(),grades);
    }

    @Test
    public void testSetName() {
        Student student = new Student("John");
        student.setName("Tom");
        Assertions.assertEquals(student.getName(),"Tom");
    }

    @Test
    public void testGetName() {
        Student student = new Student("Mike");
        Assertions.assertEquals(student.getName(),"Mike");
    }

    @Test
    public void testIncorrectAddGrade() {
        List<Integer> grades = List.of(1,6);
        Student student = new Student("Mike");
        Assertions.assertThrows(IllegalArgumentException.class, () -> student.addGrade(grades.get(0)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> student.addGrade(grades.get(1)));
    }

    @Test
    public void testCorrectAddGrade() {
        List<Integer> grades = List.of(2,3,4,5);
        Student student = new Student("Mike");
        student.addGrade(grades.get(0));
        student.addGrade(grades.get(1));
        student.addGrade(grades.get(2));
        student.addGrade(grades.get(3));
        Assertions.assertEquals(student.getGrades(),grades);
    }
}
