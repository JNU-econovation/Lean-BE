package com.duriyou.lean.web.dto.rentals;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RentalDetailsResponseDto {
    private String studentCouncilName;
    private String studentCouncilAddress;
    private String itemName;
    private LocalDateTime rentalStartDate;
    private LocalDateTime rentalExpireDate;
    private String userName;
    private String userCollegeName;
    private String userPhoneNumber;

    public RentalDetailsResponseDto(String studentCouncilName, String studentCouncilAddress, String itemName, LocalDateTime rentalStartDate,
                                    LocalDateTime rentalExpireDate, String userName, String userCollegeName, String userPhoneNumber) {
        this.studentCouncilName = studentCouncilName;
        this.studentCouncilAddress = studentCouncilAddress;
        this.itemName = itemName;
        this.rentalStartDate = rentalStartDate;
        this.rentalExpireDate = rentalExpireDate;
        this.userName = userName;
        this.userCollegeName = userCollegeName;
        this.userPhoneNumber = userPhoneNumber;
    }
}
