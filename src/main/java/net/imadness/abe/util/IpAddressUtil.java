package net.imadness.abe.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Позволяет определять IP-адрес клиента на основе HTTP-заголовков его запроса
 *
 * @author <a href="http://stackoverflow.com/users/1107536/xavier-delamotte">Xavier Delamotte</a>
 */
public class IpAddressUtil {
    private static final String[] HEADERS_TO_TRY = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR"
    };

    /**
     * Перебирает HTTP-заголовки и проверяет каждый из них на наличие "unknown", если нет - возвращает значение данного заголовка.
     * В противном случае возвращает IP-адрес с помощью "стандартного" метода {@code HttpServletRequest}
     *
     * @param request
     * @return строка, содержащая IP-адрес клиента
     */
    public static String getClientIpAddress(HttpServletRequest request) {
        for (String header : HEADERS_TO_TRY) {
            String ip = request.getHeader(header);
            if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip))
                return ip;
        }
        return request.getRemoteAddr();
    }
}
