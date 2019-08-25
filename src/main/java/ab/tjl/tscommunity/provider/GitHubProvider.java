package ab.tjl.tscommunity.provider;

import ab.tjl.tscommunity.dto.AccessTokenDTO;
import ab.tjl.tscommunity.dto.GithubUser;
import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author:tangjilin
 * @Description:GitHub的OkHTTP请求方法书写
 * @Date:Created in 16:09 2019/8/24
 * @Modified By:
 */
@Component
public class GitHubProvider {

    public String getAccessToken(AccessTokenDTO accessTokenDTO) throws IOException {
         MediaType mediaType = MediaType.get("application/json; charset=utf-8");
         OkHttpClient client = new OkHttpClient();

            RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                try {
                    String string=response.body().string();
                    String token = string.split("&")[0].split("=")[1];
                    return token;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        return null;
        }

        public GithubUser getUser(String accessToken){
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.github.com/user?access_token="+accessToken)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                String string = response.body().string();
                GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
                return githubUser;
            } catch (IOException e) {
            }
            return null;
        }
}
