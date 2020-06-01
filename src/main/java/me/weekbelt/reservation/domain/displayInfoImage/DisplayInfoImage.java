package me.weekbelt.reservation.domain.displayInfoImage;

import lombok.Getter;
import me.weekbelt.reservation.domain.displayInfo.DisplayInfo;
import me.weekbelt.reservation.domain.fileInfo.FileInfo;

import javax.persistence.*;

@Getter
@Entity
public class DisplayInfoImage {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "display_info_id")
    private DisplayInfo displayInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
    private FileInfo fileInfo;
}
