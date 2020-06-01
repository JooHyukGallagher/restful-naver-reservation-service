package me.weekbelt.reservation.web.form.product;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ProductDto {
    private Long id;
    private Long categoryId;
    private Long displayInfoId;
    private String name;
    private String description;
    private String content;
    private String event;
    private String openingHours;
    private String placeName;
    private String placeLot;
    private String placeStreet;
    private String tel;
    private String homepage;
    private String email;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private Long fileId;

    public void addFileId(Long fileId) {
        this.fileId = fileId;
    }
}
