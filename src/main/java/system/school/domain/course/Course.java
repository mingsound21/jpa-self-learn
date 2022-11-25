package system.school.domain.course;

import system.school.domain.course_registration_info.CourseRegistrationInfo;
import system.school.domain.major.Major;
import system.school.domain.professor.Professor;
import system.school.domain.student.Student;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue
    @Column(name = "COURSE_ID")
    private Long id;

    private String name;
    private String room;

    @ManyToOne
    @JoinColumn(name = "PROFESSOR_ID")  // 연관관계 주인
    private Professor professor;
    @ManyToOne
    @JoinColumn(name = "MAJOR_ID")  // 연관관계 주인
    private Major major;
    @OneToMany(mappedBy = "course")  // 연관관계 주인의 반대
    private List<CourseRegistrationInfo> courseRegisterInfoList;
}
