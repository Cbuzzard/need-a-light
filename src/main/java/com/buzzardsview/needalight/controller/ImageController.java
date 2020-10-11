package com.buzzardsview.needalight.controller;

import com.buzzardsview.needalight.controller.service.AmazonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;

@RestController
public class ImageController {

    private AmazonClient amazonClient;

    @Autowired
    ImageController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @PostMapping(value = "rest/upload", consumes = "multipart/form-data")
    public void uploadImgae(@RequestPart(name = "file", required = false) MultipartFile image) throws IOException {
//        System.out.println(Arrays.toString(image.getBytes()));
//        System.out.println(this.amazonClient.uploadFile(image));

    }

}
