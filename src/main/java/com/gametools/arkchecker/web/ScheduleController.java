package com.gametools.arkchecker.web;

import com.gametools.arkchecker.domain.Schedule;
import com.gametools.arkchecker.domain.dto.ScheduleClearRequestDto;
import com.gametools.arkchecker.domain.dto.ScheduleRegisterRequestDto;
import com.gametools.arkchecker.service.CharacterService;
import com.gametools.arkchecker.service.ScheduleService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RequestMapping(value = "/schedule")
@Controller
public class ScheduleController {
    private final ScheduleService scheduleService;
    private final CharacterService characterService;

    @GetMapping(value = "/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("/schedule/register");
        modelAndView.addObject("characters", characterService.getAllCharacterList());

        return modelAndView;
    }

    @PostMapping(value = "/register")
    public String register(ScheduleRegisterRequestDto requestDto) {
        scheduleService.register(requestDto);

        return "redirect:/schedule/list";
    }

    @GetMapping(value = "/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("/schedule/list");
        modelAndView.addObject("characters",
            characterService.getAllCharacterList());

        return modelAndView;
    }

    @GetMapping(value = "/list/{characterName}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Schedule>> scheduleList(@PathVariable String characterName) {
        return ResponseEntity.ok(scheduleService.getCharacterSchedules(characterName));
    }

    @PutMapping(value = "/clear", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> clearSchedule(@RequestBody ScheduleClearRequestDto requestDto) {
        scheduleService.scheduleClear(requestDto);

        return ResponseEntity.ok(true);
    }
}
