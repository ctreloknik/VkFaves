package net.imadness.abe.controllers;

import net.imadness.abe.controllers.exceptions.SpringControllerException;
import net.imadness.abe.models.Board;
import net.imadness.abe.services.AuthorService;
import net.imadness.abe.services.BoardService;
import net.imadness.abe.services.EntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Основной контроллер приложения, обеспечивающий обработку клиентских запросов,
 * связанных с главной страницей форума и базовые REST-методы
 */
@Controller
public class MainController {

    @Autowired
    private EntryService entryService;

    @Autowired
    private BoardService boardService;

    @Autowired
    private AuthorService authorService;

    private static final String APPLICATION_NAME = "April Board Engine";

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    /**
     * Подготавливает представление главной страницы
     */
    @RequestMapping("/")
    public String index(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws SpringControllerException {
        try {
            List<Board> boards = boardService.getAllBoards();
            modelMap.addAttribute("appName", APPLICATION_NAME);
            modelMap.addAttribute("boards", boards);
        } catch (Exception e) {
            LOGGER.trace("Ошибка при загрузке списка форумов на главную страницу", e);
            throw new SpringControllerException(e);
        }
        LOGGER.info("Главная страница подготовлена и загружена");
        return "index";
    }

    public MainController(EntryService entryService, BoardService boardService, AuthorService authorService) {
        this.entryService = entryService;
        this.boardService = boardService;
        this.authorService = authorService;
    }

    public MainController() {
    }
}
