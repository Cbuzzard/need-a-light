package com.buzzardsview.needalight.model.dto;

public class EmailDto {

    private String email;
    private String body;
    private String recaptcha;

    public EmailDto(String email, String body, String recaptcha) {
        this.email = email;
        this.body = body;
        this.recaptcha = recaptcha;
    }

    public EmailDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getRecaptcha() {
        return recaptcha;
    }

    public void setRecaptcha(String recaptcha) {
        this.recaptcha = recaptcha;
    }
}
