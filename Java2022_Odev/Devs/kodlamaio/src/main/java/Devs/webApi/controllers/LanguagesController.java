package Devs.webApi.controllers;

import Devs.business.abstracts.LanguageService;
import Devs.business.requests.LanguageRequest.CreateLanguageRequest;
import Devs.business.requests.LanguageRequest.DeleteLanguageRequest;
import Devs.business.requests.LanguageRequest.UpdateLanguageRequest;
import Devs.business.responses.Language.GetAllLanguagesResponse;
import Devs.business.responses.Language.GetAllLanguagesWithTechnologiesResponse;
import Devs.business.responses.Language.GetByIdLanguageResponse;
import Devs.core.utilities.results.DataResult;
import Devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private LanguageService _languageService;

    @Autowired
    public LanguagesController(LanguageService languageService){
        _languageService = languageService;
    }

    @GetMapping("/getall")
    public DataResult<List<GetAllLanguagesResponse>> getAll(){
        return _languageService.getAll();
    }


    @GetMapping("/getallwithprogrammingtechnologies")
    public DataResult<List<GetAllLanguagesWithTechnologiesResponse>> getAllWithProgrammingTechnologies(){
        return _languageService.getAllWithTechnologies();
    }

    @GetMapping("/getbyid/{id}")
    public DataResult<GetByIdLanguageResponse> getById(@RequestParam int id){
        return _languageService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateLanguageRequest createProgrammingLanguageRequest){
        return _languageService.add(createProgrammingLanguageRequest);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateLanguageRequest updateProgrammingLanguageRequest){
        return _languageService.update(updateProgrammingLanguageRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody DeleteLanguageRequest deleteProgrammingLanguageRequest){
        return _languageService.delete(deleteProgrammingLanguageRequest);
    }
}
