package com.buzzardsview.needalight.controller;

import com.buzzardsview.needalight.controller.service.AmazonClient;
import com.buzzardsview.needalight.data.BlogRepository;
import com.buzzardsview.needalight.data.UserRepository;
import com.buzzardsview.needalight.model.Blog;
import com.buzzardsview.needalight.model.User;
import com.buzzardsview.needalight.model.dto.BlogForListDto;
import com.buzzardsview.needalight.model.dto.BlogGetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("rest/blog")
public class BlogController {


    @Autowired
    private AmazonClient amazonClient;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping(consumes = {"multipart/form-data"})
    public void newBlog(@RequestPart String title, @RequestPart String slug, @RequestPart String content, @RequestPart MultipartFile image, ServletRequest request) throws IOException {
        //TODO add user not found handling
        User user = userRepository.findById((String) request.getAttribute("userId")).orElseThrow();
        if (user.isAdmin()) {
            this.blogRepository.save(new Blog(
                    title,
                    slug,
                    content,
                    this.amazonClient.uploadFile(image),
                    user
            ));
        }
    }

    @GetMapping("{slug}")
    public BlogGetDto getBlog(@PathVariable String slug) {
        Blog blog = this.blogRepository.findBySlug(slug);
        return new BlogGetDto(
                blog.getTitle(),
                blog.getSlug(),
                blog.getContent(),
                blog.getImageUrl(),
                blog.getUser().getName(),
                blog.getTimestamp()
        );
    }

    @GetMapping
    public List<BlogForListDto> list() {
        List<Blog> blogs = this.blogRepository.findAll(Sort.by("timestamp").descending());
        return blogs.stream().map(Blog::getBlogForList).collect(Collectors.toList());
    }

}
