package com.duriyou.lean.web.dto.items;

import com.duriyou.lean.domain.items.ItemAmounts;
import lombok.Getter;

@Getter
public class ItemAmountsResponseDto {

    private final Integer itemAmount;
    private final Integer processAmount;
    private final Integer rentAmount;
    private final Integer stock;

    public ItemAmountsResponseDto(ItemAmounts entity, Integer processAmount, Integer rentAmount, Integer stock){
        this.itemAmount = entity.getAmount();
        this.processAmount = processAmount;
        this.rentAmount = rentAmount;
        this.stock = stock;
    }
}
