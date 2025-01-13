package com.duriyou.lean.domain.users;

import com.duriyou.lean.web.dto.rentals.UserAllRentalsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByStudentNumber(String studentNumber);

    @Query("SELECT new com.duriyou.lean.web.dto.rentals.UserAllRentalsDto( " +
            "sc.name, " +
            "r.id, " +
            "r.status, " +
            "i.id, " +
            "i.name, " +
            "rd.expirationTime " +
            ") " +
            "FROM Users u " +
            "RIGHT JOIN Rentals r ON u.id = r.users.id " +
            "LEFT JOIN RentalDates rd ON r.id = rd.rentals.id " +
            "LEFT JOIN Items i ON r.items.id = i.id " +
            "LEFT JOIN StudentCouncil sc ON i.studentCouncil.id = sc.id " +
            "WHERE u.id = :user_id " +
            "ORDER BY r.id ASC")
    List<UserAllRentalsDto> findUserAllRentals(@Param("user_id") Long user_id);
}