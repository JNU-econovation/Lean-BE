package com.duriyou.lean.web.dto.rentals;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class StudentCouncilAllRentalsDto {
    private String userName;
    private String itemName;
    private String rentalStatus;
    private Long rentalId;
    private LocalDateTime expirationTime;
}
