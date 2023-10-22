package sit.education.student.service;

import org.springframework.stereotype.Service;
import sit.education.student.domain.Classes;

@Service
public class ClassesService {

    public Classes create(Integer grade) throws Exception {

        if (grade <= 0) {
            throw new Exception("Введена неверная оценка");
        }
        return new Classes(grade);
    }
}
