package sit.education.student.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Student {
    private String fio;
    private List<Discipline> disciplines;

    public Student(String fio) {
        this.fio = fio;
        disciplines = new ArrayList<>();
    }

    public void addDisciplines(Discipline disciplines) {
        this.disciplines.add(disciplines);
    }

    public Discipline getByIndex(int i) {
        return disciplines.get(i);
    }

}
