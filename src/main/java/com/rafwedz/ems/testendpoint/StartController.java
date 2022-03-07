package com.rafwedz.ems.testendpoint;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class StartController {

    @GetMapping("/start")
    public String redirectToEmployees(){
        StringBuilder sb=new StringBuilder();
        sb.append("ENTRY POINT OF THE APPLICATION");
        return sb.toString();
    }
}
