package com.duriyou.lean.service.colleges;

import com.duriyou.lean.domain.colleges.Colleges;
import com.duriyou.lean.domain.colleges.CollegesRepository;
import com.duriyou.lean.web.dto.Colleges.AllCollegesResponseDto;
import com.duriyou.lean.web.dto.Colleges.CollegesSaveRequestDto;
import com.duriyou.lean.web.dto.Colleges.CollegesUpdateRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CollegesService {
    private final CollegesRepository collegesRepository;

    public List<AllCollegesResponseDto> findAll() {
        List<Colleges> colleges = collegesRepository.findAll();
        return colleges.stream()
                .map(AllCollegesResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long save(CollegesSaveRequestDto requestDto) {
        return collegesRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, CollegesUpdateRequestDto requestDto) {
        Colleges colleges = collegesRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 단과대학이 존재하지 않습니다. id=" + id));
        colleges.update(requestDto.getName());
        return id;
    }


    @Transactional
    public void delete (Long id) {
        Colleges colleges = collegesRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 단과대학이 존재하지 않습니다. id=" + id));
        collegesRepository.delete(colleges);
    }
}
