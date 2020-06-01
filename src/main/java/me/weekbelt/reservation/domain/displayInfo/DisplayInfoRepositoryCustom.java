package me.weekbelt.reservation.domain.displayInfo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DisplayInfoRepositoryCustom {
    Page<DisplayInfo> findDisplayInfoPageByCategoryId(Long categoryId, Pageable pageable);
}
