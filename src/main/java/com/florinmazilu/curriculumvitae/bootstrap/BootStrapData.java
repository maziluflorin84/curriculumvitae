package com.florinmazilu.curriculumvitae.bootstrap;

import com.florinmazilu.curriculumvitae.model.Experience;
import com.florinmazilu.curriculumvitae.model.Skill;
import com.florinmazilu.curriculumvitae.repositories.ExperienceRepository;
import com.florinmazilu.curriculumvitae.repositories.SkillRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
public class BootStrapData implements CommandLineRunner {

    private final ExperienceRepository experienceRepository;
    private final SkillRepository skillRepository;

    public BootStrapData(ExperienceRepository experienceRepository, SkillRepository skillRepository) {
        this.experienceRepository = experienceRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Experience unicreditExp = new Experience("Java developer", "UniCredit",
                new GregorianCalendar(2018, Calendar.SEPTEMBER, 15).getTime(),
                new GregorianCalendar(2021, Calendar.OCTOBER, 15).getTime(),
                false, "none");
        Skill javaSkill = new Skill("Java");
        Skill jspSkill = new Skill("JSP");

        unicreditExp.getSkills().add(javaSkill);
        unicreditExp.getSkills().add(jspSkill);
        javaSkill.getExperiences().add(unicreditExp);
        jspSkill.getExperiences().add(unicreditExp);

        experienceRepository.save(unicreditExp);
        skillRepository.save(javaSkill);
        skillRepository.save(jspSkill);

        Experience cognizantExp = new Experience("Java developer", "Cognizant Softvision",
                new GregorianCalendar(2021, Calendar.OCTOBER, 20).getTime(),
                new Date(), true, "none");
        Skill jenkinsSkill = new Skill("Jenkins");

        cognizantExp.getSkills().add(javaSkill);
        cognizantExp.getSkills().add(jenkinsSkill);
        javaSkill.getExperiences().add(cognizantExp);
        jenkinsSkill.getExperiences().add(cognizantExp);

        experienceRepository.save(cognizantExp);
        skillRepository.save(javaSkill);
        skillRepository.save(jenkinsSkill);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of skills: " + skillRepository.count());
    }
}
