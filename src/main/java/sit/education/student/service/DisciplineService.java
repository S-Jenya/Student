package sit.education.student.service;

import org.springframework.stereotype.Service;
import sit.education.student.domain.Discipline;
import sit.education.student.domain.Student;

@Service
public class DisciplineService {
    public Discipline create(String name, Integer hours) throws Exception {
        if(name == null || name.isEmpty()) {
            throw new Exception("Наименование не может быть пустым");
        }

        if (hours <= 0) {
            throw new Exception("Введено некорректное количество часов");
        }
        return new Discipline(name, hours);
    }

    public Discipline getByIndex(Student student, int i) throws Exception {
        if (i < 0) {
            throw new Exception("Введено некорректное значение");
        }
        return student.getByIndex(i);
    }
}
