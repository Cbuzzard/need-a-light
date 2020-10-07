package com.buzzardsview.needalight.controller;

import com.buzzardsview.needalight.model.dto.EmailDto;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.tika.io.IOUtils;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.InternetAddress;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@RestController
public class EmailController {

    private static final String CAPTCHA_SECRET = System.getenv("captcha_secret");

    @Autowired
    EmailService emailService;

    @PostMapping("email")
    public boolean sendEmail(@RequestBody EmailDto emailDto) throws IOException, JSONException {

        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("https://www.google.com/recaptcha/api/siteverify");

        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("secret", CAPTCHA_SECRET));
        params.add(new BasicNameValuePair("response", emailDto.getRecaptcha()));
        httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        HttpResponse response = httpclient.execute(httppost);

        JSONObject res = new JSONObject(IOUtils.toString(response.getEntity().getContent()));

        if(res.getBoolean("success")) {
            final Email email = DefaultEmail.builder()
                    .from(new InternetAddress("needalightllc@gmail.com", "Need A Light"))
                    .to(newArrayList(new InternetAddress("needalightllc@gmail.com", "Need A Light")))
                    .subject("Customer!")
                    .body("Customer Email: " + emailDto.getEmail() + "\n" + emailDto.getBody())
                    .encoding("UTF-8").build();

            emailService.send(email);

            return res.getBoolean("success");
        }
        return res.getBoolean("success");
    }

}
