package com.ecocert.core.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class CleanUpEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long socialId;
    @Enumerated(EnumType.STRING)
    private TrashQuantity trashQuantity;
    @Enumerated(EnumType.STRING)
    private TrashType trashType;
    private String info;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=true)
    private User user;
    @OneToMany(cascade=CascadeType.ALL)
    private List<EventImage> images;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CleanUpEvent() {
    }

    public List<EventImage> getImages() {
        return images;
    }

    public void setImages(List<EventImage> images) {
        this.images = images;
    }

    public TrashQuantity getTrashQuantity() {
        return trashQuantity;
    }

    public void setTrashQuantity(TrashQuantity trashQuantity) {
        this.trashQuantity = trashQuantity;
    }

    public TrashType getTrashType() {
        return trashType;
    }

    public void setTrashType(TrashType trashType) {
        this.trashType = trashType;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSocialId() {
        return socialId;
    }

    public void setSocialId(Long socialId) {
        this.socialId = socialId;
    }
}
