package com.buzzardsview.needalight.model.dto;

public class BlogForListDto {

    private String title;
    private String slug;
    private String imageUrl;
    private String author;
    private long timestamp;

    public BlogForListDto(String title, String slug, String imageUrl, String author, long timestamp) {
        this.title = title;
        this.slug = slug;
        this.imageUrl = imageUrl;
        this.author = author;
        this.timestamp = timestamp;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
