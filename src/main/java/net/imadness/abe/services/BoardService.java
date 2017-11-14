package net.imadness.abe.services;

import net.imadness.abe.dal.BoardRepository;
import net.imadness.abe.models.Board;
import net.imadness.abe.models.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Содержит CRUD-методы на основе использования BoardRepository
 */
@Service
@Transactional
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    /**
     * Возвращает все доски и сортирует их по имени в алфавитном порядке
     *
     * @return отсортированный список из досок
     */
    public List<Board> getAllBoards() {
        return boardRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
    }

    /**
     * Возвращает доску с определённым ID
     *
     * @param id id доски
     * @return объект доски
     */
    public Board getBoardById(Long id) {
        return boardRepository.getOne(id);
    }

    /**
     * Добавляет новую доску в БД
     * @param board объект доски для сохранения
     * @return сохраняемый объект
     */
    public Board insertBoard(Board board) {
        return boardRepository.save(board);
    }

    /**
     * Добавляет новую доску в БД с использованием DTO
     * @param boardDto клиентские данные о новой доске
     * @return сохраняемый объект
     */
    public Board insertBoard(BoardDto boardDto) {
        return boardRepository.save(boardDto.createBoard());
    }

    /**
     * Изменяет данные об уже существующей доске в БД
     *
     * @param board экземпляр доски с новыми данными
     * @param id    id доски, которую нужно обновить
     */
    public Board updateBoard(Board board, Long id) {
        Board dbBoard = boardRepository.getOne(id);
        dbBoard.setName(board.getName());
        return boardRepository.save(dbBoard);
    }

    /**
     * Удаляет определённую доску из бд
     *
     * @param id id удаляемой доски
     */
    public void deleteBoard(Long id) {
        boardRepository.delete(id);
    }

}
