package org.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import org.jojoldu.book.springboot.domain.post.Post;

import java.time.LocalDateTime;

@Getter
public class PostListResponseDto {

    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostListResponseDto(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getUpdatedAt();
    }

}
