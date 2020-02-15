package twjug.lite.oauth;

import org.springframework.boot.json.JsonParser;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class OAuthController {

    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping({"/", "/index"})
    public String index(Model model) {
        // index 沒特別做什麼事，只是用來顯示一個 html 頁
        return "index";
    }

    @RequestMapping("/authorize")
    public ModelAndView authorize(Model model) throws UnsupportedEncodingException {
        // TODO 當 Resource Owner 按下 [Connect with XXXX]，需要組裝好適當的 Authorization Server Endpoint URL 並導向過去
        // 必要參數：
        // client_id
        // response_type=code
        // redirect_uri
        // 建議參數：
        // state
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("")
                .queryParam("client_id", "")
                .queryParam("response_type", "code")
                .queryParam("redirect_uri", "")
                .queryParam("scope", "user:email")
                .queryParam("state", UUID.randomUUID().toString());
        return new ModelAndView("redirect:" + builder.toUriString());
    }

    @RequestMapping("/callback")
    public ModelAndView callback(HttpServletRequest request) throws IOException, URISyntaxException {
        // 當 Resource Owner 完成 Authorization 後，視回應的情況處理結果
        String code = request.getParameter("code");
        String state = request.getParameter("state");

        // TODO 取得 code 與 state，進行 access_token 交換

        // post body
        Map<String, Object> body = new HashMap<>();
        body.put("code", code);
        body.put("state", state);
        body.put("client_id", "");
        body.put("client_secret", "");
        body.put("grant_type", "authorization_code");

        // 交換 access token 的 url
        String url = "";

        // TODO 運用 RestTemplate 執行 POST Request
        RequestEntity<Map<String, Object>> requestEntity = RequestEntity
                .post(new UriTemplate(url).expand())
                .body(body);
        ResponseEntity<String> response = restTemplate.exchange(requestEntity, String.class);

        // TODO 獲得 access_token 後，顯示 email
        // OAuth Request 範例：https://developer.github.com/v3/#authentication
        // User Email API：https://developer.github.com/v3/users/emails/


        return new ModelAndView("redirect:index");
    }
}
