package com.encore.pet.community.domain.pet;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@ToString
@Setter(AccessLevel.PROTECTED)
@Getter
@Table(name = "pet_category")
public class PetCategory {

    @Id
    private Integer pet_ca
    @Column(nullable = false)
    private int largeCategory;

    @Column(nullable = false)
    private int smallCategory;

}
