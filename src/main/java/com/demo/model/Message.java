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
    private String subjectUser;
    @Column
    private String contentUser;
    @Column
    private String subjectMerchant;
    @Column
    private String contentMerchant;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne
    @JoinColumn(name = "merchantId")
    private Merchant merchant;

    public Message(String subjectUser, String contentUser, User user, Merchant merchant) {
        this.subjectUser = subjectUser;
        this.contentUser = contentUser;
        this.user = user;
        this.merchant = merchant;
    }
}
