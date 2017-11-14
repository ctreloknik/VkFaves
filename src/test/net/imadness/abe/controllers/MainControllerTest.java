package net.imadness.abe.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.imadness.abe.models.Author;
import net.imadness.abe.models.Board;
import net.imadness.abe.services.AuthorService;
import net.imadness.abe.services.BoardService;
import net.imadness.abe.services.EntryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Валерий on 23.10.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MockServletContext.class)
@WebAppConfiguration
public class MainControllerTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private MockMvc mockMvc;
    @Mock
    private EntryService entryService;
    @Mock
    private BoardService boardService;
    @Mock
    private AuthorService authorService;

    private String ipAddress = "127.0.0.1";
    private Author mockAuthor = new Author("Alice", ipAddress);
    private List<Board> mockBoards = Arrays.asList(
            new Board("B1"),
            new Board("B2")
    );

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new MainController(entryService, boardService, authorService)).build();
        when(authorService.getAuthorByIpAddress(ipAddress)).thenReturn(mockAuthor);
        when(boardService.getAllBoards()).thenReturn(mockBoards);
    }

    /**
     * @see MainController#index(ModelMap, String, HttpServletRequest, HttpServletResponse)
     */
    @Test
    public void testPageEntrance() throws Exception {
        mockMvc.perform(get("/"))
               .andExpect(status().isOk())
               .andExpect(model().attribute("boards", hasSize(2)));

    }

}
