package me.weekbelt.reservation.domain.productImage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long>, ProductImageRepositoryCustom {
}
