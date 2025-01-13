package com.duriyou.lean.web.dto.rentals;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserAllRentalsDto { // JPQL에서 직접 받아올 때 사용하는 DTO

    private String student_council_name;
    private Long rental_id;
    private String rental_status;
    private Long item_id;
    private String item_name;
    private LocalDateTime rental_date_expiration;
}
