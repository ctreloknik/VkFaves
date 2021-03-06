package net.vkfave.controllers;

import net.vkfave.dto.UserDto;
import net.vkfave.model.User;
import net.vkfave.services.UserService;
import net.vkfave.util.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/user")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Value("${vk.app.id}")
	private String vkAppId;

    @PutMapping("/auth")
    public ResponseEntity authenticateUser(@RequestBody UserDto userDto, HttpServletResponse response) {
        try {
            LOGGER.info("Запрос на аутентификацию пользователя {}. Токен: {}", userDto.getVkId(), userDto.getToken());
            UserDto result = new UserDto(userService.createOrUpdateUser(userDto));
            response.addCookie(new Cookie("accessToken", userDto.getToken()));
            response.addCookie(new Cookie("vkUserId", userDto.getVkId().toString()));
            return ResponseEntity.ok(new ResponseWrapper<>(result, "Успешная авторизация"));
        } catch (Exception e) {
            LOGGER.error("Ошибка при попытке авторизовать пользователя {}", userDto.getVkId());
            return new ResponseEntity<>(new ResponseWrapper<>(null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//	@PostMapping("/register")
//	public ResponseEntity<UserDto> registerNewUser(@RequestBody UserDto userDto) {
//		try {
//			User newUser = userService.insertUser(userDto);
//			LOGGER.info("Добавлен новый пользователь", newUser);
//			userDto.setId(newUser.getId());
//			return ResponseEntity.ok(userDto);
//		} catch (Exception e) {
//			LOGGER.error("Ошибка при попытке добавления нового пользователя", e);
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//					.build();
//		}
//	}

	@GetMapping("/test")
	public ResponseEntity<UserDto> getUserById(@RequestParam Long vkid, @RequestParam String name, @RequestParam String token) {
		try {
			LOGGER.info("Запрос на аутентификацию пользователя {}. Токен: {}", name, token);
			UserDto test = new UserDto(name, vkid);
			test.setToken(token);
			
            UserDto result = new UserDto(userService.createOrUpdateUser(test));
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> test(@PathVariable Long id) {
		try {
			User user = userService.getUserById(id);
			UserDto userDto = new UserDto(user.getName(), user.getVkId());
			return ResponseEntity.ok(userDto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.build();
		}
	}
}
