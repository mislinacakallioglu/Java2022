package kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entites.concretes.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {
    List <Language> languages;

    public InMemoryLanguageRepository(){
        languages = new ArrayList<Language>();
        languages.add(new Language(1,"C#"));
        languages.add(new Language(2,"Java"));
        languages.add(new Language(3,"Python"));
    }

    @Override
    public List<Language> getAll() {

        return languages;
    }

    @Override
    public void add(Language language) {
        languages.add(language);
    }


    @Override
    public void update(int id,Language language) {
        Language newLanguage = getById(id);
        newLanguage.setName(language.getName());
    }


    @Override
    public void delete(int id) {
        Language language = getById(id);
        languages.remove(language);
    }

    @Override
    public Language getById(int id) {

        for (Language language : languages) {
            if (language.getId()== id) return language;
        }
        return null;
    }

}
