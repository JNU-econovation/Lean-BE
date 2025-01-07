package com.duriyou.lean.domain.student.council;

import com.duriyou.lean.domain.users.Users;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class StudentCouncil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Builder
    public StudentCouncil(Users user, String name, String address) {
        this.user = user;
        this.name = name;
        this.address = address;
    }

    public void update(Users user, String name, String address) {
        this.user = user;
        this.name = name;
        this.address = address;
    }
}
