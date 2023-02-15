package com.florinmazilu.curriculumvitae.controllers;

import com.florinmazilu.curriculumvitae.repositories.SkillRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SkillController {

    private final SkillRepository skillRepository;

    public SkillController(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @RequestMapping("/skills")
    public String getSkills(Model model) {
        model.addAttribute("skills", skillRepository.findAll());

        return "skills/list";
    }
}
