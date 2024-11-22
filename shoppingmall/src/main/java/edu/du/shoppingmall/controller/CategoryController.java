package edu.du.shoppingmall.controller;

import edu.du.shoppingmall.MemberRepository;
import edu.du.shoppingmall.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class CategoryController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/")
    public String mainPage(HttpSession session, Model model) {
        // 세션에서 이메일 값 가져오기
        String userEmail = (String) session.getAttribute("userEmail");
        model.addAttribute("userEmail", userEmail); // 이메일을 모델에 추가
        return "main";
    }

    // 카테고리 페이지를 처리
    @GetMapping("/main")
    public String showCategoriesPage(Model model) {
        model.addAttribute("main");
        return "main";
    }

    @GetMapping("/cart")
    public String showCartPage(Model model) {
        model.addAttribute("cart");
        return "cart";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("login");
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(String email, String password, HttpSession session, RedirectAttributes redirectAttributes) {
        Optional<Member> member = memberRepository.findByEmail(email);

        // 사용자가 존재하고 비밀번호가 일치하는지 확인
        if (member != null && member.get().getPassword().equals(password)) {
            // 로그인 성공 시 세션에 이메일 저장
            session.setAttribute("userEmail", email);
            redirectAttributes.addFlashAttribute("userEmail", email);
            return "redirect:/main";  // 메인 화면으로 리디렉션
        } else {
            // 로그인 실패 시 로그인 페이지로 리다이렉트
            return "redirect:/login";  // 로그인 페이지로 리디렉션
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userEmail"); // 세션에서 이메일 삭제
        return "redirect:/";  // 메인 페이지로 리다이렉트
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("register");
        return "register";
    }

    @GetMapping("/pay")
    public String pay(Model model) {
        model.addAttribute("pay");
        return "pay";
    }

    // 회원가입 처리
    @PostMapping("/register")
    public String registerUser(String name,String email, String password, String address, Model model) {
        // 이메일 중복 확인
        if (memberRepository.existsByEmail(email)) {
            model.addAttribute("errorMessage", "이미 사용 중인 이메일입니다.");
            return "register";
        }

        // 새로운 사용자 생성 및 저장
        Member newMember = new Member();
        newMember.setEmail(email);
        newMember.setPassword(password);  // 실제 서비스에서는 비밀번호를 암호화해야 함
        newMember.setMemberName(name);
        newMember.setMemberAddress(address);
        newMember.setRegdate(LocalDateTime.now());
        memberRepository.save(newMember);

        return "redirect:/login";  // 회원가입 성공 시 로그인 페이지로 리디렉트
    }


    // 필기구 페이지를 처리
    @GetMapping("/product/pen")
    public String showPenPage(Model model) {
        model.addAttribute("pen");  // 필기구 제품 목록을 모델에 추가
        return "/product/pen";  // pen.html 템플릿을 반환
    }

    @GetMapping("/detail/pencilDetail")
    public String showPencilPage(Model model) {
        model.addAttribute("pencil");  // 필기구 제품 목록을 모델에 추가
        return "/detail/pencil";  // pen.html 템플릿을 반환
    }

    @GetMapping("/product/notebooks")
    public String showNotePage(Model model) {
        model.addAttribute("notebooks");
        return "/product/notebooks";
    }

    @GetMapping("/product/files")
    public String showFilePage(Model model) {
        model.addAttribute("files");
        return "/product/files";
    }

    @GetMapping("/product/stationery")
    public String showStationeryPage(Model model) {
        model.addAttribute("stationery");
        return "/product/stationery";
    }

    @GetMapping("/product/office")
    public String showOfficeSuppliesPage(Model model) {
        model.addAttribute("office");
        return "/product/office";
    }

    @GetMapping("/product/other")
    public String showOtherPage(Model model) {
        model.addAttribute("other");
        return "/product/other";
    }

}




