package hzy.life.blog.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.deploy.net.HttpResponse;
import hzy.life.blog.dto.QuestionList;
import hzy.life.blog.mapper.OpenUserMapper;
import hzy.life.blog.model.OpenUser;
import hzy.life.blog.service.OpenUserService;
import hzy.life.blog.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired(required = false)
    private OpenUserService openUserService;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model,
                        @RequestParam(required = false, defaultValue = "1", value = "pageNum") Integer pageNum,
                        @RequestParam(defaultValue = "5", value = "pageSize") Integer pageSize) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies)
                if ("token".equals(cookie.getName())) {
                    String token = cookie.getValue();
                    OpenUser openUser = openUserService.findToken(token);
                    if (openUser != null) {
                        request.getSession().setAttribute("user", openUser);
                    }
                    break;
                }
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 5;
        }

        PageHelper.startPage(pageNum, pageSize);
        try {
            List<QuestionList> questionLists = questionService.getQuesList();
            PageInfo<QuestionList> pageInfo = new PageInfo<QuestionList>(questionLists, pageSize);
            model.addAttribute("quesList",questionLists);
            model.addAttribute("pageInfo", pageInfo);
        } finally {
            PageHelper.clearPage();
        }

        return "index";
    }

//    @GetMapping("/publish")
//    public String publish() {
//        return "publish";
//    }

}
