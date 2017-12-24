package net.vkfave.services;

import net.vkfave.dto.UserDto;
import net.vkfave.model.User;
import net.vkfave.repositories.UserRepository;
import net.vkfave.services.exception.UserNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findOne(id);
    }

    /**
     * Создаёт или обновляет пользователя, если он уже существует
     * @return обновлённый экземпляр пользователя
     */
    public User createOrUpdateUser(UserDto userDto) {
        User existingUser = userRepository.findByVkId(userDto.getVkId());
        if (existingUser == null) {
            User newUser = new User();
            newUser.setToken(userDto.getToken());
            newUser.setVkId(userDto.getVkId());
            newUser.setName(userDto.getName());
            newUser.setLastAuthDate(new Date());
            return userRepository.save(newUser);
        }
        if (!existingUser.getToken().equals(userDto.getToken())) {
            existingUser.setToken(userDto.getToken());
        }
        existingUser.setLastAuthDate(new Date());
        return userRepository.save(existingUser);
    }

    /**
     * Метод валидации пользователя (!). Используется во всех (?!) методах API
     * @param accessToken токен
     * @param vkId ID пользователя ВК
     * @throws UserNotValidException Исключение валидации пользователя
     */
    public void checkUser(String accessToken, Long vkId) throws UserNotValidException {
        if (StringUtils.isEmpty(accessToken) || vkId == null) {
            throw new UserNotValidException("Cookie-параметры accessToken и vkId не должны быть пустыми");
        }
        User user = userRepository.findByVkId(vkId);
        if (user == null) {
            throw new UserNotValidException("Пользователь [id=" + vkId + "] не найден");
        }
        if (!accessToken.equals(user.getToken())) {
            throw new UserNotValidException("Некорректное значение токена доступа для пользователя [id=" + vkId + "]");
        }
    }

    public User insertUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setVkId(userDto.getVkId());
        user.setToken(userDto.getToken());
        return userRepository.save(user);
    }

    public User updateUser(UserDto user) {
    	User dbUser = userRepository.findOne(user.getId());
    	dbUser.setName(user.getName());
    	dbUser.setVkId(user.getVkId());
    	dbUser.setToken(user.getToken());
    	return userRepository.save(dbUser);
    }

    public void deleteUser(Long id) {
        userRepository.delete(id);
    }
}
