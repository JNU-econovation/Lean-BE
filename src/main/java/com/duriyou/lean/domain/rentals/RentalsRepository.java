package com.duriyou.lean.domain.rentals;

import com.duriyou.lean.web.dto.rentals.RentalDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RentalsRepository extends JpaRepository<Rentals, Long> {
    @Query("""
        SELECT new com.duriyou.lean.web.dto.rentals.RentalDetailsDto(
            sc.name,
            sc.address,
            i.name,
            r.status,
            rd.startTime,
            rd.expirationTime,
            rsd.startTime,
            rsd.expirationTime,
            rtd.date,
            u.name,
            c.name,
            u.phoneNumber,
            u.department
        )
        FROM Rentals r
        JOIN r.items i
        LEFT JOIN r.rentalDates rd
        JOIN r.users u
        JOIN u.college c
        JOIN i.studentCouncil sc
        RIGHT JOIN ReservationDates rsd ON rsd.rentals.id = r.id
        LEFT JOIN ReturnDates rtd ON rtd.rentals.id = r.id
        WHERE r.id = :rental_id
        ORDER BY r.id ASC
        """)
    RentalDetailsDto findRentalDetailsById(@Param("rental_id") Long rental_id);
}
