package com.example.hipple.controller;

import com.example.hipple.domain.Portfolio;
import com.example.hipple.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guidePage")
@RequiredArgsConstructor
public class GuidePageController {
    private final UserService userService;

    @GetMapping("/getGuideName/{id}")
    public String getGuideName(@PathVariable Long id) {
        return userService.getInfoGuideName(id);
    }

    @GetMapping("/getGuidePortfolio/{id}")
    public Portfolio getGuidePortfolio(@PathVariable Long id) {
        return userService.getInfoGuidePortfolio(id);
    }

    @PostMapping("/saveGuidePortfolio/{id}")
    public Portfolio saveGuidePortfolio(@PathVariable Long id, @RequestBody Portfolio portfolio) {
        return userService.saveInfoGuidePortfolio(id, portfolio);
    }

    @GetMapping("/getForms/{id}")
    public String getForms(@PathVariable Long id) {

    }
}
