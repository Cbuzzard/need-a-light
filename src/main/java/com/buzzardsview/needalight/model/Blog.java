package com.buzzardsview.needalight.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.sql.Blob;

@Entity
public class Blog {

    @Id
    private String slug;
    @Lob
    private Blob content;
    private String imageUrl;
    private User user;
    private long timestamp;

    public Blog(String slug, Blob content, String imageUrl, User user) {
        this.slug = slug;
        this.content = content;
        this.imageUrl = imageUrl;
        this.user = user;
        this.timestamp = System.currentTimeMillis();
    }

    public Blog() {
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
}
