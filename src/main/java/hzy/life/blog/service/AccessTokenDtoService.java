package hzy.life.blog.service;


import hzy.life.blog.dto.AccessTokenDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AccessTokenDtoService {

    @Value("${github.client_id}")
    private String githubClientId;
    @Value("${github.client_secret}")
    private String githubClientSecret;
    @Value("${github.redirect_uri}")
    private String githubRedirect_uri;

    public AccessTokenDto getGitHubToken(String code,String state){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id(githubClientId);
        accessTokenDto.setClient_secret(githubClientSecret);
        accessTokenDto.setCode(code);
        accessTokenDto.setState(state);
        accessTokenDto.setRedirect_uri(githubRedirect_uri);
        return accessTokenDto;
    }
}
