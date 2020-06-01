package me.weekbelt.reservation.web.form.productImage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.weekbelt.reservation.domain.ImageType;

import java.time.LocalDateTime;

@Builder @NoArgsConstructor @AllArgsConstructor
@Getter
public class ProductImageDto {

    private Long productId;

    private Long productImageId;

    private ImageType type;

    private Long fileInfoId;

    private String fileName;

    private String saveFileName;

    private String contentType;

    private boolean deleteFlag;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;
}
