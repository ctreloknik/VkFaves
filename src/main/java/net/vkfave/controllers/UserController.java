package net.vkfave.controllers;

import java.net.URI;

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
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

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

	private String code;

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

	@GetMapping("/user/{id}")
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

	@GetMapping("/auth")
	public ResponseEntity<UserDto> authentificateUser(
			@RequestParam String code) {
		try {
			//if (this.code == null) {
				LOGGER.info("Code", code);
				//this.code = code;
				URI uri = new URI(
						"https://oauth.vk.com/access_token?client_id=6226858&client_secret=LnydhpxvBlM5NzvQSux3&redirect_uri=https://vk-faves.herokuapp.com/auth/finish&code="
								+ code);
				RestTemplate restTemplate = new RestTemplate();
				String result = restTemplate.getForObject(uri, String.class);
				LOGGER.info("result", result);
//			} else {
//				Gson gson = new Gson(); 
//				gson.toJson(body);
//				String token = gson.fromJson("access_token", String.class);
//				LOGGER.info("Token", token);
//			}

			// User user = userService.getUserById(id);
			// UserDto userDto = new UserDto(user.getName(), user.getVkId());
			return ResponseEntity.ok(new UserDto());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.build();
		}
	}

	// @RequestBody String body
	@GetMapping("/auth/finish")
	public ResponseEntity<String> authentificateFinishUser(
			@RequestBody String body) {
		try {
			
//			} else {
//				Gson gson = new Gson(); 
//				gson.toJson(body);
//				String token = gson.fromJson("access_token", String.class);
//				LOGGER.info("Token", token);
//			}

			// User user = userService.getUserById(id);
			// UserDto userDto = new UserDto(user.getName(), user.getVkId());
			return ResponseEntity.ok("ok");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.build();
		}
	}
}
