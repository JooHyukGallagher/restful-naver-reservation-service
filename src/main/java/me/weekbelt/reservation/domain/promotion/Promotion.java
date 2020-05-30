package me.weekbelt.reservation.domain.promotion;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
public class Promotion {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
