package org.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import org.jojoldu.book.springboot.domain.post.Post;

@Getter
public class PostResponseDto {

    private final Long id;
    private final String title;
    private final String content;
    private final String author;

    public PostResponseDto(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }

}
