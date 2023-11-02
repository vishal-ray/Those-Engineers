package com.alpha.ThoseEngineers.repositories.jobs.technicals;

import com.alpha.ThoseEngineers.modules.jobs.technicals.Framework;
import com.alpha.ThoseEngineers.modules.jobs.technicals.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
    @Query(value = "SELECT id FROM languages where languages_name =:LanguageName",nativeQuery = true)
    public int getLanguageId(String LanguageName);
}

