package hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Scope("session")
public class AppController {

    @Autowired
    AppService service;

    @GetMapping("/")
    public String getAdd(){

        return service.add();
    }
}
