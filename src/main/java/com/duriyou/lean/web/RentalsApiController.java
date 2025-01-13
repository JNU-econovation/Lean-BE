//package com.duriyou.lean.web;
//
//import com.duriyou.lean.service.rentals.RentalsService;
//import com.duriyou.lean.web.dto.rentals.RentalsResponseDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//@RequiredArgsConstructor
//@RestController
//public class RentalsApiController {
//
//    private final RentalsService rentalsService;
//
//    @GetMapping("api/v1/rentals/{user_id}")
//    public RentalsResponseDto findById(@PathVariable Long id) {
//        return RentalsService.findById(id);
//    }
//
//}
