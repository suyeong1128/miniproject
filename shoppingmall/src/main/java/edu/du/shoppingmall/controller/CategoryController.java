package edu.du.shoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryController {

    @GetMapping("/")
    public String main() { return "/main"; }

    // 카테고리 페이지를 처리
    @GetMapping("/main")
    public String showCategoriesPage(Model model) {
        model.addAttribute("main", getCategories());
        return "main";
    }

    // 필기구 페이지를 처리
    @GetMapping("/pen")
    public String showPenPage(Model model) {
        model.addAttribute("pen", getPenProducts());  // 필기구 제품 목록을 모델에 추가
        return "pen";  // pen.html 템플릿을 반환
    }

    @GetMapping("/notebooks")
    public String showNotePage(Model model) {
        model.addAttribute("notebooks", getPenProducts());
        return "notebooks";
    }

    @GetMapping("/files")
    public String showFilePage(Model model) {
        model.addAttribute("files", getPenProducts());
        return "files";
    }

    @GetMapping("/stationery")
    public String showStationeryPage(Model model) {
        model.addAttribute("stationery", getPenProducts());
        return "stationery";
    }

    @GetMapping("/office")
    public String showOfficeSuppliesPage(Model model) {
        model.addAttribute("office", getPenProducts());
        return "office";
    }

    @GetMapping("/other")
    public String showOtherPage(Model model) {
        model.addAttribute("other", getPenProducts());
        return "other";
    }

    // 카테고리 목록을 반환하는 메소드 (더미 데이터)
    private List<String> getCategories() {
        return List.of("", "노트 및 다이어리", "파일 및 폴더", "학생용 문구", "사무용품", "기타 문구 및 소품");
    }

    // 필기구 제품 목록 (더미 데이터)
    private List<String> getPenProducts() {
        return List.of("볼펜", "유성펜", "젤펜");
    }
}

