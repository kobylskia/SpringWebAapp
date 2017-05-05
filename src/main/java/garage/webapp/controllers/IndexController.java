package garage.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Aleksander on 05.05.2017.
 */


@Controller
public class IndexController {

    @RequestMapping("/")
    String index(){
        return "index";
    }

}
