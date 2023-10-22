package sit.education.student.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Institut {
    private String name;
    private List<Student> students;

    public Institut(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void setStudents(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return "Institut{" +
                "name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
