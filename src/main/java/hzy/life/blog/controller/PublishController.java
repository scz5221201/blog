package hzy.life.blog.controller;


import hzy.life.blog.mapper.OpenUserMapper;
import hzy.life.blog.model.OpenUser;
import hzy.life.blog.model.Question;
import hzy.life.blog.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PublishController {

    @Autowired
    QuestionService questionService;

    @Autowired(required = false)
    OpenUserMapper openUserMapper;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }



    @PostMapping("/publish")
    public String publishQues(@RequestParam("title") String title,
                              @RequestParam("content") String content,
                              @RequestParam("tag") String tag,
                              Model model,
                              HttpServletRequest request) {

        model.addAttribute("title", title);
        model.addAttribute("content", content);
        model.addAttribute("tag", tag);

        if (title == null || title == "") {
            model.addAttribute("error", "标题不能为空");
            return "publish";
        }
        if (content == null || content == "") {
            model.addAttribute("error", "内容不能为空");
            return "publish";
        }
        if (tag == null || tag == "") {
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }

        System.out.println("get cookies");
        OpenUser openUser = null;
        Cookie[] cookies = request.getCookies();


        if (cookies != null)
            for (Cookie cookie : cookies)
                if ("token".equals(cookie.getName())) {
                    String token = cookie.getValue();
                    System.out.println("find token");
                    openUser = openUserMapper.findToken(token);
                    if (openUser != null) {
                        request.getSession().setAttribute("user", openUser);
                    }
                    break;
                }

        if (openUser == null) {
            model.addAttribute("error", "未登录");
            return "publish";
        }

        long currentTime = System.currentTimeMillis();
        Date now = new Date(currentTime);

        Question question = new Question();
        question.setCreator_id(openUser.getId());
        question.setTitle(title);
        question.setTag(tag);
        question.setContent(content);
        question.setGmt_create(now);
        question.setGmt_modified(now);

        questionService.publishQues(question);


        return "redirect:/";

    }

}
