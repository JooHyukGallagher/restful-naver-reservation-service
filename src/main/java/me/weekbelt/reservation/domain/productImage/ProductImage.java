package me.weekbelt.reservation.domain.productImage;

import lombok.Getter;
import me.weekbelt.reservation.domain.ImageType;

import javax.persistence.*;

@Getter
@Entity
public class ProductImage {

    @Id @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ImageType type;
}
