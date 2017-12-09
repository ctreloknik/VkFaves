package net.vkfave.services;

import javax.transaction.Transactional;

import net.vkfave.model.User;
import net.vkfave.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.security.core.context.SecurityContextHolder;


/**
 * Сервис для получения текущего пользователя.
 */
@Service
public class CurrentUserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Возвращает текущего аутентифицированного пользователя.
	 * 
	 * @return аутентифицированный пользователь
	 */
	@Transactional
	public User getUser() {
//		if (SecurityContextHolder.getContext().getAuthentication()
//				.getPrincipal() instanceof org.springframework.security.core.userdetails.User) {
//
//			org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder
//					.getContext().getAuthentication().getPrincipal();
//			User u = new User(); //userRepository.findByVkId(user.getUsername());
//			return u;
//		} else
		return null;
	}

}
