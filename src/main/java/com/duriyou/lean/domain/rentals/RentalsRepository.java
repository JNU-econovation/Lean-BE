package com.duriyou.lean.domain.rentals;

import com.duriyou.lean.web.dto.rentals.RentalDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RentalsRepository extends JpaRepository<Rentals, Long> {
    @Query("SELECT new com.duriyou.lean.web.dto.rentals.RentalDetailsDto( " +
            "sc.name, " +
            "sc.address, " +
            "i.name, " +
            "rd.startTime, " +
            "rd.expirationTime, " +
            "u.name, " +
            "c.name, " +
            "u.phoneNumber " +
            ") " +
            "FROM Rentals r " +
            "JOIN r.items i " + // Rentals와 Items 간의 관계
            "LEFT JOIN r.rentalDates rd " + // Rentals와 RentalDates 간의 관계
            "JOIN r.users u " + // Rentals와 Users 간의 관계
            "JOIN u.college c " + // Users와 Colleges 간의 관계
            "JOIN i.studentCouncil sc " + // Items와 StudentCouncil 간의 관계
            "WHERE r.id = :rental_id " + // rental_id 조건
            "ORDER BY r.id ASC")
    RentalDetailsDto findRentalDetailsById(@Param("rental_id") Long rental_id);
}
