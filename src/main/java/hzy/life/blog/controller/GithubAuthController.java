package hzy.life.blog.controller;


import hzy.life.blog.dto.AccessTokenDto;
import hzy.life.blog.dto.GithubUser;

import hzy.life.blog.provider.GithubProvider;
import hzy.life.blog.service.AccessTokenDtoService;
import hzy.life.blog.service.OpenUserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class GithubAuthController {


    @Autowired
    private GithubProvider githubProvider;
    @Autowired
    private OpenUserService openUserService;

    @Autowired
    private AccessTokenDtoService accessTokenDtoService;


    @GetMapping("/callback")
    public String callback(@RequestParam("code") String code,
                           @RequestParam("state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response) {
        System.out.println("begin");

        AccessTokenDto accessTokenDto = this.accessTokenDtoService.getGitHubToken(code, state);
        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        GithubUser githubUser = githubProvider.getGithubuser(accessToken);

        if (githubUser != null && githubUser.getId() != null) {
            String t =this.openUserService.insertAndGetToken(githubUser);
            request.getSession().setAttribute("user", githubUser);
            response.addCookie(new Cookie("token", t));
            System.out.println(githubUser.getName());
            System.out.println("end");
            return "redirect:/";
        }

        return "redirect:/";
    }


}
