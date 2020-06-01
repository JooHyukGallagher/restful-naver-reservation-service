package me.weekbelt.reservation.service;

import lombok.RequiredArgsConstructor;
import me.weekbelt.reservation.domain.displayInfoImage.DisplayInfoImage;
import me.weekbelt.reservation.domain.displayInfoImage.DisplayInfoImageRepository;
import me.weekbelt.reservation.factory.displayInfoImage.DisplayInfoImageFactory;
import me.weekbelt.reservation.web.form.displayInfoImage.DisplayInfoImageDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DisplayInfoImageService {

    private final DisplayInfoImageRepository displayInfoImageRepository;

    public List<DisplayInfoImageDto> findDisplayInfoImageDtoByDisplayInfoId(Long displayInfoId) {
        List<DisplayInfoImage> displayInfoImages = displayInfoImageRepository
                .findDisplayInfoImageByDisplayInfoId(displayInfoId);

        return displayInfoImages.stream()
                .map(DisplayInfoImageFactory::displayInfoImageToDisplayInfoImageDto)
                .collect(Collectors.toList());
    }
}
