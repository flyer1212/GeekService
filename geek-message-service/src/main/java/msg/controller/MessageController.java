package msg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/msg")
public class MessageController {

    @GetMapping("/health")
    public String getHello() {
        return "ok! health";
    }
}
