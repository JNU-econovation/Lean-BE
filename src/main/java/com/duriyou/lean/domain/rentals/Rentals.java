package com.duriyou.lean.domain.rentals;

import com.duriyou.lean.domain.dates.RentalDates;
import com.duriyou.lean.domain.items.Items;
import com.duriyou.lean.domain.users.Users;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Rentals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Items items;

    @Column(nullable = false)
    private String status;

    @OneToOne(mappedBy = "rentals",cascade = CascadeType.ALL)
    private RentalDates rentalDates;

    @Builder
    public Rentals(Users users, Items items, String status, RentalDates rentalDates){
        this.users = users;
        this.items = items;
        this.status = status;
        this.rentalDates = rentalDates;
    }
}
