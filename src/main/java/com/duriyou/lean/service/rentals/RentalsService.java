package com.duriyou.lean.service.rentals;

import com.duriyou.lean.domain.student.council.StudentCouncilRepository;
import com.duriyou.lean.domain.users.UsersRepository;
import com.duriyou.lean.web.dto.rentals.StudentCouncilAllRentalsDto;
import com.duriyou.lean.web.dto.rentals.StudentCouncilAllRentalsResponseDto;
import com.duriyou.lean.web.dto.rentals.UserAllRentalsDto;
import com.duriyou.lean.web.dto.rentals.UserAllRentalsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RentalsService {

    private final UsersRepository usersRepository;
    private final StudentCouncilRepository studentCouncilRepository;

    public List<UserAllRentalsResponseDto> findUserAllRentalsById(Long user_id){
        // JPQL로 데이터 조회
        List<UserAllRentalsDto> userAllRentalsDtos = usersRepository.findUserAllRentals(user_id);

        // ResponseDto로 변환
        return userAllRentalsDtos.stream()
                .map(userAllRentalsDto -> new UserAllRentalsResponseDto(
                        userAllRentalsDto.getStudent_council_name(),
                        userAllRentalsDto.getRental_id(),
                        userAllRentalsDto.getRental_status(),
                        userAllRentalsDto.getItem_id(),
                        userAllRentalsDto.getItem_name(),
                        userAllRentalsDto.getRental_date_expiration()
                ))
                .collect(Collectors.toList());


    }

    public List<StudentCouncilAllRentalsResponseDto> findStudentCouncilRentalsById(Long student_council_id){

        List<StudentCouncilAllRentalsDto> studentCouncilAllRentalsDtos = studentCouncilRepository.findStudentCouncilAllRentalsById(student_council_id);

        return studentCouncilAllRentalsDtos.stream()
                .map(StudentCouncilAllRentalsDto -> new StudentCouncilAllRentalsResponseDto(
                        StudentCouncilAllRentalsDto.getUserName(),
                        StudentCouncilAllRentalsDto.getItemName(),
                        StudentCouncilAllRentalsDto.getRentalStatus(),
                        StudentCouncilAllRentalsDto.getRentalId()
                ))
                .collect(Collectors.toList());
    }
}
