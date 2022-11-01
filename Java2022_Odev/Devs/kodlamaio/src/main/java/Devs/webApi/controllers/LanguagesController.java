package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.entites.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService){
        this.languageService = languageService;
    }

    @GetMapping("/getall")
    public List<Language> getAll()  {
        return languageService.getAll();
    }
//    public Language getById(int id) throws Exception {
//        return languageService.getById(id);
//    }
//
//
//    public void add(Language language) throws Exception {
//        languageService.add(language);
//        System.out.println(language.getName() + " eklendi.");
//    }
//
//
//    public void update(Language language, int id) throws Exception {
//        languageService.update(language, id);
//        System.out.println(language.getName() + " guncellendi.");
//    }
//
//    public void delete(int id) throws Exception {
//        languageService.delete(id);
//        System.out.println("Programlama dili silindi.");
//    }
}
