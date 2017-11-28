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

    public User getUserById(Long id) {
        return userRepository.findOne(id);
    }

    public User insertUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setVkId(user.getVkId());
        return userRepository.save(user);
    }

    public User updateUser(User user, Long id) {
    	User dbUser = userRepository.findOne(id);
    	dbUser.setName(user.getName());
    	dbUser.setVkId(user.getVkId());
    	return userRepository.save(dbUser);
    }

    public void deleteUser(Long id) {
        userRepository.delete(id);
    }
}
