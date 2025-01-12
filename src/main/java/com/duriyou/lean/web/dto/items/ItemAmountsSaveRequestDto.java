package com.duriyou.lean.web.dto.items;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemAmountsSaveRequestDto {
    private Integer amounts;

    @Builder
    public ItemAmountsSaveRequestDto(Integer amounts) {
        this.amounts = amounts;
    }
}
