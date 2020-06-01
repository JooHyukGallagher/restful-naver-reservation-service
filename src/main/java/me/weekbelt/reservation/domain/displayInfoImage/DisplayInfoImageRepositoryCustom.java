package me.weekbelt.reservation.domain.displayInfoImage;

import java.util.List;

public interface DisplayInfoImageRepositoryCustom {
    List<DisplayInfoImage> findDisplayInfoImageByDisplayInfoId(Long displayInfoId);
}
