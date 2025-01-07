package com.duriyou.lean.service.users;

import com.duriyou.lean.domain.colleges.Colleges;
import com.duriyou.lean.domain.colleges.CollegesRepository;
import com.duriyou.lean.domain.users.Users;
import com.duriyou.lean.domain.users.UsersRepository;
import com.duriyou.lean.web.dto.Users.AllUsersResponseDto;
import com.duriyou.lean.web.dto.Users.UsersResponseDto;
import com.duriyou.lean.web.dto.Users.UsersSaveRequestDto;
import com.duriyou.lean.web.dto.Users.UsersUpdateRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final CollegesRepository collegesRepository;

    public List<AllUsersResponseDto> findAll() {
        List<Users> users = usersRepository.findAll();
        return users.stream()
                .map(AllUsersResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long save(UsersSaveRequestDto requestDto) {
        Colleges colleges = findCollegeById(requestDto.getCollegeId());
        return usersRepository.save(requestDto.toEntity(colleges)).getId();
    }

    @Transactional
    public Long update(Long id, UsersUpdateRequestDto requestDto) {
        Users users = usersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다. id=" + id));
        Colleges colleges = findCollegeById(requestDto.getCollegeId());
        users.update(requestDto.getStudentNumber(), requestDto.getName(), requestDto.getPhoneNumber(), colleges, requestDto.getDepartment());
        return id;
    }

    public UsersResponseDto findById (Long id) {
        Users entity = usersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다. id=" + id));
        return new UsersResponseDto(entity);
    }

    @Transactional
    public void delete (Long id) {
        Users users = usersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다. id=" + id));
        usersRepository.delete(users);
    }

    private Colleges findCollegeById(Long collegeId) {
        if (collegeId == null) {
            return null;
        }
        return collegesRepository.findById(collegeId)
                .orElseThrow(() -> new IllegalArgumentException("해당 단과대학이 존재하지 않습니다."));
    }
}
