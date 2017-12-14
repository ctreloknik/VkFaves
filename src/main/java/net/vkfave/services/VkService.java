package net.vkfave.services;

import org.springframework.stereotype.Service;

/**
 * Сервис, получающий определённые данные, связанные с ВКонтакте.
 */
@Service
public class VkService {
    public String getVkAppId() {
        return System.getenv("VK_APP_ID");
    }
}
