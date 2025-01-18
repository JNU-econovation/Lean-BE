package com.duriyou.lean.web.dto.rentals;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class RentalDetailsDto {
    private String studentCouncilName;
    private String studentCouncilAddress;
    private String itemName;
    private LocalDateTime rentalStartDate;
    private LocalDateTime rentalExpireDate;
    private LocalDateTime reservationStartDate;
    private LocalDateTime reservationExpirationDate;
    private LocalDateTime returnDate;
    private String userName;
    private String userCollegeName;
    private String userPhoneNumber;
}
