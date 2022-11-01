package kodlama.io.Kodlama.io.Devs.dataAccess.abstracts;

import kodlama.io.Kodlama.io.Devs.entites.concretes.Language;

import java.util.List;

public interface LanguageRepository {
    List<Language> getAll();
    void add(Language language);

    void update(int id,Language language);

    void delete(int id);

    Language getById(int id);
}
