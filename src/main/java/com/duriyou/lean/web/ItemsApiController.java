package com.duriyou.lean.web;

import com.duriyou.lean.service.items.ItemsService;
import com.duriyou.lean.web.dto.items.ItemAmountsResponseDto;
import com.duriyou.lean.web.dto.items.ItemAmountsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ItemsApiController {

    private final ItemsService itemsService;

    @GetMapping("/api/v1/items/amounts/{item_id}")
    public ItemAmountsResponseDto findItemAmountsById(@PathVariable Long item_id) {
        return itemsService.findItemAmountsById(item_id);
    }

    @PutMapping("/api/v1/items/amounts/{item_id}")
    public Long updateItemAmounts(@PathVariable Long item_id, @RequestBody ItemAmountsUpdateRequestDto ItemamountsUpdateRequestDto) {
        return itemsService.updateItemAmounts(item_id, ItemamountsUpdateRequestDto);
    }

}
