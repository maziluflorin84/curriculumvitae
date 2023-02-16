package com.florinmazilu.curriculumvitae.repositories;

import com.florinmazilu.curriculumvitae.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
