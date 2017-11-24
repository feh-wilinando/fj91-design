package br.com.caelum.fj91design.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("login")
public class LoginController {


    @GetMapping
    public ModelAndView form(){
        return new ModelAndView("login/form");
    }


    @PostMapping
    public ModelAndView signIn(String username, String password, String provedor){

        System.out.println(username);
        System.out.println(password);
        System.out.println(provedor);

        return new ModelAndView("redirect:/admin/filmes");
    }

}
