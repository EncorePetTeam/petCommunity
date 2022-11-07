package com.encore.pet.community.repository;

import com.encore.pet.community.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //회원로그인시 사용
    User findById(String id);

    //아이디 중복확인시 사용
    boolean existsById(String id);
}
