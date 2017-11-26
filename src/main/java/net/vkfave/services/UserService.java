package net.vkfave.services;

import net.vkfave.model.User;
import net.vkfave.dto.UserDto;
import net.vkfave.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Возвращает объект форумной записи с определённым ID
     *
     * @param id id записи
     * @return запись
     */
    public User getUserById(Long id) {
        return userRepository.findOne(id);
    }

    /**
     * Сохраняет объект записи в БД
     *
     * @param userDto запись для сохранения
     * @return сохраненный объект
     */
    public User insertUser(UserDto userDto) {
//        Board board = boardRepository.findOne(entry.getBoardId());
//        Entry result = entry.createEntry();
//        result.setDate(new Date());
//        result.setBoard(board);
//        return entryRepository.save(result);
    	return new User(); // TODO заглушка
    }

    /**
     * Изменяет данные об уже существующей в БД записи
     *
     * @param user экземпляр записи с новыми данными
     * @param id   id записи, которую нужно обновить
     * @return сохраненный объект
     */
    public User updateUser(User user, Long id) {
//        Entry dbEntry = userRepository.findOne(id);
//        dbEntry.setContent(entry.getContent());
//        dbEntry.setDate(entry.getDate());
//        return entryRepository.save(dbEntry);
    	return new User();
    }

    /**
     * Удаляет определённую запись из БД
     *
     * @param id id удаляемой записи
     */
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }
}
