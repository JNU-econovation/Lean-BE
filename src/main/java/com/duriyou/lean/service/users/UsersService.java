package com.duriyou.lean.service.users;

import com.duriyou.lean.domain.users.Users;
import com.duriyou.lean.domain.users.UsersRepository;
import com.duriyou.lean.web.dto.UsersResponseDto;
import com.duriyou.lean.web.dto.UsersSaveRequestDto;
import com.duriyou.lean.web.dto.UsersUpdateRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;


    @Transactional
    public Long save(UsersSaveRequestDto requestDto) {
        return usersRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, UsersUpdateRequestDto requestDto) {
        Users users = usersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다. id=" + id));
        users.update(requestDto.getStudentNumber(), requestDto.getName(), requestDto.getPhoneNumber(), requestDto.getCollege(), requestDto.getDepartment());
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
}
