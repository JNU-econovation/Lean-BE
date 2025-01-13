package com.duriyou.lean.web;

import com.duriyou.lean.service.rentals.RentalsService;
import com.duriyou.lean.web.dto.rentals.StudentCouncilAllRentalsResponseDto;
import com.duriyou.lean.web.dto.rentals.UserAllRentalsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RentalsApiController {

    private final RentalsService rentalsService;

    // R - 01
    @GetMapping("api/v1/rentals/{user_id}")
    public ResponseEntity<List<UserAllRentalsResponseDto>> findUserAllRentalsById(@PathVariable Long user_id) {
        List<UserAllRentalsResponseDto> response = rentalsService.findUserAllRentalsById(user_id);
        return ResponseEntity.ok(response);
    }

    // R - 05
    @GetMapping("api/v1/rentals/student_council/{student_council_id}")
    public ResponseEntity<List<StudentCouncilAllRentalsResponseDto>> findStudentCouncilRentalsById(@PathVariable Long student_council_id) {
        List<StudentCouncilAllRentalsResponseDto> response = rentalsService.findStudentCouncilRentalsById(student_council_id);
        return ResponseEntity.ok(response);
    }

}
