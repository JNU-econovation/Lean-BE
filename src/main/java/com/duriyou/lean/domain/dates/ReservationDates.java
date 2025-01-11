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
public class ReservationDates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "rental_id")
    private Rentals rentals;

    // Start - 가져가기로 한 시간
    @Column(nullable = false, updatable = false)
    private LocalDateTime startTime;

    // Expiration - 예약 만료 시간 대략 30분정도 사이드 로직
    @Column(nullable = false, updatable = false)
    private LocalDateTime expirationTime;

    @PrePersist
    public void prePersist() {
        if (startTime == null){
            startTime = LocalDateTime.now();
        }
        expirationTime = this.startTime.plusMinutes(30);
    }

    @Builder
    public ReservationDates(Rentals rentals, LocalDateTime startTime, LocalDateTime expirationTime){
        this.rentals = rentals;
        this.startTime = startTime;
        this.expirationTime = expirationTime;
    }
}
