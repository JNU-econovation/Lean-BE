package com.duriyou.lean.domain.users;


import com.duriyou.lean.domain.colleges.Colleges;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentNumber;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "college_id", nullable = false)
    private Colleges college;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private Boolean isStudentCouncil;

    private String createdAt;

    @Builder
    public Users(String studentNumber, String name, String phoneNumber, Colleges college, String department, Boolean isStudentCouncil, String createdAt) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.isStudentCouncil = isStudentCouncil;
        this.college = college;
        this.createdAt = createdAt;
    }

    public void update(String studentNumber, String name, String phoneNumber, Colleges college, String department) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.college = college;
        this.department = department;
    }
}
