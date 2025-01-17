package com.duriyou.lean.web;

import com.duriyou.lean.service.items.ItemsService;
import com.duriyou.lean.web.dto.items.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ItemsApiController {

    private final ItemsService itemsService;
    // I - 06
    @GetMapping("/api/v1/items/amounts/{item_id}")
    public ItemAmountsResponseDto findItemAmountsById(@PathVariable Long item_id) {
        return itemsService.findItemAmountsById(item_id);
    }
    // I - 07
    @PutMapping("/api/v1/items/amounts/{item_id}")
    public Long updateItemAmounts(@PathVariable Long item_id, @RequestBody ItemAmountsUpdateRequestDto ItemamountsUpdateRequestDto) {
        return itemsService.updateItemAmounts(item_id, ItemamountsUpdateRequestDto);
    }
    // I - 05
    @DeleteMapping("/api/v1/items/{item_id}")
    public Long deleteItem(@PathVariable Long item_id) {
        itemsService.deleteItem(item_id);
        return item_id;
    }
    // I - 03
    @GetMapping("/api/v1/items/{item_id}")
    public ItemsResponseDto findItemsById(@PathVariable Long item_id) {
        return itemsService.findItemsById(item_id);
    }
    // I - 02
    @PostMapping("/api/v1/items/student-council/{student_council_id}")
    public Long saveItem(@PathVariable Long student_council_id, @RequestBody ItemsSaveRequestDto itemsSaveRequestDto) {
        return itemsService.saveItem(student_council_id, itemsSaveRequestDto);
    }
    // I - 01
    @GetMapping("/api/v1/items/student-council/{student_council_id}")
    public ItemsStudentCouncilResponseDto findItemsByStudentCouncilId(@PathVariable Long student_council_id) {
        return itemsService.findItemsByStudentCouncilId(student_council_id);
    }

}
