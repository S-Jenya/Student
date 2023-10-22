package sit.education.student.service;

import org.springframework.stereotype.Service;
import sit.education.student.domain.Institut;
import sit.education.student.domain.Student;

@Service
public class InstitutionService {
    public Institut create(String name) throws Exception {
        if(name == null || name.isEmpty()) {
            throw new Exception("Наименование не может быть пустым");
        }
        return new Institut(name);
    }

    public void addStudent(Institut institut, Student student) {
        institut.setStudents(student);
    }
}
