package com.duriyou.lean.web.dto.items;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemAmountsUpdateRequestDto {
    private Integer amount;

    @Builder
    public ItemAmountsUpdateRequestDto(Integer amount){
        this.amount = amount;
    }
}
