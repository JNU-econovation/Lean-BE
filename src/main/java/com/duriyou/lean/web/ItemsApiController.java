package com.duriyou.lean.web;

import com.duriyou.lean.service.items.ItemsService;
import com.duriyou.lean.web.dto.items.ItemAmountsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ItemsApiController {

    private final ItemsService itemsService;

    @GetMapping("/api/v1/items/amounts/{item_id}")
    public ItemAmountsResponseDto findItemAmountsById(@PathVariable Long item_id) {
        return itemsService.findItemAmountsById(item_id);
    }

}
