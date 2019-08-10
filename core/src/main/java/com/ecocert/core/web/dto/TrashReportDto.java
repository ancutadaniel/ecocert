package com.ecocert.core.web.dto;


import com.ecocert.core.domain.TrashReport;
import com.ecocert.core.domain.enumeration.TrashSize;
import com.ecocert.core.domain.enumeration.TrashType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrashReportDto {
	private String image;
	private TrashSize trashSize;
	private TrashType trashType;
	private String info;

	public TrashReportDto(TrashReport t) {
		this.image = t.getImage().getUuid();
		this.trashSize = t.getTrashSize();
		this.trashType = t.getTrashType();
		this.info = t.getComments();
	}
}
