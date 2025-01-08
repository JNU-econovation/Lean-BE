package com.duriyou.lean.domain.items;

import com.duriyou.lean.domain.student.council.StudentCouncil;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_council_id")
    private StudentCouncil studentCouncil;


    @Column(nullable = false)
    private String name;

    @Builder
    public Items(String name){
        this.name = name;
    }
}
