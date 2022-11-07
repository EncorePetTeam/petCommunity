package com.encore.pet.community.domain.user;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class User {

    @Id
    private String Id;

    public User(String id) {
        Id = id;
    }
}
