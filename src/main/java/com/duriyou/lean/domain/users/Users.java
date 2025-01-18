package com.duriyou.lean.domain.users;


import com.duriyou.lean.domain.colleges.Colleges;
import com.duriyou.lean.domain.student.council.StudentCouncil;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String studentNumber;

    @Column(nullable = false)
    private String password;

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

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "user")
    private StudentCouncil studentCouncil;

    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
        if (isStudentCouncil == null) {
            isStudentCouncil = false;
        }
    }

    @Builder
    public Users(String studentNumber, String password, String name, String phoneNumber, Colleges college, String department, Boolean isStudentCouncil, LocalDateTime createdAt) {
        this.studentNumber = studentNumber;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.isStudentCouncil = isStudentCouncil;
        this.college = college;
        this.createdAt = createdAt;
    }

    public void update(String name, String phoneNumber, Colleges college, String department) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.college = college;
        this.department = department;
    }

    public void updateIdStudentCouncil(Boolean isStudentCouncil) {
        this.isStudentCouncil = isStudentCouncil;
    }
}
