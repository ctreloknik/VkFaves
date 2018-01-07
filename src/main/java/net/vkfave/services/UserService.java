package net.vkfave.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.vkfave.dto.UserDto;
import net.vkfave.model.Token;
import net.vkfave.model.User;
import net.vkfave.repositories.TokenRepository;
import net.vkfave.repositories.UserRepository;
import net.vkfave.services.exception.UserValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TokenRepository tokenRepository;

	public User getUserById(Long id) {
		return userRepository.findOne(id);
	}

	/**
	 * Создаёт или обновляет пользователя, если он уже существует
	 * 
	 * @return обновлённый экземпляр пользователя
	 */
	public User createOrUpdateUser(UserDto userDto) {
		User existingUser = userRepository.findByVkId(userDto.getVkId());
		if (existingUser == null) {
			existingUser = new User();
			existingUser.setVkId(userDto.getVkId());
			existingUser.setName(userDto.getName());
		}

		existingUser.setLastAuthDate(new Date());
		existingUser = userRepository.save(existingUser);
		
		Token token = new Token(userDto.getToken(), existingUser);
		tokenRepository.save(token);
		
		return existingUser;
	}

	/**
	 * Метод валидации пользователя (!). Используется во всех (?!) методах API
	 * 
	 * @param accessToken
	 *            токен
	 * @param vkId
	 *            ID пользователя ВК
	 * @throws UserValidationException
	 *             Исключение валидации пользователя
	 */
	public User checkUser(String accessToken, Long vkId)
			throws UserValidationException {
		if (StringUtils.isEmpty(accessToken) || vkId == null) {
			throw new UserValidationException(
					"Cookie-параметры accessToken и vkId не должны быть пустыми");
		}
		User user = userRepository.findByVkId(vkId);
		if (user == null) {
			throw new UserValidationException("Пользователь [id=" + vkId
					+ "] не найден");
		}
//		if (!accessToken.equals(user.getToken())) {
//			throw new UserValidationException(
//					"Некорректное значение токена доступа для пользователя [id="
//							+ vkId + "]");
//		}
		return user;
	}

//	public User insertUser(UserDto userDto) {
//		User user = new User();
//		user.setName(userDto.getName());
//		user.setVkId(userDto.getVkId());
//		user.setToken(userDto.getToken());
//		return userRepository.save(user);
//	}
//
//	public User updateUser(UserDto user) {
//		User dbUser = userRepository.findOne(user.getId());
//		dbUser.setName(user.getName());
//		dbUser.setVkId(user.getVkId());
//		dbUser.setToken(user.getToken());
//		return userRepository.save(dbUser);
//	}

	public void deleteUser(Long id) {
		userRepository.delete(id);
	}
}
