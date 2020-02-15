package twjug.lite.oauth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
public class OAuthController {


    @RequestMapping({"/", "/index"})
    public String index(Model model) {
        // index 沒特別做什麼事，只是用來顯示一個 html 頁
        return "index";
    }

    @RequestMapping("/authorize")
    public ModelAndView authorize(Model model) throws UnsupportedEncodingException {
        // TODO 當 Resource Owner 按下 [Connect with XXXX]
        // TODO 需要組裝好適當的 Authorization Server Endpoint URL 並導向過去
        return new ModelAndView("redirect:index");
    }

    @RequestMapping("/callback")
    public ModelAndView callback(HttpServletRequest request) throws IOException {
        // TODO 當 Resource Owner 完成 Authorization 後，視回應的情況處理結果
        // TODO 簡單實作成，顯示 email 或 user 頭像即可。
        return new ModelAndView("redirect:index");
    }
}
