package me.weekbelt.reservation.domain.fileInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.weekbelt.reservation.domain.BaseTimeEntity;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter @NoArgsConstructor
@Entity
public class FileInfo extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false, length = 4000)
    private String saveFileName;

    @Column(nullable = false)
    private String contentType;

    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean deleteFlag;
}
