package net.vkfave.services;

import net.vkfave.dto.UserDto;
import net.vkfave.model.User;
import net.vkfave.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * @param userId      id пользователя в ВК
     * @param accessToken токен доступа API ВК
     * @return обновлённый экземпляр пользователя
     */
    public User createOrUpdateUser(Long userId, String accessToken) {
        User existingUser = userRepository.findByVkId(userId);
        if (existingUser == null) {
            User newUser = new User();
            newUser.setToken(accessToken);
            newUser.setLastAuthDate(new Date());
            return userRepository.save(newUser);
        }
        if (!existingUser.getToken().equals(accessToken)) {
            existingUser.setToken(accessToken);
        }
        existingUser.setLastAuthDate(new Date());
        return userRepository.save(existingUser);
    }

    public User insertUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setVkId(userDto.getVkId());
        user.setToken(userDto.getAccessToken());
        return userRepository.save(user);
    }

    public User updateUser(UserDto user) {
    	User dbUser = userRepository.findOne(user.getId());
    	dbUser.setName(user.getName());
    	dbUser.setVkId(user.getVkId());
    	dbUser.setToken(user.getAccessToken());
    	return userRepository.save(dbUser);
    }

    public void deleteUser(Long id) {
        userRepository.delete(id);
    }
}
