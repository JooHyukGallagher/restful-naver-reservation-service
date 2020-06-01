package me.weekbelt.reservation.domain.productImage;

import lombok.Getter;
import me.weekbelt.reservation.domain.ImageType;
import me.weekbelt.reservation.domain.fileInfo.FileInfo;
import me.weekbelt.reservation.domain.product.Product;

import javax.persistence.*;

@Getter
@Entity
public class ProductImage {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ImageType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
    private FileInfo fileInfo;
}
