package com.haidang.blog.controller;


import com.haidang.blog.model.Blog;
import com.haidang.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public List<Blog> findAll() {
        return blogService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> findById(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(blog);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> search(
            @RequestParam String keyword) {

        return ResponseEntity.ok(
                blogService.search(keyword)
        );
    }

    @GetMapping("/load")
    public ResponseEntity<Page<Blog>> loadMore(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 2);
        return ResponseEntity.ok(blogService.findAll(pageable));
    }
}
