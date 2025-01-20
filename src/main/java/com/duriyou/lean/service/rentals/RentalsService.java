package com.duriyou.lean.service.rentals;

import com.duriyou.lean.domain.dates.*;
import com.duriyou.lean.domain.items.Items;
import com.duriyou.lean.domain.items.ItemsRepository;
import com.duriyou.lean.domain.rentals.Rentals;
import com.duriyou.lean.domain.rentals.RentalsRepository;
import com.duriyou.lean.domain.student.council.StudentCouncilRepository;
import com.duriyou.lean.domain.users.Users;
import com.duriyou.lean.domain.users.UsersRepository;
import com.duriyou.lean.web.dto.rentals.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RentalsService {

    private final UsersRepository usersRepository;
    private final StudentCouncilRepository studentCouncilRepository;
    private final RentalsRepository rentalsRepository;
    private final ItemsRepository itemsRepository;
    private final ReservationDatesRepository reservationDatesRepository;
    private final RentalDatesRepository rentalDatesRepository;
    private final ReturnDatesRepository returnDatesRepository;

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

    @Transactional
    public Long saveReservation(Long user_id, Long item_id, ReservationRequestDto resevationRequestDto) {
        Users user = usersRepository.findById(user_id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. user_id " + user_id));
        Items item = itemsRepository.findById(item_id).orElseThrow(() -> new IllegalArgumentException("해당 물품이 존재하지 않습니다. item_id " + item_id));

        Rentals rentals = Rentals.builder()
                .users(user)
                .items(item)
                .status("대기중")
                .build();

        Rentals savedRentals = rentalsRepository.save(rentals);

        // 예약 후 예약 시간 생성되는 비즈니스 로직
        Rentals confirmRentals = rentalsRepository.findById(savedRentals.getId()).orElseThrow(()-> new IllegalArgumentException("해당 대여 내역이 존재하지 않습니다."));

        ReservationDates reservationDates = ReservationDates.builder()
                .rentals(confirmRentals)
                .startTime(resevationRequestDto.getStartTime())
                .expirationTime(resevationRequestDto.getExpirationTime())
                .build();

        reservationDatesRepository.save(reservationDates);

        return savedRentals.getId();
    }

    @Transactional
    public String updateRentalStatus(Long rentalId){

        Rentals rentals = rentalsRepository.findById(rentalId).orElseThrow(()-> new IllegalArgumentException("해당 대여내역이 존재하지 않습니다."));

        String status = rentals.getStatus();

        if ("대기중".equals(status)) {
            // 대기중 상태일 때 대여중으로 바꿔주고 대여시간, 반납시간 데이터 추가 로직
            rentals.updateStatus("대여중");

            RentalDates rentalDates = RentalDates.builder()
                    .rentals(rentals)
                    .startTime(LocalDateTime.now())
                    .expirationTime(LocalDateTime.now().plusDays(1))
                    .build();

            rentalDatesRepository.save(rentalDates);

        } else if ("대여중".equals(status)) {

            rentals.updateStatus("처리중");

        } else if ("처리중".equals(status)) {

            rentals.updateStatus("반납");

            ReturnDates returnDates = ReturnDates.builder()
                    .rentals(rentals)
                    .date(LocalDateTime.now())
                    .build();

            returnDatesRepository.save(returnDates);

        }

        return rentals.getStatus();

    }

    public RentalDetailsResponseDto findRentalDetailsById(Long rental_id) {

        RentalDetailsDto rentalDetailsDto = rentalsRepository.findRentalDetailsById(rental_id);

        return new RentalDetailsResponseDto(
                rentalDetailsDto.getStudentCouncilName(),
                rentalDetailsDto.getStudentCouncilAddress(),
                rentalDetailsDto.getItemName(),
                rentalDetailsDto.getRentalStatus(),
                rentalDetailsDto.getRentalStartDate(),
                rentalDetailsDto.getRentalExpireDate(),
                rentalDetailsDto.getReservationStartDate(),
                rentalDetailsDto.getReservationExpirationDate(),
                rentalDetailsDto.getReturnDate(),
                rentalDetailsDto.getUserName(),
                rentalDetailsDto.getUserCollegeName(),
                rentalDetailsDto.getUserPhoneNumber(),
                rentalDetailsDto.getUserDepartment()
        );
    }

    public List<StudentCouncilAllRentalsResponseDto> findStudentCouncilRentalsById(Long student_council_id){

        List<StudentCouncilAllRentalsDto> studentCouncilAllRentalsDtos = studentCouncilRepository.findStudentCouncilAllRentalsById(student_council_id);

        return studentCouncilAllRentalsDtos.stream()
                .map(StudentCouncilAllRentalsDto -> new StudentCouncilAllRentalsResponseDto(
                        StudentCouncilAllRentalsDto.getUserName(),
                        StudentCouncilAllRentalsDto.getItemName(),
                        StudentCouncilAllRentalsDto.getRentalStatus(),
                        StudentCouncilAllRentalsDto.getRentalId(),
                        StudentCouncilAllRentalsDto.getExpirationTime()
                ))
                .collect(Collectors.toList());
    }
}
