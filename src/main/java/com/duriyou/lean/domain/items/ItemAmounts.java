package com.duriyou.lean.domain.items;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class ItemAmounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Items items;

    @Column(nullable = false)
    private Integer amount;

    @Builder
    public ItemAmounts(Items items, Integer amount){
        this.items = items;
        this.amount = amount;
    }

    public void updateAmount(Integer amount){
        this.amount = amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setItems(Items items) {
        this.items = items;
    }
}
