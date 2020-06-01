package me.weekbelt.reservation.domain.promotion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion, Long>, PromotionRepositoryCustom {
}
