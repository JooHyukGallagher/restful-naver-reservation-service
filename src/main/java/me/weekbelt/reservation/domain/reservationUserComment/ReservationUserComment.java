package me.weekbelt.reservation.domain.reservationUserComment;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.weekbelt.reservation.domain.BaseTimeEntity;
import me.weekbelt.reservation.domain.product.Product;

import javax.persistence.*;

@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ReservationUserComment extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private Double score;

    @Column(nullable = false)
    private String comment;
}
