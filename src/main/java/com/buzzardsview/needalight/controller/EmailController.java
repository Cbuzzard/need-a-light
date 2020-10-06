package com.buzzardsview.needalight.controller;

import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.InternetAddress;
import java.io.UnsupportedEncodingException;

import static com.google.common.collect.Lists.newArrayList;

@RestController
@RequestMapping("rest")
public class EmailController {

    @Autowired
    EmailService emailService;

    @GetMapping("email")
    public void sendEmail(@RequestBody String body) throws UnsupportedEncodingException {
        final Email email = DefaultEmail.builder()
                .from(new InternetAddress("needalightllc@gmail.com", "Need A Light"))
                .to(newArrayList(new InternetAddress("needalightllc@gmail.com", "Need A Light")))
                .subject("Customer!")
                .body(body)
                .encoding("UTF-8").build();

        emailService.send(email);
    }

}
