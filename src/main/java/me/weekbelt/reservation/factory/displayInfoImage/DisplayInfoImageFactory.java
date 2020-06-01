package me.weekbelt.reservation.factory.displayInfoImage;

import me.weekbelt.reservation.domain.displayInfoImage.DisplayInfoImage;
import me.weekbelt.reservation.web.form.displayInfoImage.DisplayInfoImageDto;

public class DisplayInfoImageFactory {

    public static DisplayInfoImageDto displayInfoImageToDisplayInfoImageDto(DisplayInfoImage displayInfoImage){
        return DisplayInfoImageDto.builder()
                .id(displayInfoImage.getId())
                .displayInfoId(displayInfoImage.getDisplayInfo().getId())
                .fileId(displayInfoImage.getFileInfo().getId())
                .fileName(displayInfoImage.getFileInfo().getFileName())
                .saveFileName(displayInfoImage.getFileInfo().getSaveFileName())
                .contentType(displayInfoImage.getFileInfo().getContentType())
                .deleteFlag(displayInfoImage.getFileInfo().isDeleteFlag())
                .createDate(displayInfoImage.getFileInfo().getCreateDate())
                .modifyDate(displayInfoImage.getFileInfo().getModifyDate())
                .build();
    }
}
