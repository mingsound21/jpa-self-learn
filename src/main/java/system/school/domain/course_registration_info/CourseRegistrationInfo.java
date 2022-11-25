package system.school.domain.course_registration_info;

import system.school.domain.course.Course;
import system.school.domain.student.Student;

import javax.persistence.*;

@Entity
public class CourseRegistrationInfo {
    @Id
    @GeneratedValue
    @Column(name = "REGISTER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID") // 연관관계 주인
    private Student student;
    @ManyToOne
    @JoinColumn(name = "COURSE_ID") // 연관관계 주인
    private Course course;
}
