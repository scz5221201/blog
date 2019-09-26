package hzy.life.blog.mapper;

import hzy.life.blog.model.OpenUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OpenUserMapper {

    @Insert("insert into open_user(avatar_url,token,accountId,name,gmt_create,gmt_modified) values(#{avatar_url},#{token}," +
            "#{accountId},#{name},#{gmt_create},#{gmt_modified})")
    int insert(OpenUser openUser);

    @Select("select * from open_user where token=#{token}")
    OpenUser findToken(@Param("token")String token);

}
