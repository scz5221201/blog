package hzy.life.blog.mapper;

import hzy.life.blog.dto.QuestionList;
import hzy.life.blog.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("insert into question(title,content,tag,gmt_create,gmt_modified,creator_id) values(#{title},#{content},#{tag},#{gmt_create},#{gmt_modified},#{creator_id})")
    void publisQues(Question question);

    @Select("select u.avatar_url,q.title,q.comment_count,q.like_count,q.view_count,q.gmt_create from open_user u, question q  where q.creator_id=u.id")
    List<QuestionList> getQuesList();

}
