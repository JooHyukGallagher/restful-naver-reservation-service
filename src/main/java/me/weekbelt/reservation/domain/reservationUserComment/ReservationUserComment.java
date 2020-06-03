package me.weekbelt.reservation.domain.reservationUserComment;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.weekbelt.reservation.domain.BaseTimeEntity;
import me.weekbelt.reservation.domain.product.Product;
import me.weekbelt.reservation.domain.reservationInfo.ReservationInfo;
import me.weekbelt.reservation.domain.reservationUserCommentImage.ReservationUserCommentImage;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ReservationUserComment extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_info_id")
    private ReservationInfo reservationInfo;

    @Column(nullable = false)
    private Double score;

    @Column(nullable = false)
    private String comment;

    @OneToMany(mappedBy = "reservationUserComment")
    private List<ReservationUserCommentImage> reservationUserCommentImages = new ArrayList<>();
}
