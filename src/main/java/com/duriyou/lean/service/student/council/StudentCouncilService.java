package com.duriyou.lean.service.student.council;

import com.duriyou.lean.domain.student.council.StudentCouncil;
import com.duriyou.lean.domain.student.council.StudentCouncilRepository;
import com.duriyou.lean.domain.users.Users;
import com.duriyou.lean.domain.users.UsersRepository;
import com.duriyou.lean.web.dto.Student.Council.AllStudentCouncilResponseDto;
import com.duriyou.lean.web.dto.Student.Council.StudentCouncilResponseDto;
import com.duriyou.lean.web.dto.Student.Council.StudentCouncilSaveRequestDto;
import com.duriyou.lean.web.dto.Student.Council.StudentCouncilUpdateRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentCouncilService {
    private final StudentCouncilRepository studentCouncilRepository;
    private final UsersRepository usersRepository;

    public List<AllStudentCouncilResponseDto> findAll() {
        List<StudentCouncil> studentCouncil = studentCouncilRepository.findAll();
        return studentCouncil.stream()
                .map(AllStudentCouncilResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long save(StudentCouncilSaveRequestDto requestDto) {
        Users user = findUserById(requestDto.getUserId());
        return studentCouncilRepository.save(requestDto.toEntity(user)).getId();
    }

    @Transactional
    public Long update(Long id, StudentCouncilUpdateRequestDto requestDto) {
        StudentCouncil studentCouncil = studentCouncilRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 학생회가 존재하지 않습니다. id=" + id));
        Users user = findUserById(requestDto.getUserId());
        studentCouncil.update(user, requestDto.getName(), requestDto.getAddress());
        return id;
    }

    public StudentCouncilResponseDto findById (Long id) {
        StudentCouncil entity = studentCouncilRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 학생회가 존재하지 않습니다. id=" + id));
        return new StudentCouncilResponseDto(entity);
    }

    @Transactional
    public void delete (Long id) {
        StudentCouncil studentCouncil = studentCouncilRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 학생회가 존재하지 않습니다. id=" + id));
        studentCouncilRepository.delete(studentCouncil);
    }

    private Users findUserById(Long userId) {
        if (userId == null) {
            return null;
        }
        return usersRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));
    }
}
