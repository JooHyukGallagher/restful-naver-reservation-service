package me.weekbelt.reservation.domain.productPrice;

import lombok.Getter;
import me.weekbelt.reservation.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@Entity
public class ProductPrice extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 25)
    private String priceTypeName;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private Double discountRate;
}
