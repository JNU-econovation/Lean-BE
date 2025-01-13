package com.duriyou.lean.domain.student.council;

import com.duriyou.lean.domain.items.Items;
import com.duriyou.lean.domain.users.Users;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "studentCouncil", cascade = CascadeType.ALL)
    private List<Items> items;

    @Builder
    public StudentCouncil(Users user, String name, String address, List<Items> items) {
        this.user = user;
        this.name = name;
        this.address = address;
        this.items = items;
    }

    public void update(Users user, String name, String address) {
        this.user = user;
        this.name = name;
        this.address = address;
    }
}
