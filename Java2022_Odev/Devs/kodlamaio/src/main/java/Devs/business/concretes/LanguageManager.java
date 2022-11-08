package Devs.business.concretes;

import Devs.business.abstracts.LanguageService;
import Devs.business.constants.Messages;
import Devs.business.requests.LanguageRequest.CreateLanguageRequest;
import Devs.business.requests.LanguageRequest.DeleteLanguageRequest;
import Devs.business.requests.LanguageRequest.UpdateLanguageRequest;
import Devs.business.responses.Language.GetAllLanguagesResponse;
import Devs.business.responses.Language.GetAllLanguagesWithTechnologiesResponse;
import Devs.business.responses.Language.GetByIdLanguageResponse;
import Devs.business.responses.Techonology.GetAllTechnologiesNameResponse;
import Devs.core.utilities.business.BusinessRules;
import Devs.core.utilities.results.DataResult;
import Devs.core.utilities.results.ErrorResult;
import Devs.core.utilities.results.SuccessDataResult;
import Devs.core.utilities.results.SuccessResult;
import Devs.dataAccess.abstracts.LanguageRepository;
import Devs.dataAccess.abstracts.TechonologyRepository;
import Devs.entities.concretes.Language;
import Devs.entities.concretes.Techonology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private LanguageRepository _languageRepository;
    private TechonologyRepository _techonologyRepository;

@Autowired
    public LanguageManager(LanguageRepository languageRepository,TechonologyRepository techonologyRepository){

       _languageRepository = languageRepository;
       _techonologyRepository = techonologyRepository;
    }

    @Override
    public DataResult<List<GetAllLanguagesResponse>> getAll() {
        List<Language> Languages = _languageRepository.findAll();
        List<GetAllLanguagesResponse> LanguagesResponse = new ArrayList<>();

        for(Language Language : Languages){
            GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
            responseItem.setId(Language.getId());
            responseItem.setName(Language.getName());

           LanguagesResponse.add(responseItem);
        }

        return new SuccessDataResult<List<GetAllLanguagesResponse>>(LanguagesResponse, Messages.LANGUAGES_LISTED);
    }

    @Override
    public DataResult<List<GetAllLanguagesWithTechnologiesResponse>> getAllWithTechnologies() {
        return null;
    }

    @Override
    public DataResult<List<GetAllLanguagesWithTechnologiesResponse>>  getAllWithTechnologies() {
        List<Language> Languages = _languageRepository.findAll();
        List<Techonology> Technologies = _techonologyRepository.findAll();
        List<GetAllLanguagesWithTechnologiesResponse> LanguagesWithTechnologies = new ArrayList<GetAllLanguagesWithTechnologiesResponse>();

        for(Language Language : Languages){
            GetAllLanguagesWithTechnologiesResponse responseItem = new GetAllLanguagesWithTechnologiesResponse();
            responseItem.setId(Language.getId());
            responseItem.setName(Language.getName());

            List<GetAllTechnologiesNameResponse> TechnologiesResponse = new ArrayList<GetAllTechnologiesNameResponse>();
            for (Techonology Techonology: Technologies){
                if(Techonology.getLanguage().getId() == Language.getId()){
                    GetAllTechnologiesNameResponse responseItemTechnology = new GetAllTechnologiesNameResponse();
                    responseItemTechnology.setId(Techonology.getId());
                    responseItemTechnology.setName(Techonology.getName());
                   TechnologiesResponse.add(responseItemTechnology);
                }
            }

            responseItem.setTechnologies(TechnologiesResponse);
            LanguagesWithTechnologies.add(responseItem);
        }
        return new SuccessDataResult<List<GetAllLanguagesWithTechnologiesResponse>>(LanguagesWithTechnologies, Messages.LANGUAGES_LISTED_WITH_TECHNOLOGIES);
    }

    @Override
    public DataResult<GetByIdLanguageResponse> getById(int id) {
        Language Language = _languageRepository.findById(id).get();
        GetByIdLanguageResponse responseItem = new GetByIdLanguageResponse();
        responseItem.setId(Language.getId());
        responseItem.setName(Language.getName());

        return new SuccessDataResult<GetByIdLanguageResponse>(responseItem, Messages.LANGUAGE_GET_BY_ID);
    }


    @Override
    public Result add(CreateLanguageRequest createLanguageRequest) {
        Result result = BusinessRules.Run(checkIfLanguageNameExist(createLanguageRequest.getName()),
                checkIfLanguageNameIsEmpty(createLanguageRequest.getName()));

        if(result != null){
            return result;
        }

       Language Language = new Language();
        Language.setName(createLanguageRequest.getName());
        _languageRepository.save(Language);
        return new SuccessResult(Messages.LANGUAGE_ADDED);
    }

    @Override
    public Result update(UpdateLanguageRequest updateLanguageRequest) {
        Result result = BusinessRules.Run(checkIfLanguageIdDoesntExist(updateLanguageRequest.getId()));
        if(result != null) {
            return result;
        }

        Language Language = _languageRepository.findById(updateLanguageRequest.getId()).get();
        Language.setName(updateLanguageRequest.getName());
       _languageRepository.save(Language);

        return new SuccessResult(Messages.LANGUAGE_UPDATED);
    }

    @Override
    public Result delete(DeleteLanguageRequest deleteLanguageRequest) {
        Result result = BusinessRules.Run(checkIfLanguageIdDoesntExist(deleteLanguageRequest.getId()));
        if(result != null){
            return result;
        }
        _languageRepository.deleteById(deleteLanguageRequest.getId());
        return new SuccessResult(Messages.LANGUAGE_DELETED);
    }

    //Business Rules
    public Result checkIfLanguageNameExist(String name){
        List<Language> Languages = _languageRepository.findAll();
        for(Language Language : Languages){
            if(Language.getName().equals(name)){
                return new ErrorResult(Messages.LANGUAGE_NAME_EXIST);
            }
        }
        return new SuccessResult();
    }

    public Result checkIfLanguageNameIsEmpty(String name){
        if(name.isEmpty()){
            return new ErrorResult(Messages.LANGUAGE_NAME_CANNOT_BE_EMPTY);
        }

        return new SuccessResult();
    }

    public Result checkIfLanguageIdDoesntExist(int id) {
        boolean Languages = _languageRepository.existsById(id);
        if (Languages == false) {
            return new ErrorResult(Messages.LANGUAGE_DOESNT_EXIST);
        }
        return new SuccessResult();
    }
}
