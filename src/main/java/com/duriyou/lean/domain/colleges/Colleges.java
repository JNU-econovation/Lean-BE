package com.duriyou.lean.domain.colleges;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Colleges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Builder
    public Colleges(String name) {
        this.name = name;
    }

    public void update(String name) {
        this.name = name;
    }
}
