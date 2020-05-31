package me.weekbelt.reservation.domain.displayInfo;

import lombok.Getter;
import me.weekbelt.reservation.domain.BaseTimeEntity;
import me.weekbelt.reservation.domain.product.Product;

import javax.persistence.*;

@Getter
@Entity
public class DisplayInfo extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String openingHours;

    @Column(nullable = false)
    private String placeName;

    private String placeLot;

    private String placeStreet;

    private String tel;

    private String homepage;

    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
