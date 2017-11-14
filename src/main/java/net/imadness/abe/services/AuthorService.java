package net.imadness.abe.services;

import net.imadness.abe.dal.AuthorRepository;
import net.imadness.abe.models.Author;
import net.imadness.abe.models.dto.AuthorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Содержит CRUD-методы на основе использования AuthorRepository
 * TODO дописать доменный объект автора (isBanned) и оставшуюся логику для реализации бана пользователей
 */
@Service
@Transactional
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    /**
     * Возвращает всех авторов и сортирует их по никнейму в алфавитном порядке
     *
     * @return отсортированный список из авотров
     */
    public List<Author> getAllAuthors() {
        return authorRepository.findAll(new Sort(Sort.Direction.ASC, "nickname"));
    }

    /**
     * Возвращает автора с определённым id
     *
     * @param id id автора
     * @return объект автора
     */
    public Author getAuthorById(Long id) {
        return authorRepository.findOne(id);
    }

    /**
     * Находит автора в базе данных по его IP-адресу
     *
     * @param ipAddress
     * @return объект автора
     */
    public Author getAuthorByIpAddress(String ipAddress) {
        return authorRepository.findByIpAddress(ipAddress);
    }

    /**
     * Добавляет в базу данных новую запись об авторе и возвращает добавленный объект
     *
     * @param authorDto сохраняемые данные в формате dto
     * @return объект автора
     */
    public Author insertAuthor(AuthorDto authorDto) {
        return authorRepository.saveAndFlush(authorDto.createAuthor());
    }

    /**
     * Обновляет экземпляр сущности автора в базе данных
     */
    public Author updateAuthor(AuthorDto authorDto) {
        Author dbAuthor = authorRepository.findByIpAddress(authorDto.getIpAddress());
        if (dbAuthor == null) {
            dbAuthor = authorRepository.findOne(authorDto.getId());
        }
        dbAuthor.setIpAddress(authorDto.getIpAddress());
        dbAuthor.setNickname(authorDto.getNickname());
        return authorRepository.saveAndFlush(dbAuthor);
    }

    /**
     * Удаляет автора с указанным id из базы данных
     *
     * @param id id автора
     */
    public void deleteAuthorById(Long id) {
        authorRepository.delete(id);
    }

}
