package me.weekbelt.reservation.domain.promotion;

import lombok.Getter;
import me.weekbelt.reservation.domain.product.Product;

import javax.persistence.*;

@Getter
@Entity
public class Promotion {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
