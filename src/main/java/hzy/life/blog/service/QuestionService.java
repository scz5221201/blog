package hzy.life.blog.service;


import hzy.life.blog.dto.QuestionList;
import hzy.life.blog.mapper.QuestionMapper;
import hzy.life.blog.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired(required = false)
    QuestionMapper questionMapper;



    public void publishQues(Question question) {

        questionMapper.publisQues(question);
    }

    public List<QuestionList> getQuesList(){
        return questionMapper.getQuesList();
    }


}
