package com.haidang.blog.repository;

import com.haidang.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByTitleContaining(String keyword);
}
