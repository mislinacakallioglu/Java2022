package kodlama.io.Kodlama.io.Devs.business.concretes;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entites.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    private LanguageRepository languageRepository;

@Autowired
    public LanguageManager(LanguageRepository languageRepository){

        this.languageRepository=languageRepository;
    }


    @Override
    public List<Language> getAll() {

        return languageRepository.getAll();
    }

    @Override
    public Language add(Language language) throws Exception {
        if (isLanguageExist(language)) {
            throw new Exception("Bu dil mevcut ");
        }

        if (checkLanguageNameValid(language)) {
            throw new Exception("Dil adi gecersiz ");
        }

        languageRepository.add(language);
        return language;
    }

    @Override
    public void update(int id ,Language language) throws Exception {
        if (isLanguageExist(language)) {
            throw new Exception("Bu dil mevcut ");
        }

        if (checkLanguageNameValid(language)) {
            throw new Exception("Dil adi gecersiz");
        }

        languageRepository.update(id,language);
    }

    @Override
    public void delete(int id)  {
        languageRepository.delete(id);
    }

    @Override
    public Language getById(int id) {
        return languageRepository.getById(id);
    }

    public boolean isLanguageExist(Language language) {
        return languageRepository.getAll().stream().anyMatch(l -> l.getName().equals(language.getName()));}

    public boolean checkLanguageNameValid(Language language) {
        return language.getName().isEmpty()|| language.getName().isBlank()||language.getName().length()<2;

    }

}
