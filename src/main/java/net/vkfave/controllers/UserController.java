package net.vkfave.controllers;

import net.vkfave.dto.UserDto;
import net.vkfave.model.User;
import net.vkfave.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Value("${vk.app.id}")
	private String vkAppId;

	@Value("${vk.app.id}")
	private String vkAppSecret;

	@PostMapping("/register")
	public ResponseEntity<UserDto> registerNewUser(@RequestBody UserDto userDto) {
		try {
			User newUser = userService.insertUser(userDto);
			LOGGER.info("Добавлен новый пользователь", newUser);
			userDto.setId(newUser.getId());
			return ResponseEntity.ok(userDto);
		} catch (Exception e) {
			LOGGER.error("Ошибка при попытке добавления нового пользователя", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.build();
		}
	}

	@GetMapping("/api/user/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
		try {
			User user = userService.getUserById(id);
			UserDto userDto = new UserDto(user.getName(), user.getVkId());
			return ResponseEntity.ok(userDto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.build();
		}
	}

	@GetMapping("/api/auth")
	public ResponseEntity<String> authentificateUser(@RequestParam String access_token, @RequestParam Long user_id) {
		try {
			return ResponseEntity.ok("ok");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.build();
		}
	}
}
