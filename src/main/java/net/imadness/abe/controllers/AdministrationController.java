package net.imadness.abe.controllers;

import net.imadness.abe.controllers.exceptions.SpringControllerException;
import net.imadness.abe.models.dto.BoardDto;
import net.imadness.abe.services.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Управление сервсиом
 */
@Controller
@RequestMapping("/adm")
public class AdministrationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdministrationController.class);

    @Autowired
    private BoardService boardService;

    @RequestMapping("/")
    public String adminPanel(ModelMap modelMap) {
        return "admin";
    }

    @RequestMapping("/boards/new")
    @ResponseBody
    public ResponseEntity<String > createBoardRequest(@RequestBody BoardDto newBoard) throws SpringControllerException {
        try {
            boardService.insertBoard(newBoard);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.warn("Ошибка при добавлении новой доски", e);
            throw new SpringControllerException(e);
        }
    }
}
