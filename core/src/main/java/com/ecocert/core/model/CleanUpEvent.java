package com.ecocert.core.model;

import org.hibernate.annotations.GeneratorType;

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
    private boolean anonymous;
    @OneToMany(cascade=CascadeType.ALL)
    private List<EventImage> images;

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

    public boolean isAnonymous() {
        return anonymous;
    }

    public void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
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
