package com.duriyou.lean.web.dto.rentals;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RentalDetailsResponseDto {
    private String studentCouncilName;
    private String studentCouncilAddress;
    private String itemName;
    private String rentalStatus;
    private LocalDateTime rentalStartDate;
    private LocalDateTime rentalExpireDate;
    private LocalDateTime reservationStartDate;
    private LocalDateTime reservationExpirationDate;
    private LocalDateTime returnDate;
    private String userName;
    private String userCollegeName;
    private String userPhoneNumber;

    public RentalDetailsResponseDto(String studentCouncilName, String studentCouncilAddress, String itemName, String rentalStatus,LocalDateTime rentalStartDate,
                                    LocalDateTime rentalExpireDate, LocalDateTime reservationStartDate, LocalDateTime reservationExpirationDate,
                                    LocalDateTime returnDate, String userName, String userCollegeName, String userPhoneNumber) {
        this.studentCouncilName = studentCouncilName;
        this.studentCouncilAddress = studentCouncilAddress;
        this.itemName = itemName;
        this.rentalStatus = rentalStatus;
        this.rentalStartDate = rentalStartDate;
        this.rentalExpireDate = rentalExpireDate;
        this.reservationStartDate = reservationStartDate;
        this.reservationExpirationDate = reservationExpirationDate;
        this.returnDate = returnDate;
        this.userName = userName;
        this.userCollegeName = userCollegeName;
        this.userPhoneNumber = userPhoneNumber;
    }
}
