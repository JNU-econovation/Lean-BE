package com.duriyou.lean.web.dto.rentals;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ReservationRequestDto {
    private LocalDateTime startTime;
    private LocalDateTime expirationTime;

    @Builder
    public ReservationRequestDto(LocalDateTime startTime, LocalDateTime expirationTime) {
        this.startTime = startTime;
        this.expirationTime = expirationTime;
    }
}
