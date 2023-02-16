package com.florinmazilu.curriculumvitae.repositories;

import com.florinmazilu.curriculumvitae.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
