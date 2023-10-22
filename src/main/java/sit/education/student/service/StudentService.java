package sit.education.student.service;

import org.springframework.stereotype.Service;
import sit.education.student.domain.Classes;
import sit.education.student.domain.Discipline;
import sit.education.student.domain.Student;

import java.util.stream.IntStream;

@Service
public class StudentService {
    public Student create(String fio) throws Exception {
        if(fio == null || fio.isEmpty()) {
            throw new Exception("Имя студента не может быть пустым");
        }
        return new Student(fio);
    }

    public void addDiscipline(Student student, Discipline discipline) {
        student.addDisciplines(discipline);
    }

    public void getListDiscipline(Student student) {
        IntStream.range(0, student.getDisciplines().size())
                .forEach(index -> System.out.println((index + 1) + ". " + student.getDisciplines().get(index)));
    }

    public void setStudentClasses(Discipline discipline, Classes classes) {
        discipline.addClasses(classes);
    }
}
