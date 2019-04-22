package com.geek.controller;



import com.geek.util.CookieUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class TestSessionController {

    @GetMapping("/login/cookie")
    public String loginCookie(Model model, HttpServletResponse response, HttpServletRequest request){
        model.addAttribute("name", "admin");
        CookieUtil.addCookie(response, "sdccdsdc","sddsds", 20200*80);
        HttpSession session = request.getSession();
        session.setAttribute("dsds","dsds");
        session.getAttribute("dsds");

        return "/index";
    }

}
