package com.example.models;

import com.example.models.util.MessageHelper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
@Getter
@Setter
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="user_id")
    private User author;

    private String filename;
    @NotBlank(message = "Please fill the message")
    @Length (max = 2048, message = "Message is too long (more than 2048 symbols)")
    private String text;

    @ManyToMany
    @JoinTable (
            name = "messages_likes",
            joinColumns = { @JoinColumn(name = "message_id")},
            inverseJoinColumns = { @JoinColumn(name = "user_id")}
    )
    private Set<User> likes = new HashSet<>();

    @Length (max = 255, message = "Tag is too long (more than 255 symbols)")
    private String tag;

    public String getAuthorName(){
        return MessageHelper.getAuthorName(author);
    }

    public Message(String text, String tag, User user) {
        this.author = user;
        this.text = text;
        this.tag = tag;
    }
}