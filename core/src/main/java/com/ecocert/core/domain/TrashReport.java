package com.ecocert.core.domain;

import com.ecocert.core.domain.enumeration.ReportStatus;
import com.ecocert.core.domain.enumeration.TrashQuantity;
import com.ecocert.core.domain.enumeration.TrashType;
import com.ecocert.core.web.dto.TrashReportDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

// TODO: create entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class TrashReport {


    //// - pictureHash
//private String uuid;
//// - latitude
//    private double latitude;
//// - longitude
//    private double longitude;
//// - photoTimestamp
//    private String photoTimeStamp;
//// - timestamp
//    private String timestamp;
//// - status(incomplete, complete)
//    private ReportStatus status;
//// - User
//    private EcoUser user;
//// - TrashQuantity
//    private TrashQuantity trashQuantity;
//// - TrashType
//    private TrashType trashType;
//// - comments
//    private String comments;
    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
    // - pictureHash
    // - latitude
    // - longitude
    // - photoTimestamp
    private ImageUploadResult imageUploadResult;
    // - timestamp
    private String timestamp;
    // - status(incomplete, complete)
    @Enumerated(EnumType.STRING)
    private ReportStatus status;
    // - User
    private EcoUser user;
    // - TrashQuantity
    @Enumerated(EnumType.STRING)
    private TrashQuantity trashQuantity;
    // - TrashType
    @Enumerated(EnumType.STRING)
    private TrashType trashType;
    // - comments
    private String comments;


    public TrashReport (TrashReportDto trashReport){
        this.imageUploadResult = trashReport.getImageUploadResult();
        this.timestamp = trashReport.getTimestamp();
        this.status = trashReport.getStatus();
        this.user = trashReport.getUser();
        this.trashQuantity = trashReport.getTrashQuantity();
        this.trashType = trashReport.getTrashType();
        this.comments = trashReport.getComments();
    }
}
