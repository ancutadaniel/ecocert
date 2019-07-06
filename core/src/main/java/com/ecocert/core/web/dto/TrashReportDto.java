package com.ecocert.core.web.dto;


import com.ecocert.core.domain.EcoUser;
import com.ecocert.core.domain.ImageUploadResult;
import com.ecocert.core.domain.enumeration.ReportStatus;
import com.ecocert.core.domain.enumeration.TrashQuantity;
import com.ecocert.core.domain.enumeration.TrashType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// TODO: create dto
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrashReportDto {
    // - pictureHash
    // - latitude
    // - longitude
    // - photoTimestamp
    private ImageUploadResult imageUploadResult;
    // - timestamp
    private String timestamp;
    // - status(incomplete, complete)
    private ReportStatus status;
    // - User
    private EcoUser user;
    // - TrashQuantity
    private TrashQuantity trashQuantity;
    // - TrashType
    private TrashType trashType;
    // - comments
    private String comments;

    // - anonymous
    private boolean anonymous;

    public boolean isAnonymous() {
        if (this.anonymous) {
            this.setUser(null);
            return true;
        }
        return false;
    }
}
