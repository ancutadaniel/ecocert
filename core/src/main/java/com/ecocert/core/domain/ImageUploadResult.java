package com.ecocert.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImageUploadResult {
    private double longitude;
    private double latitude;
    private String imageUUID;
    private String photoTimeStamp;

    public ImageUploadResult(String uuid) {
        this.imageUUID = uuid;
    }
}
