//package com.duriyou.lean.service.rentals;
//
//import com.duriyou.lean.domain.users.Users;
//import com.duriyou.lean.domain.users.UsersRepository;
//import com.duriyou.lean.web.dto.rentals.RentalsResponseDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@RequiredArgsConstructor
//@Service
//public class RentalsService {
//
//    private final UsersRepository usersRepository;
//
//    public RentalsResponseDto findById(Long id){
//        Users entity = usersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
//        return new RentalsResponseDto(entity);
//    }
//
//}
