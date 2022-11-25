package system.school.domain.professor;

import system.school.domain.common.Address;
import system.school.domain.course.Course;
import system.school.domain.major.Major;
import system.school.domain.student.Student;

import javax.persistence.*;
import java.util.List;

@Entity
public class Professor {
    @Id
    @GeneratedValue
    @Column(name = "PROFESSOR_ID")
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private ProfessorStatus status;
    private String gender;
    @Embedded
    private Address address;

    @OneToMany(mappedBy = "professor") // 연관관계 주인의 반대편
    private List<Student> studentList;
    @OneToMany(mappedBy = "professor") // 연관관계 주인의 반대편
    private List<Course> courseList;
    @OneToOne
    @JoinColumn(name = "MAJOR_ID") // 연관관계 주인
    private Major major;
}
