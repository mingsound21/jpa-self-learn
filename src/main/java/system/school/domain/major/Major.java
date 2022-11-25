package system.school.domain.major;

import system.school.domain.course.Course;
import system.school.domain.professor.Professor;
import system.school.domain.student.Student;

import javax.persistence.*;
import java.util.List;

@Entity
public class Major {
    @Id
    @GeneratedValue
    @Column(name = "MAJOR_ID")
    private Long id;
    private String name;

    @OneToOne(mappedBy = "major") // 연관관계 주인의 반대편
    private Professor professor;
    @OneToMany(mappedBy = "major")// 연관관계 주인의 반대편
    private List<Student> studentList;
    @OneToMany(mappedBy = "major")// 연관관계 주인의 반대편
    private List<Course> courseList;
}
