package com.encore.pet.community.domain.user;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    private String id;

    @Column(name = "password")
    private String password;

    @Column(name = "state")
    private int state;

    @Column(name = "salt")
    private String salt;

    //    //빌더
//    @Builder
//    public User(User user,String id, String password, int state, String salt) {
//        this.id = id;
//        this.password = password;
//        this.state = state;
//        this.salt = salt;
//    }



}
