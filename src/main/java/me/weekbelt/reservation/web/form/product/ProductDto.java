package me.weekbelt.reservation.web.form.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder @NoArgsConstructor @AllArgsConstructor
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
}
