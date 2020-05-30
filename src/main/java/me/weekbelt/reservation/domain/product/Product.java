package me.weekbelt.reservation.domain.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.weekbelt.reservation.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter @NoArgsConstructor
@Entity
public class Product extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Lob
    private String content;

    private String event;
}
