package ru.tomko.mylittlebank.entity;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name ="photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "photo")
    @Lob
    private byte[] photo;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user")
    private User user;

    public Photo() {
    }

    public Photo(byte[] photo, User user) {
        this.photo = photo;
        this.user = user;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
