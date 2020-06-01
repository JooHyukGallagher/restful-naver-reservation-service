package me.weekbelt.reservation.domain.displayInfoImage;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static me.weekbelt.reservation.domain.displayInfo.QDisplayInfo.displayInfo;
import static me.weekbelt.reservation.domain.displayInfoImage.QDisplayInfoImage.displayInfoImage;
import static me.weekbelt.reservation.domain.fileInfo.QFileInfo.fileInfo;

@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DisplayInfoImageRepositoryCustomImpl implements DisplayInfoImageRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<DisplayInfoImage> findDisplayInfoImageByDisplayInfoId(Long displayInfoId) {
        return queryFactory
                .selectFrom(displayInfoImage)
                .join(displayInfoImage.displayInfo, displayInfo).fetchJoin()
                .join(displayInfoImage.fileInfo, fileInfo).fetchJoin()
                .where(displayInfoImage.displayInfo.id.eq(displayInfoId))
                .fetch();
    }
}
