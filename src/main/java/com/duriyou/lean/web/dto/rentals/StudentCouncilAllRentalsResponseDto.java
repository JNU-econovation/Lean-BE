package com.duriyou.lean.web.dto.rentals;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class StudentCouncilAllRentalsResponseDto {
    private String userName;
    private String itemName;
    private String rentalStatus;
    private Long rentalId;
    private LocalDateTime expirationTime;

    public StudentCouncilAllRentalsResponseDto(String userName, String itemName, String rentalStatus, Long rentalId, LocalDateTime expirationTime) {
        this.userName = userName;
        this.itemName = itemName;
        this.rentalStatus = rentalStatus;
        this.rentalId = rentalId;
        this.expirationTime = expirationTime;
    }
}
