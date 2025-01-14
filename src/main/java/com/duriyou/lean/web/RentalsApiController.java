package com.duriyou.lean.web;

import com.duriyou.lean.service.rentals.RentalsService;
import com.duriyou.lean.web.dto.rentals.RentalDetailsResponseDto;
import com.duriyou.lean.web.dto.rentals.StudentCouncilAllRentalsResponseDto;
import com.duriyou.lean.web.dto.rentals.UserAllRentalsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RentalsApiController {

    private final RentalsService rentalsService;

    // R - 01
    @GetMapping("/api/v1/rentals/{user_id}")
    public ResponseEntity<List<UserAllRentalsResponseDto>> findUserAllRentalsById(@PathVariable Long user_id) {
        List<UserAllRentalsResponseDto> response = rentalsService.findUserAllRentalsById(user_id);
        return ResponseEntity.ok(response);
    }

    // R - 02
    @PostMapping("/api/v1/rentals/{user_id}/reservation/{item_id}")
    public Long saveReservation(@PathVariable Long user_id, @PathVariable Long item_id){
        return rentalsService.saveReservation(user_id, item_id);
    }

    // R - 03
    @GetMapping("/api/v1/rentals/details/{rental_id}")
    public ResponseEntity<RentalDetailsResponseDto> findRentalDetailsById(@PathVariable Long rental_id){
        RentalDetailsResponseDto responseDto = rentalsService.findRentalDetailsById(rental_id);
        return ResponseEntity.ok(responseDto);
    }

    // R - 04
    @PutMapping("/api/v1/rentals/details/{rental_id}")
    public String updateRentalStatus(@PathVariable Long rental_id){
        return rentalsService.updateRentalStatus(rental_id);
    }

    // R - 05
    @GetMapping("/api/v1/rentals/student_council/{student_council_id}")
    public ResponseEntity<List<StudentCouncilAllRentalsResponseDto>> findStudentCouncilRentalsById(@PathVariable Long student_council_id) {
        List<StudentCouncilAllRentalsResponseDto> response = rentalsService.findStudentCouncilRentalsById(student_council_id);
        return ResponseEntity.ok(response);
    }

}
