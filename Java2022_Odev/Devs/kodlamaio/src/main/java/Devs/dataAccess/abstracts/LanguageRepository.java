package Devs.dataAccess.abstracts;

import Devs.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LanguageRepository extends JpaRepository<Language,Integer> {

}
