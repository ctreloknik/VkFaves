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
     * @return обновлённый экземпляр пользователя
     */
    public User createOrUpdateUser(UserDto userDto) {
        User existingUser = userRepository.findByVkId(userDto.getId());
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
