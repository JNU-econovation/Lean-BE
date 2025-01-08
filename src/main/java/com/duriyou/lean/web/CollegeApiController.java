package com.duriyou.lean.web;

import com.duriyou.lean.service.colleges.CollegesService;
import com.duriyou.lean.web.dto.Colleges.AllCollegesResponseDto;
import com.duriyou.lean.web.dto.Colleges.CollegesSaveRequestDto;
import com.duriyou.lean.web.dto.Colleges.CollegesUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CollegeApiController {
    private final CollegesService collegesService;

    @GetMapping("/api/v1/users/colleges")
    public List<AllCollegesResponseDto> getAllColleges() {
        return collegesService.findAll();
    }

    @PostMapping("/api/v1/users/colleges")
    public Long save(@RequestBody CollegesSaveRequestDto requestDto) {
        return collegesService.save(requestDto);
    }


    @PutMapping("/api/v1/users/colleges/{id}")
    public Long update(@PathVariable Long id, @RequestBody CollegesUpdateRequestDto requestDto) {
        return collegesService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/users/colleges/{id}")
    public Long delete(@PathVariable Long id) {
        collegesService.delete(id);
        return id;
    }
}
