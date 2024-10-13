import lombok.*;
import java.util.ArrayList;
import java.util.List;

@ToString
public class Student {
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private List<Integer> marks = new ArrayList<>();


    public Student(Integer id, String name, List<Integer> marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}