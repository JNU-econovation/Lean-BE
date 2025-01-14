package com.duriyou.lean.web.dto.rentals;

import lombok.Getter;

@Getter
public class StudentCouncilAllRentalsResponseDto {
    private String userName;
    private String itemName;
    private String rentalStatus;
    private Long rentalId;

    public StudentCouncilAllRentalsResponseDto(String userName, String itemName, String rentalStatus, Long rentalId) {
        this.userName = userName;
        this.itemName = itemName;
        this.rentalStatus = rentalStatus;
        this.rentalId = rentalId;
    }
}
