import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Витя"); //создание студента без набора оценок
        System.out.println(s1);
        s1.setGrades(4);
        s1.setGrades(3);
        s1.setGrades(5);
        System.out.println(s1);

        List<Integer> gradesS2 = new ArrayList<>(); //создание списка оценок и создание студента с набором оценок
        gradesS2.add(3);
        gradesS2.add(5);
        gradesS2.add(4);
        gradesS2.add(2);
        Student s2 = new Student("Оля", gradesS2);
        System.out.println(s2);
        s2.getGrades().clear();
        System.out.println(s2);
        s2.setGrades(2);
    }
}