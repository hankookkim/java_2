package com.example.menuservice.viewController;

import com.example.menuservice.repository.*;
import com.example.menuservice.service.MenuService;
import com.example.menuservice.dto.MenuResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class MenuViewController {

    private final MenuService menuService;
    private final BreadRepository breadRepository;
    private final MaterialRepository materialRepository;
    private final CheeseRepository cheeseRepository;
    private final VegetableRepository vegetableRepository;
    private final SauceRepository sauceRepository;

    // ✅ 메뉴 등록 폼 페이지
    @GetMapping("/menus/admin")
    public String showMenuForm(Model model) {
        model.addAttribute("breads", breadRepository.findAll());
        model.addAttribute("materials", materialRepository.findAll());
        model.addAttribute("cheeses", cheeseRepository.findAll());
        model.addAttribute("vegetables", vegetableRepository.findAll());
        model.addAttribute("sauces", sauceRepository.findAll());
        return "menuAdmin"; // menuAdmin.html (등록용 폼)
    }

    // ✅ 메뉴 목록 페이지
    @GetMapping("/menus/list")
    public String viewMenuList(Model model) {
        model.addAttribute("menus", menuService.viewMenuList());
        return "menuList"; // 메뉴 목록 페이지
    }

    // ✅ 메뉴 수정 페이지
    @GetMapping("/menus/edit/{menuName}")
    public String editMenu(@PathVariable String menuName, Model model) {
        MenuResponseDTO menu = menuService.viewMenu(menuName);

        // 메뉴 정보
        model.addAttribute("menu", menu);
        model.addAttribute("imgUrl", menu.getImg()); // 이미지 URL (이미지 미리보기 + 유지용)

        // 선택 옵션들
        model.addAttribute("breads", breadRepository.findAll());
        model.addAttribute("materials", materialRepository.findAll());
        model.addAttribute("cheeses", cheeseRepository.findAll());
        model.addAttribute("vegetables", vegetableRepository.findAll());
        model.addAttribute("sauces", sauceRepository.findAll());

        return "menuEdit"; // menuEdit.html (수정용 폼)
    }
}
