package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.respoonses.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController //annotaiton
@RequestMapping("/api/models")
@AllArgsConstructor

public class ModelsController {
    private ModelService modelService;

    @GetMapping()
    public List<GetAllModelsResponse> getALl(){
        return modelService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }

}
