package com.duriyou.lean.domain.dates;

import com.duriyou.lean.domain.rentals.Rentals;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class ReturnDates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "rental_id")
    private Rentals rentals;

    // Date - 사용자가 반납한 날짜
    @Column(nullable = false, updatable = false)
    private LocalDateTime date;

    @Builder
    public ReturnDates(Rentals rentals, LocalDateTime date){
        this.rentals = rentals;
        this.date = date;
    }
}
