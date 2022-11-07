package com.encore.pet.community.controller.user.api;

import com.encore.pet.community.controller.user.requests.UserDTO;
import com.encore.pet.community.domain.user.User;
import com.encore.pet.community.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //회원가입
    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String join(@Valid UserDTO userDto, RedirectAttributes RA) {
        int result = userService.join(userDto);
        if(result == 1) { //성공
            return RA.addFlashAttribute("msg","환영합니다.").toString();
        } else { //실패
            return RA.addFlashAttribute("msg","가입에 실패했습니다. 관리자에게 문의하세요").toString();
        }
    }

    //로그인
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    //Todo:"추후에 사용자 입력값으로 바꿔야함 ModelAttribute 이런걸로"
    public String login(@Valid UserDTO userDto, RedirectAttributes RA, HttpSession session) {

        boolean u = userService.login(userDto);

        if(u) { //성공
            session.setAttribute("userId",userDto.getId());
            return RA.addFlashAttribute("msg","로그인 성공").toString();
        } else { //실패
            return RA.addFlashAttribute("msg","아이디 or 비번 확인해주세요.").toString();
        }
    }

    //로그아웃
    @RequestMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes RA) {
        session.invalidate();
        return RA.addFlashAttribute("msg", "로그아웃 되었습니다").toString(); //로그아웃시 return
    }


    //아이디 중복체크
    // Todo:"나중에 userDto를 @PathVariable로 변환해야함 사용자가 입력한 값이 DB의 id에 존재하는지 확인해야함"
    public String idCheck(UserDTO userDto, RedirectAttributes RA){
        //ResponseEntity<Boolean> 타입으로 사용가능
        //return ResponseEntity.ok(userService.idCheck(userDto));

        Boolean result = userService.idCheck(userDto);
        if (result == true){
            return RA.addFlashAttribute("msg", "이미 존재하는 아이디입니다.").toString();
        } else {
            return RA.addFlashAttribute("msg", "사용가능한 아이디입니다.").toString();
        }
    }

}
