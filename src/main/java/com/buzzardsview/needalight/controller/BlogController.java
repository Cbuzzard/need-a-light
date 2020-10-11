package com.buzzardsview.needalight.controller;

import com.buzzardsview.needalight.data.BlogRepository;
import com.buzzardsview.needalight.data.UserRepository;
import com.buzzardsview.needalight.model.User;
import com.buzzardsview.needalight.model.dto.BlogPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

@RestController
@RequestMapping("rest")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("blog")
    public void newBlog(@RequestBody BlogPostDto blogPostDto, ServletRequest request) {
        //TODO add user not found handling
        User user = userRepository.findById((String) request.getAttribute("userId")).orElseThrow();

    }

}
