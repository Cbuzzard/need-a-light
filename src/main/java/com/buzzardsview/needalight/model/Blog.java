package com.buzzardsview.needalight.model;

import com.buzzardsview.needalight.model.dto.BlogForListDto;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Blog {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String slug;
    @Lob
    @Size(max = 20000)
    private String content;
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "google_id")
    private User user;
    private long timestamp;

    public Blog(String title, String slug, String content, String imageUrl, User user) {
        this.title = title;
        this.slug = slug;
        this.content = content;
        this.imageUrl = imageUrl;
        this.user = user;
        this.timestamp = System.currentTimeMillis();
    }

    public Blog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BlogForListDto getBlogForList() {
        return new BlogForListDto(
                this.getTitle(),
                this.getSlug(),
                this.getImageUrl(),
                this.getUser().getName(),
                this.getTimestamp()
        );
    }
}
