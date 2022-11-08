package Devs.business.concretes;

import Devs.business.abstracts.TechonologyService;
import Devs.business.constants.Messages;
import Devs.business.requests.TechonologyRequest.CreateTechonologyRequest;
import Devs.business.requests.TechonologyRequest.DeleteTechonologyRequest;
import Devs.business.requests.TechonologyRequest.UpdateTechonologyRequest;
import Devs.business.responses.Techonology.GetAllTechnologiesResponse;
import Devs.business.responses.Techonology.GetByIdTechnologyResponse;
import Devs.core.utilities.business.BusinessRules;
import Devs.core.utilities.results.DataResult;
import Devs.core.utilities.results.ErrorResult;
import Devs.core.utilities.results.SuccessDataResult;
import Devs.core.utilities.results.SuccessResult;
import Devs.dataAccess.abstracts.LanguageRepository;
import Devs.dataAccess.abstracts.TechonologyRepository;
import Devs.entities.concretes.Language;
import Devs.entities.concretes.Techonology;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

@Service
public class TechonologyManager implements TechonologyService {

    private TechonologyRepository _technologyRepository;
    private LanguageRepository _languageRepository;

    public TechonologyManager(TechonologyRepository TechnologyRepository, LanguageRepository LanguageRepository) {
        _technologyRepository = TechnologyRepository;
        _languageRepository = LanguageRepository;
    }

    @Override
    public DataResult<List<GetAllTechnologiesResponse>> getAll() {
        List<Techonology> Technologies = _technologyRepository.findAll();
        List<GetAllTechnologiesResponse> TechnologiesResponse = new ArrayList<>();

        for(Techonology Techonology : Technologies){
            GetAllTechnologiesResponse responseItem = new GetAllTechnologiesResponse();
            responseItem.setId(Techonology.getId());
            responseItem.setName(Techonology.getName());
            responseItem.setLanguageName(Technologies.getLanguage().getName());
            TechnologiesResponse.add(responseItem);
        }
        return new SuccessDataResult<List<GetAllTechnologiesResponse>>(TechnologiesResponse, Messages.TECHNOLOGIES_LISTED);
    }

    @Override
    public DataResult<GetByIdTechnologyResponse> getById(int id) {

        Techonology Technology = _technologyRepository.findById(id).get();
        GetByIdTechnologyResponse responseItem = new GetByIdTechnologyResponse();
        responseItem.setId(Technology.getId());
        responseItem.setName(Technology.getName());
        responseItem.setLanguageName(Technology.getLanguage().getName());

        return new SuccessDataResult<GetByIdTechnologyResponse>(responseItem, Messages.TECHNOLOGY_GET_BY_ID);
    }

    @Override
    public Result add(CreateTechonologyRequest createTechnologyRequest) {


        Result result = BusinessRules.Run(checkIfTechnologyNameExist(createTechnologyRequest.getName()),
                checkIfTechnologyNameIsEmpty(createTechnologyRequest.getName()));
        if(result != null) {
            return result;
        }
       Techonology Technology = new Techonology();
       Language Language = _languageRepository.findById(createTechnologyRequest.getLanguageId()).get();

       Technology.setName(createTechnologyRequest.getName());
        Technology.setLanguage(Language);

        _technologyRepository.save(Technology);

        return new SuccessResult(Messages.TECHNOLOGY_ADDED);
    }

    @Override
    public Result update(UpdateTechonologyRequest updateTechnologyRequest) {
        Result result = BusinessRules.Run(checkIfTechnologyIdDoesntExist(updateTechnologyRequest.getId()));
        if(result != null) {
            return result;
        }

        Techonology Technology = _technologyRepository.findById(updateTechnologyRequest.getId()).get();
        Language Language = _languageRepository.findById(updateTechnologyRequest.getLanguageId()).get();

        Techonology.setName(updateTechnologyRequest.getName());
        Techonology.setLanguage(Language);

        _technologyRepository.save(Technology);
        return new SuccessResult(Messages.TECHNOLOGY_UPDATED);
    }

    @Override
    public Result delete(DeleteTechonologyRequest deleteTechnologyRequest) {
        Result result = BusinessRules.Run(checkIfTechnologyIdDoesntExist(deleteTechnologyRequest.getLanguageId()));
        if(result != null) {
            return result;
        }

        _technologyRepository.deleteById(deleteTechnologyRequest.getLanguageId());
        return new SuccessResult(Messages.TECHNOLOGY_DELETED);
    }

    //Business Rules
    public Result checkIfTechnologyNameExist(String name){
        List<Techonology> Technologies = _technologyRepository.findAll();
        for(Techonology Technology : Technologies){
            if(Technology.getName().equals(name)){
                return new ErrorResult(Messages.TECHNOLOGY_NAME_EXIST);
            }
        }
        return new SuccessResult();
    }

    public Result checkIfTechnologyNameIsEmpty(String name){
        if(name.isEmpty()){
            return (Result) new ErrorResult(Messages.TECHNOLOGY_NAME_CANNOT_BE_EMPTY);
        }
        return new SuccessResult();
    }

    public Result checkIfTechnologyIdDoesntExist(int id){
        boolean Technology = _technologyRepository.existsById(id);
        if(Technology == false){
            return new ErrorResult(Messages.TECHNOLOGY_DOESNT_EXIST);
        }

        return new SuccessResult();
    }

}
