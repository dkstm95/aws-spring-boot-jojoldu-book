package org.jojoldu.book.springboot.web;

import lombok.RequiredArgsConstructor;
import org.jojoldu.book.springboot.service.post.PostService;
import org.jojoldu.book.springboot.web.dto.PostResponseDto;
import org.jojoldu.book.springboot.web.dto.PostSaveRequestDto;
import org.jojoldu.book.springboot.web.dto.PostUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostSaveRequestDto requestDto) {
        return postService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable("id") Long id, @RequestBody PostUpdateRequestDto requestDto) {
        return postService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostResponseDto findById(@PathVariable("id") Long id) {
        return postService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable("id") Long id) {
        postService.delete(id);
        return id;
    }

}
