package com.buzzardsview.needalight.model.dto;

import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;

public class BlogPostDto {

    private String slug;
    private Blob content;
    private MultipartFile image;

    public BlogPostDto(String slug, Blob content, MultipartFile image) {
        this.slug = slug;
        this.content = content;
        this.image = image;
    }

    public BlogPostDto() {
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Blob getContent() {
        return content;
    }

    public void setContent(Blob content) {
        this.content = content;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
