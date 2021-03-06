package com.buzzardsview.needalight.model.dto;

public class BlogGetDto {

    private String title;
    private String slug;
    private String content;
    private String imageUrl;
    private String Author;
    private long timestamp;

    public BlogGetDto(String title, String slug, String content, String imageUrl, String author, long timestamp) {
        this.title = title;
        this.slug = slug;
        this.content = content;
        this.imageUrl = imageUrl;
        Author = author;
        this.timestamp = timestamp;
    }

    public BlogGetDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
