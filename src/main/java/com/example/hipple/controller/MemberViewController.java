package com.example.hipple.controller;

import com.example.hipple.dto.request.MemberDao;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class MemberViewController {
    private final MemberDao memberDao;

    public MemberViewController(MemberDao memberDao){
        this.memberDao=memberDao;
    }

    @GetMapping("/testings")
    public String members(Model model){
        model.addAttribute("members", memberDao.getAllMembers());
        return "testings";
    }
}
