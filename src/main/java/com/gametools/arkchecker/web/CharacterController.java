package com.gametools.arkchecker.web;

import com.gametools.arkchecker.domain.Classes;
import com.gametools.arkchecker.domain.dto.CharacterRegisterDto;
import com.gametools.arkchecker.service.CharacterService;
import com.gametools.arkchecker.util.EnumUtil;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RequestMapping(value = "/character")
@Controller
public class CharacterController {
    private final CharacterService characterService;

    @GetMapping(value = "/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("character/register");

        modelAndView.addObject("classList", EnumUtil.toEnumValues(Classes.class));

        return modelAndView;
    }

    @PostMapping(value = "/register")
    public String register(@Valid CharacterRegisterDto registerDto) {
        characterService.register(registerDto);

        return "redirect:/character/list";
    }

    @GetMapping(value = "/list")
    public ModelAndView characterList() {
        ModelAndView modelAndView = new ModelAndView("character/list");
        modelAndView.addObject("list", characterService.getAllCharacterList());

        return modelAndView;
    }
}
