package com.duriyou.lean.service.items;

import com.duriyou.lean.domain.items.ItemAmounts;
import com.duriyou.lean.domain.items.ItemAmountsRepository;
import com.duriyou.lean.web.dto.items.ItemAmountsResponseDto;
import com.duriyou.lean.web.dto.items.ItemAmountsUpdateRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ItemsService {

    private final ItemAmountsRepository itemAmountsRepository;

    public ItemAmountsResponseDto findItemAmountsById (Long id) {
        ItemAmounts entity = itemAmountsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 물품이 존재하지 않습니다. id =" + id));
        return new ItemAmountsResponseDto(entity);
    }

    @Transactional
    public Long updateItemAmounts(Long id, ItemAmountsUpdateRequestDto itemAmountsUpdateRequestDto) {
        ItemAmounts itemAmounts = itemAmountsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 물품이 존재하지 안습니다. id =" + id));
        itemAmounts.updateAmount(itemAmountsUpdateRequestDto.getAmount());
        return id;
    }

}
