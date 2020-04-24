package sda.group1.miniprojectgroup1.greeting;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/")
    public String hello(){
        return "hello world";
    }
    @RequestMapping("/helloPerson/{name}")
    public String helloPerson(@PathVariable String name){
        return "hello " +name;
    }
    @RequestMapping("/helloPersonAge")
    public String helloPersonAge(@RequestParam String name, @RequestParam Integer age){
        return "hello " +name+ " you are "+age+" year old";
    }
}
