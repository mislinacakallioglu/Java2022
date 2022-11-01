package kodlama.io.Kodlama.io.Devs.business.abstracts;

import kodlama.io.Kodlama.io.Devs.entites.concretes.Language;

import java.util.List;

public interface LanguageService {
    List<Language> getAll() ;

    Language add (Language language) throws Exception;

    void update(int id, Language language) throws Exception;

    void delete (int id) ;

    Language getById(int id) ;

}
