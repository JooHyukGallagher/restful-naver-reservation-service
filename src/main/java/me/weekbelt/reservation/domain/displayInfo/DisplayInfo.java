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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(length = 400)
    private String openingHours;

    @Column(nullable = false, length = 50)
    private String placeName;

    @Column(length = 100)
    private String placeLot;

    @Column(length = 100)
    private String placeStreet;

    @Column(length = 20)
    private String tel;

    private String homepage;

    private String email;

}
