package com.duriyou.lean.web;

import com.duriyou.lean.service.users.UsersService;
import com.duriyou.lean.web.dto.Users.AllUsersResponseDto;
import com.duriyou.lean.web.dto.Users.UsersResponseDto;
import com.duriyou.lean.web.dto.Users.UsersSaveRequestDto;
import com.duriyou.lean.web.dto.Users.UsersUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UsersService usersService;

    @GetMapping("/api/v1/users")
    public List<AllUsersResponseDto> getAllUsers() {
        return usersService.findAll();
    }

    @PostMapping("/api/v1/users")
    public Long save(@RequestBody UsersSaveRequestDto requestDto) {
        return usersService.save(requestDto);
    }

    @GetMapping("/api/v1/users/{id}")
    public UsersResponseDto findById(@PathVariable Long id) {
        return usersService.findById(id);
    }

    @PutMapping("/api/v1/users/{id}")
    public Long update(@PathVariable Long id, @RequestBody UsersUpdateRequestDto requestDto) {
        return usersService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/users/{id}")
    public Long delete(@PathVariable Long id) {
        usersService.delete(id);
        return id;
    }

    @PutMapping("api/v1/users/is-student-council/{id}")
    public Boolean update(@PathVariable Long id) {
        return usersService.updateIsStudentCouncil(id);
    }
}
