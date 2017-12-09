package net.vkfave.controllers;

import javax.servlet.http.HttpServletRequest;

import net.vkfave.dto.UserDto;
import net.vkfave.model.User;
import net.vkfave.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerNewUser(@RequestBody UserDto userDto) {
        try {
            User newUser = userService.insertUser(userDto);
            LOGGER.info("Добавлен новый пользователь", newUser);
            userDto.setId(newUser.getId());
            return ResponseEntity.ok(userDto);
        } catch (Exception e) {
            LOGGER.error("Ошибка при попытке добавления нового пользователя", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
//    @RequestMapping("/auth")
//    public ResponseEntity<String> auth(HttpServletRequest req) {
//    	LOGGER.info("Токен");
//    	return ResponseEntity.ok("ok");
//    }
}
