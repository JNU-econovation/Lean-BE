package com.duriyou.lean.service.items;

import com.duriyou.lean.domain.items.ItemAmounts;
import com.duriyou.lean.domain.items.ItemAmountsRepository;
import com.duriyou.lean.domain.items.Items;
import com.duriyou.lean.domain.items.ItemsRepository;
import com.duriyou.lean.domain.student.council.StudentCouncil;
import com.duriyou.lean.domain.student.council.StudentCouncilRepository;
import com.duriyou.lean.web.dto.items.ItemAmountsResponseDto;
import com.duriyou.lean.web.dto.items.ItemAmountsSaveRequestDto;
import com.duriyou.lean.web.dto.items.ItemAmountsUpdateRequestDto;
import com.duriyou.lean.web.dto.items.ItemsSaveRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ItemsService {

    private final ItemAmountsRepository itemAmountsRepository;
    private final StudentCouncilRepository studentCouncilRepository;
    private final ItemsRepository itemsRepository;

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

    @Transactional
    public void deleteItem(Long id) {
        Items items = itemsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 물품이 없습니다. id =" + id));
        itemsRepository.delete(items);
    }

    @Transactional
    public Long saveItem(Long id, ItemsSaveRequestDto itemsSaveRequestDto) {

        // studentCouncil 엔티티 조회
        StudentCouncil studentCouncil = studentCouncilRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 학생회가 존재하지 않습니다. id=" + id));

        // 새로운 Items 생성
        Items items = new Items();
        items.setItemName(itemsSaveRequestDto.getName());
        // studentCouncil 과 연관관계 설정
        items.setStudentCouncil(studentCouncil);

        // ItemAmount 엔티티 생성 및 Items 와 연결
        ItemAmountsSaveRequestDto amountDto = itemsSaveRequestDto.getItemAmounts();
        ItemAmounts itemAmounts = new ItemAmounts();
        itemAmounts.setAmount(amountDto.getAmounts());
        itemAmounts.setItems(items);

        // Items 에 ItemAmounts 추가
        items.addItemAmounts(itemAmounts);

        // Items 저장
        Items saveItem = itemsRepository.save(items);

        return saveItem.getId();
    }

}
