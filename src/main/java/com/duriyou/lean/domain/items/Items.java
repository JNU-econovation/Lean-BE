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

    @OneToOne(mappedBy = "items", cascade = CascadeType.ALL)
    private ItemAmounts itemAmounts;

    @Builder
    public Items(StudentCouncil studentCouncil, String name, ItemAmounts itemAmounts){
        this.studentCouncil = studentCouncil;
        this.name = name;
        this.itemAmounts = itemAmounts;
    }

    public void setItemName(String itemName) {
        this.name = itemName;
    }

    public void addItemAmounts(ItemAmounts itemAmounts) {
        this.itemAmounts = itemAmounts;
    }

    public void setStudentCouncil(StudentCouncil studentCouncil) {
        this.studentCouncil = studentCouncil;
    }
}
