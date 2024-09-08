package org.easybuy.entity;

import lombok.Data;

import java.util.Date;



@Data
public class Guestbook {
    int G_ID;
    String username;
    String content;
    Date createdAt;
}
