package com.duriyou.lean.web;

import com.duriyou.lean.service.student.council.StudentCouncilService;
import com.duriyou.lean.web.dto.Student.Council.AllStudentCouncilResponseDto;
import com.duriyou.lean.web.dto.Student.Council.StudentCouncilResponseDto;
import com.duriyou.lean.web.dto.Student.Council.StudentCouncilSaveRequestDto;
import com.duriyou.lean.web.dto.Student.Council.StudentCouncilUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudentCouncilApiController {
    private final StudentCouncilService studentCouncilService;

    @GetMapping("/api/v1/users/student-council")
    public List<AllStudentCouncilResponseDto> getAllUsers() {
        return studentCouncilService.findAll();
    }

    @PostMapping("/api/v1/users/student-council")
    public Long save(@RequestBody StudentCouncilSaveRequestDto requestDto) {
        return studentCouncilService.save(requestDto);
    }

    @GetMapping("/api/v1/users/student-council/{id}")
    public StudentCouncilResponseDto findById(@PathVariable Long id) {
        return studentCouncilService.findById(id);
    }

    @PutMapping("/api/v1/users/student-council/{id}")
    public Long update(@PathVariable Long id, @RequestBody StudentCouncilUpdateRequestDto requestDto) {
        return studentCouncilService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/users/student-council/{id}")
    public Long delete(@PathVariable Long id) {
        studentCouncilService.delete(id);
        return id;
    }
}
