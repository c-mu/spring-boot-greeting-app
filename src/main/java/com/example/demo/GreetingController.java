// ① 司令塔（しれいとう）のルールブック
package com.example.demo; 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    // ② 最初に来た人へ、「index.html」の画面を見せてね！という命令
    @GetMapping("/")
    public String index() {
        return "index"; 
    }

    // ③ 名前が送られてきたとき（/greet）に動く、一番大事な命令！
    @PostMapping("/greet")
    public String greet(@RequestParam("userName") String userName, Model model) {
        
        // ④ 送られてきた名前（userName）を使って、メッセージを作る！
        String message = "こんにちは、" + userName + "さん！ よくできましたね！";
        
        // ⑤ 作ったメッセージを次の画面に「greetingMessage」という名前で渡す準備
        model.addAttribute("greetingMessage", message);
        
        // ⑥ 次は「greeting.html」の画面を見せてね！という命令
        return "greeting";
    }
}
