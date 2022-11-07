package com.encore.pet.community.user;

import com.encore.pet.community.domain.user.User;
import com.encore.pet.community.repository.UserRepository;
import com.encore.pet.community.service.user.UserService;
import com.encore.pet.community.utils.Encrypt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.security.auth.kerberos.EncryptionKey;

@SpringBootTest
public class UserTest {

//    private final UserRepository userRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;


//    @Test
//    public void joinTest() {
//
//        Encrypt salt = new Encrypt();
//        for (int i = 0; i < 10; i++) {
//            // a = 사용자가 입력한 pw
//            String a = "";
//
//            // 난수로된 암호
//            String pw = salt.getSalt();
//
//            // 사용자 입력 pw + 난수 암호
//            String pwSalt = salt.getEncrypt(a, pw);
//
//            User user = User.builder().id("id" + i).password(salt.getSalt()).salt(pwSalt).state(i).build();
//
//            userRepository.save(user);
//        }
//    }

    @Test
    public void loginTest() {


    }

}
