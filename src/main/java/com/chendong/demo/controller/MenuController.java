package com.chendong.demo.controller;

import com.chendong.demo.domain.response.Rep;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author chendong
 * @since 2021-06-22
 */
@RestController
@RequestMapping("/api/v1")
public class MenuController extends BaseController {

    @Data
    private static class User {

        private String username;

        private String password;
    }

    @PostMapping("/login")
    public Rep<String> addEmp(@RequestBody User user, HttpServletResponse response) {

        Rep<String> rep = new Rep<>();
        rep.setData(user.getUsername());

        if ("admin".equals(user.getUsername()) && "admin123".equals(user.getPassword())) {
            rep.setStatus(0);
            Cookie cookie = new Cookie("amisToken", "111111");
            cookie.setMaxAge(3600);
            response.addCookie(cookie);
            return rep;
        }

        rep.setStatus(-1);
        return rep;

    }
}
