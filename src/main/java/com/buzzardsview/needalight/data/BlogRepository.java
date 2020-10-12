package com.buzzardsview.needalight.data;

import com.buzzardsview.needalight.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

    Blog findBySlug(String slug);

}
