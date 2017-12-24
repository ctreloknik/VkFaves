package net.vkfave.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Контроллер, отвечающий за маппинг запросов для основных страниц приложения
 */
@Controller
public class MainController {

    @Value("${vk.app.id}")
    private String vkAppId;

    /**
     * Устанавливаем файл resources/views/index.ftl в качестве главной страницы
     */
    @RequestMapping("/")
    public String indexPageRequestMapper(@CookieValue(name = "accessToken", required = false) String accessToken,
                                         @CookieValue(name = "vkUserId", required = false)    String vkUserId,
                                         @RequestParam(name = "clr", required = false) String clearFlag,
                                         ModelMap modelMap, HttpServletRequest req, HttpServletResponse resp) {
        if (clearFlag != null) {
            for (Cookie cookie : req.getCookies()) {
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }
        modelMap.addAttribute("vkAppId", vkAppId);
        modelMap.addAttribute("token", accessToken != null ? accessToken : "none");
        modelMap.addAttribute("vkUserId", vkUserId != null ? vkUserId : "none");
        return "index";
    }

    /**
     * Маппинг для страницы редиректа ВК после авторизации
     */
    @RequestMapping("/auth")
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
