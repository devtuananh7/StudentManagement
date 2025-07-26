package bug.creator.studentmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @Column(name = "id_sv")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSv;

    @Column(name = "university")
    private String university;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "major")
    private String major;

    @Column(name = "major_code")
    private String majorCode;

    @Column(name = "department")
    private String department;

    @Column(name = "course")
    private Integer course;

    @Column(name = "class")
    private String className;

    @Column(name = "email")
    private String email;

    @Column(name = "phonge_number")
    private String phoneNumber;

    @Column(name = "status")
    private String status;

    @Column(name = "training_system")
    private String trainingSystem;
}