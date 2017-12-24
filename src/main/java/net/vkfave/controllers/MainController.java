package net.vkfave.controllers;

import net.vkfave.dto.UserDto;
import net.vkfave.model.User;
import net.vkfave.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * Контроллер, отвечающий за маппинг запросов для основных страниц приложения
 */
@Controller
public class MainController {
    private static final String AUTH_PAGE = "/auth";

    @Autowired
    private UserService userService;

    @Value("${vk.app.id}")
    private String vkAppId;

    /**
     * Устанавливаем файл resources/views/index.ftl в качестве главной страницы
     */
    @RequestMapping("/")
    public String indexPageRequestMapper(@RequestParam(name = "accessToken", required = false) String accessToken,
                                         @RequestParam(name = "vkUserId",    required = false) Long vkUserId,
                                         ModelMap modelMap, HttpServletRequest request) {
        modelMap.addAttribute("vkAppId", vkAppId);
        String referer = request.getHeader("Referer");
        if (referer != null && referer.contains(AUTH_PAGE)) {
            try {
                User currentUser = userService.checkUser(accessToken, vkUserId);
                modelMap.addAttribute("user", new UserDto(currentUser));
            } catch (Exception e) {
                modelMap.addAttribute("user", null);
            }
        }
        return "index";
    }

    /**
     * Маппинг для страницы редиректа ВК после авторизации
     */
    @RequestMapping(AUTH_PAGE)
    public String authPage(ModelMap modelMap) {
        modelMap.addAttribute("vkAppId", vkAppId);
        return "auth";
    }

    /**
     * Возвращает JSON с информацией о системе. Также нужен для проверки работоспособности API
     */
    @GetMapping("/sys/info")
    @ResponseBody
    public SystemInfoDO getSystemInfo() {
        return SystemInfoDO.INSTANCE;
    }

    private static class SystemInfoDO {
        public static final SystemInfoDO INSTANCE = new SystemInfoDO(
                Arrays.asList("Чеботарёв Н.С.", "Романов В.М"),
                "0.0.1",
                "https://github.com/ctreloknik/VkFaves"
        );

        public final List<String> authors;
        public final String version;
        public final String repository;

        public SystemInfoDO(List<String> authors, String version, String repository) {
            this.authors = authors;
            this.version = version;
            this.repository = repository;
        }
    }
}
