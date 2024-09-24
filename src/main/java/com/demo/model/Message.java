package com.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String subject;
    @Column
    private String content;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne
    @JoinColumn(name = "merchantId")
    private Merchant merchant;

    public Message(String subject, String content, User user, Merchant merchant) {
        this.subject = subject;
        this.content = content;
        this.user = user;
        this.merchant = merchant;
    }
}
