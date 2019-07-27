package com.ecocert.core.web.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class ImageUploadDto {
    private double longitude;
    private double latitude;
    private String imageUUID;

    public ImageUploadDto(String uuid) {
        this.imageUUID = uuid;
    }
}
