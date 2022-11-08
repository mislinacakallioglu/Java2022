package Devs.webApi.controllers;


import Devs.business.abstracts.TechonologyService;
import Devs.business.requests.TechonologyRequest.CreateTechonologyRequest;
import Devs.business.requests.TechonologyRequest.DeleteTechonologyRequest;
import Devs.business.requests.TechonologyRequest.UpdateTechonologyRequest;
import Devs.business.responses.Techonology.GetAllTechnologiesResponse;
import Devs.business.responses.Techonology.GetByIdTechnologyResponse;
import Devs.core.utilities.results.DataResult;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechonologiesController {

    private TechonologyService _technologyService;

    public TechonologiesController(TechonologyService techonologyService) {
        _technologyService = techonologyService;
    }

    @GetMapping("/getall")
    public DataResult<List<GetAllTechnologiesResponse>> getAll(){
        return _technologyService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public DataResult<GetByIdTechnologyResponse> getById(int id){
        return _technologyService.getById(id);
    }

    @PostMapping("/add")
    public Result add(CreateTechonologyRequest createTechonologyRequest ){
        return _technologyService.add(createTechonologyRequest);
    }

    @PutMapping("/update")
    public Result update(UpdateTechonologyRequest updateTechnologyRequest){
        return _technologyService.update(updateTechnologyRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteTechonologyRequest deleteTechnologyRequest){
        return _technologyService.delete(deleteTechnologyRequest);
    }
}
