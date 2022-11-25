package system.school.domain.student;

import system.school.domain.common.Address;
import system.school.domain.course.Course;
import system.school.domain.course_registration_info.CourseRegistrationInfo;
import system.school.domain.major.Major;
import system.school.domain.professor.Professor;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "STUDENT_ID")
    private Long id; // 필드명은 id, @Column으로 DB의 컬럼명 지정

    private String name;
    private int grade;
    @Enumerated(EnumType.STRING) // Enum타입 STRING지정
    private StudentStatus status;
    private String gender;
    private Address address;

    @ManyToOne
    @JoinColumn(name = "PROFESSOR_ID")
    private Professor professor;
    @OneToOne
    @JoinColumn(name = "MAJOR_ID")
    private Major major;
    @OneToMany(mappedBy = "student") //mappedBy = "연관관계 주인 엔티티에서의 이 객체의 필드명" - 맞나?
    private List<CourseRegistrationInfo> courseRegisterInfoList;
}
