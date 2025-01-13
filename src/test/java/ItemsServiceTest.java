import com.duriyou.lean.domain.items.Items;
import com.duriyou.lean.domain.items.ItemsRepository;
import com.duriyou.lean.domain.student.council.StudentCouncil;
import com.duriyou.lean.domain.student.council.StudentCouncilRepository;
import com.duriyou.lean.service.items.ItemsService;
import com.duriyou.lean.web.dto.items.ItemAmountsSaveRequestDto;
import com.duriyou.lean.web.dto.items.ItemsSaveRequestDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 안돌아감
public class ItemsServiceTest {

    @Mock
    private ItemsRepository itemsRepository;

    @Mock
    private StudentCouncilRepository studentCouncilRepository;

    @InjectMocks
    private ItemsService itemsService;

    @Before
    public void setUp() {
        // Mock 객체 초기화
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveItem_shouldSaveAndReturnId() {
        // Given
        Long studentCouncilId = 1L;
        StudentCouncil studentCouncil = new StudentCouncil();
        ItemsSaveRequestDto requestDto = new ItemsSaveRequestDto("Notebook", new ItemAmountsSaveRequestDto(50));

        // Mock 설정
        Mockito.when(studentCouncilRepository.findById(studentCouncilId)).thenReturn(Optional.of(studentCouncil));

        // Mock: ItemsRepository의 save 메서드 호출 시 동작 설정
        Mockito.when(itemsRepository.save(Mockito.any(Items.class))).thenAnswer(invocation -> {
            Items items = invocation.getArgument(0); // save 메서드에 전달된 Items 객체를 가져옴
            return Items.builder()
                    .studentCouncil(items.getStudentCouncil())
                    .name(items.getName())
                    .itemAmounts(items.getItemAmounts())
                    .build();
        });

        // When
        Long savedId = itemsService.saveItem(studentCouncilId, requestDto);

        // Then
        assertEquals(1L, savedId);
        Mockito.verify(itemsRepository, Mockito.times(1)).save(Mockito.any(Items.class));
    }
}