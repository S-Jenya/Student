package sit.education.student.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Discipline {
    private String name;
    private Integer hours;
    private List<Classes> classes;

    public Discipline(String name, Integer hours) {
        this.name = name;
        this.hours = hours;
        this.classes = new ArrayList<>();
    }

    public void addClasses(Classes classes) {
        this.classes.add(classes);
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "name='" + name + '\'' +
                ", hours=" + hours +
                ", classes=" + classes +
                '}';
    }

}
