package com.example.multimodule.application.api;

import com.example.multimodule.library.service.MyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestApi {

    private final MyService myService;

    @GetMapping("/")
    public String home() {
        return myService.message();
    }

    @GetMapping("/custom")
    public String getCustom() {
        return myService.getCustom();
    }

    @PutMapping("/custom")
    public void setCustom(@RequestBody String message) {
        myService.saveCustom(message);
    }
}
