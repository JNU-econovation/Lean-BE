package com.duriyou.lean.domain.student.council;

import com.duriyou.lean.web.dto.rentals.StudentCouncilAllRentalsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentCouncilRepository extends JpaRepository<StudentCouncil, Long> {
    @Query("SELECT new com.duriyou.lean.web.dto.rentals.StudentCouncilAllRentalsDto( " +
            "u.name, " +
            "i.name, " +
            "r.status, " +
            "r.id " +
            ") " +
            "FROM StudentCouncil sc " +
            "RIGHT JOIN Items i ON sc.id = i.studentCouncil.id " +
            "RIGHT JOIN Rentals r ON i.id = r.items.id " +
            "LEFT JOIN Users u ON u.id = r.users.id " +
            "WHERE sc.id = :student_council_id " +
            "ORDER BY r.id ASC")
    List<StudentCouncilAllRentalsDto> findStudentCouncilAllRentalsById(@Param("student_council_id") Long student_council_id);
}
