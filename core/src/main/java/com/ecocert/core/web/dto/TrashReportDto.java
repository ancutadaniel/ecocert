package com.ecocert.core.web.dto;


import com.ecocert.core.domain.enumeration.TrashSize;
import com.ecocert.core.domain.enumeration.TrashType;
import lombok.Data;

@Data
public class TrashReportDto {
	private String image;
	private TrashSize trashSize;
	private TrashType trashType;
	private String info;
}
