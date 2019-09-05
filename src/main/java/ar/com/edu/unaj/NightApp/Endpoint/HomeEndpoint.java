package ar.com.edu.unaj.NightApp.Endpoint;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/app")
@PreAuthorize("permitAll()")
public class HomeEndpoint {

    @GetMapping
    @ResponseBody
    public String home(){
        return "Hola";
    }

}
