package com.example.models.util;

import com.example.models.User;

public abstract class MessageHelper {
    public static String getAuthorName (User author) {
        return author != null ? author.getUsername() : "<none>";
    }
}
