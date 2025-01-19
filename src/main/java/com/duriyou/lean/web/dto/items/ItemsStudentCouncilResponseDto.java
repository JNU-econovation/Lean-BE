package com.duriyou.lean.web.dto.items;

import com.duriyou.lean.domain.student.council.StudentCouncil;
import lombok.Getter;

import java.util.List;

@Getter
public class ItemsStudentCouncilResponseDto {

    private String studentCouncilName;
    private String studentCouncilAddress;
    private String collegeName;
    private List<ItemsNameResponseDto> items;

    public ItemsStudentCouncilResponseDto(StudentCouncil entity, List<ItemsNameResponseDto> items) {
        this.studentCouncilName = entity.getName();
        this.studentCouncilAddress = entity.getAddress();
        this.collegeName = entity.getUser().getCollege().getName();
        this.items = items;
    }
}