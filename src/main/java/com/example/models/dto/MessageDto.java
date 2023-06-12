package com.example.models.dto;

import com.example.models.Message;
import com.example.models.User;
import com.example.util.MessageHelper;
import lombok.Getter;

@Getter
public class MessageDto {
    private Long id;
    private String text;
    private String tag;
    private User author;
    private String filename;
    private Long likesAmount;
    private Boolean isLikedByMyself;

    public MessageDto(Message message, Long likesAmount, Boolean isLikedByMyself) {
        this.id = message.getId();
        this.text = message.getText();
        this.tag = message.getTag();
        this.author = message.getAuthor();
        this.filename = message.getFilename();
        this.likesAmount = likesAmount;
        this.isLikedByMyself = isLikedByMyself;
    }

    public String getAuthorName(){
        return MessageHelper.getAuthorName(author);
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "id=" + id +
                ", author=" + author +
                ", likes_count=" + likesAmount +
                ", isLikedByMyself=" + isLikedByMyself +
                '}';
    }
}
