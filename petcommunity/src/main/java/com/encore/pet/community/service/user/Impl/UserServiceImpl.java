package com.encore.pet.community.service.user.Impl;

import com.encore.pet.community.common.UserMapper;
import com.encore.pet.community.controller.user.requests.UserDTO;
import com.encore.pet.community.domain.user.User;
import com.encore.pet.community.repository.UserRepository;
import com.encore.pet.community.service.user.UserService;
import com.encore.pet.community.utils.Encrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;
    public final EntityManager em;

    Encrypt encrypt = new Encrypt();

    public UserServiceImpl(UserRepository userRepository, EntityManager em) {
        this.userRepository = userRepository;
        this.em = em;


    }

    //회원가입 메서드
    @Override
    @Transactional
    public int join(UserDTO userDto) {

        // 난수생성 salt 변수에 초기화
        String salt = encrypt.getSalt();
        //생성된 난수 변수 salt , User가 입력한 password를 파라미터로 입력
        String afterEncryptPassword = encrypt.getEncrypt(userDto.getPassword(), salt);

        //회원 가입시 아이디 중복체크
        Optional<User> id = userRepository.findById(userDto.getId());
        //user가입력한 아이디가 존재한다면 예외던짐
        id.ifPresent(m ->{
            throw new IllegalArgumentException("이미 존재하는 회원");
        });
        // 아니면 저장
        User result = userRepository.save(UserMapper.afterEncryptEntity(userDto, afterEncryptPassword, salt));

        if (result.equals(null)) { //회원가입 실패
            System.out.println("실패");
            return 0;
        } else { // 회원가입 성공
            System.out.println("성공");
            return 1;
        }
    }

    //로그인 메서드
    @Override
    @Transactional
    public boolean login(UserDTO userDto) {
        Optional<User> result = userRepository.findById(userDto.getId());
        if (result.isPresent()){
            return false;
        }else {
            return result.get().getPassword().equals(encrypt.getEncrypt(userDto.getPassword(), result.get().getSalt()));
        }
    }

    //id 중복확인 메서드
    @Override
    @Transactional
    public boolean idCheck(UserDTO userDto) {
        return userRepository.existsById(userDto.getId());
    }
}
