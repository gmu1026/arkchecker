package com.gametools.arkchecker.web;

import com.gametools.arkchecker.domain.Content;
import com.gametools.arkchecker.domain.ContentsType;
import com.gametools.arkchecker.domain.dto.ContentRegisterRequestDto;
import com.gametools.arkchecker.domain.dto.EnumValue;
import com.gametools.arkchecker.service.ContentService;
import com.gametools.arkchecker.util.EnumModel;
import com.gametools.arkchecker.util.EnumUtil;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RequestMapping(value = "/content")
@Controller
public class ContentController {
    private final ContentService contentService;

    @GetMapping(value = "/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("/content/register");
        modelAndView.addObject("types", EnumUtil.toEnumValues(ContentsType.class));

        return modelAndView;
    }

    @PostMapping(value = "/register")
    public String register(ContentRegisterRequestDto requestDto) {
        contentService.register(requestDto);

        return "redirect:/content/list";
    }

    @GetMapping(value = "/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("/content/list");
        modelAndView.addObject("contents", contentService.getAllContentList());

        return modelAndView;
    }

    @GetMapping(value = "/list/{characterName}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Content>> recommendList(@PathVariable String characterName) {
        return ResponseEntity.ok(contentService.getRecommendList(characterName));
    }
}
