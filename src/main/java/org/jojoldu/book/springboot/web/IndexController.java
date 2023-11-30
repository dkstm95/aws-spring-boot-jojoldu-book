package org.jojoldu.book.springboot.web;

import lombok.RequiredArgsConstructor;
import org.jojoldu.book.springboot.service.post.PostService;
import org.jojoldu.book.springboot.web.dto.PostResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostService postService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable("id") Long id, Model model) {
        PostResponseDto dto = postService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }

}
