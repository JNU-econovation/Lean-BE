package com.duriyou.lean.domain.student.council;

import com.duriyou.lean.web.dto.rentals.StudentCouncilAllRentalsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentCouncilRepository extends JpaRepository<StudentCouncil, Long> {
    // 텍스트 블록 방식 + ON 조건 명시
    @Query("""
       SELECT new com.duriyou.lean.web.dto.rentals.StudentCouncilAllRentalsDto(
           u.name,
           i.name,
           r.status,
           r.id,
           rd.expirationTime
       )
       FROM StudentCouncil sc
       RIGHT JOIN Items i ON sc.id = i.studentCouncil.id
       RIGHT JOIN Rentals r ON i.id = r.items.id
       LEFT JOIN Users u ON u.id = r.users.id
       LEFT JOIN RentalDates rd ON r.id = rd.rentals.id
       WHERE sc.id = :student_council_id
       ORDER BY r.id ASC
       """)
    List<StudentCouncilAllRentalsDto> findStudentCouncilAllRentalsById(@Param("student_council_id") Long student_council_id);
}
