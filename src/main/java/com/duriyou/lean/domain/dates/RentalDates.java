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
public class RentalDates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "rental_id")
    private Rentals rentals;

    // start time 빌리기 시작한 날짜
    @Column(nullable = false, updatable = false)
    private LocalDateTime startTime;

    // expiration time 반납 만료일 - 빌리기 시작한 날짜에 하루 추가
    @Column(nullable = false, updatable = false)
    private LocalDateTime expirationTime;

    // Builder
    @Builder
    public RentalDates(Rentals rentals, LocalDateTime startTime, LocalDateTime expirationTime){
        this.rentals = rentals;
        this.startTime = startTime;
        this.expirationTime = expirationTime;
    }
}
