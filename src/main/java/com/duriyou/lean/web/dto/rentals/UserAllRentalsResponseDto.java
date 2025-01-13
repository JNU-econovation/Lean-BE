package com.duriyou.lean.web.dto.rentals;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserAllRentalsResponseDto {
    // 필드명 명명규칙 Refactoring 하기
    private String student_council_name;
    private Long rental_id;
    private String rental_status;
    private Long item_id;
    private String item_name;
    private LocalDateTime rental_date_expiration;

    public UserAllRentalsResponseDto(String student_council_name, Long rental_id, String rental_status, Long item_id, String item_name, LocalDateTime rental_date_expiration){
        this.student_council_name = student_council_name;
        this.rental_id = rental_id;
        this.rental_status = rental_status;
        this.item_id = item_id;
        this.item_name = item_name;
        this.rental_date_expiration = rental_date_expiration;
    }
}
