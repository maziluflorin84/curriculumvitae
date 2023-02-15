package com.florinmazilu.curriculumvitae.controllers;

import com.florinmazilu.curriculumvitae.repositories.ExperienceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExperienceController {
    private final ExperienceRepository experienceRepository;

    public ExperienceController(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @RequestMapping("experiences")
    public String getExperiences(Model model) {
        model.addAttribute("experiences", experienceRepository.findAll());

        return "experiences/list";
    }
}
