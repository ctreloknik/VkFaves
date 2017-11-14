package net.imadness.abe.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.imadness.abe.models.Entry;
import net.imadness.abe.services.BoardService;
import net.imadness.abe.services.EntryService;
import net.imadness.abe.util.RestResponseWrapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Содержит тесты, проверяющие работу контроллера {@link BoardRestService}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MockServletContext.class)
@WebAppConfiguration
public class BoardRestServiceTest {

    private static final String BOARD_PAGE_REQUEST = "/board/1/1";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private MockMvc mockMvc;

    @Mock
    private BoardService boardService;

    @Mock
    private EntryService entryService;

    private RestResponseWrapper<List<Entry>> entryPage;

    /**
     * Инициализация заглушек и переменных
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new BoardRestService(boardService, entryService)).build();
        entryPage = new RestResponseWrapper<>(Collections.emptyList());
        when(entryService.getEntries(1L,1)).thenReturn(new PageImpl<>(entryPage.getData()));
    }

    /**
     * Проверяет корректность ответа сервера на запрос определённой страницы форума
     * @see BoardRestService#getBoardPage(Long, Integer)
     */
    @Test
    public void testGetBoardPage() throws Exception {
        String jsonEntryPage = OBJECT_MAPPER.writeValueAsString(entryPage);
        mockMvc.perform(MockMvcRequestBuilders.get(BOARD_PAGE_REQUEST))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string(equalTo(jsonEntryPage)));
    }

}
