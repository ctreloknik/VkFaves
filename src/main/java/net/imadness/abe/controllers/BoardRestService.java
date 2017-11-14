package net.imadness.abe.controllers;

import net.imadness.abe.models.Entry;
import net.imadness.abe.models.dto.EntryDto;
import net.imadness.abe.services.BoardService;
import net.imadness.abe.services.EntryService;
import net.imadness.abe.util.RestResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * REST-сервис, обслуживающий определённую доску. Обрабатывает все запросы, связанные каким-либо изменением
 * досок или записей
 */
@RestController
@RequestMapping("/board")
public class BoardRestService {

    @Autowired
    private BoardService boardService;

    @Autowired
    private EntryService entryService;

    private static final Logger LOGGER = LoggerFactory.getLogger(BoardRestService.class);

    /**
     * Возвращает записи для определённой страницы доски
     *
     * @param id   ID выбранной доски
     * @param page номер страницы
     * @return записи со страницы доски
     */
    @RequestMapping("/{id}/{page}")
    public ResponseEntity<RestResponseWrapper<List<Entry>>> getBoardPage(@PathVariable Long id, @PathVariable Integer page) {
        try {
            List<Entry> pageEntries = entryService.getEntries(id, page).getContent();
            LOGGER.info("Отдаём клиенту {} страницу доски #{}", page, id);
            return new ResponseEntity<>(new RestResponseWrapper<>(pageEntries), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.warn("Ошибка при получении {} страницы доски #{}", page, id, e);
            return new ResponseEntity<>(new RestResponseWrapper<>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Сохраняет в базе данных запись {@code Entry}, содержащуюся в теле клиентского запроса
     *
     * @param entry   DTO-представление записи
     * @param request объект запроса клиента
     * @return объект ответа сервера
     */
    @RequestMapping(value = "/postNew", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> postNewEntry(@RequestBody EntryDto entry, HttpServletRequest request) {
        try {
            entryService.insertEntry(entry);
            LOGGER.info("Запись {} добавлена на доску #{}", entry, entry.getBoardId());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.info("Ошибка при добавлении записи {} базу данных", entry, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public BoardRestService(BoardService boardService, EntryService entryService) {
        this.boardService = boardService;
        this.entryService = entryService;
    }

    public BoardRestService() {
    }
}
