package hzy.life.blog.service;

import hzy.life.blog.dto.GithubUser;
import hzy.life.blog.mapper.OpenUserMapper;
import hzy.life.blog.model.OpenUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OpenUserService {

    @Autowired(required = false)
    private OpenUserMapper openUserMapper;

    public String insertAndGetToken(GithubUser githubUser) {
        OpenUser openUser = new OpenUser();
        openUser.setAvatar_url(githubUser.getAvatar_url());
        openUser.setToken(UUID.randomUUID().toString());
        openUser.setAccountId(String.valueOf(githubUser.getId()));
        openUser.setName(githubUser.getName());
        openUser.setGmt_create(githubUser.getCreated_at());
        openUser.setGmt_modified(githubUser.getUpdated_at());
        openUserMapper.insert(openUser);
        return openUser.getToken();
    }

    public OpenUser findToken(String token){
        return openUserMapper.findToken(token);
    }


}
