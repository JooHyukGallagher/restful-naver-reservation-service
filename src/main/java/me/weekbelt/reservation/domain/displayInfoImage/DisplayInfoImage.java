package me.weekbelt.reservation.domain.displayInfoImage;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
public class DisplayInfoImage {

    @Id @GeneratedValue
    private Long id;

}
