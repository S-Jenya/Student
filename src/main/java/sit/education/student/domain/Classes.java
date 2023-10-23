package sit.education.student.domain;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class Classes {
    private Date start;
    private Integer grade;

    public Classes(Integer grade) {
        this.start = new Date(System.currentTimeMillis());
        this.grade = grade;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return "Classes{" +
                "start=" + simpleDateFormat.format(start) +
                ", grade=" + grade +
                '}';
    }
}
