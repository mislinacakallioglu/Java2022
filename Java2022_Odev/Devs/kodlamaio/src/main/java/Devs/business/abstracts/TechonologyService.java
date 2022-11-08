package Devs.business.abstracts;

import Devs.business.requests.TechonologyRequest.CreateTechonologyRequest;
import Devs.business.requests.TechonologyRequest.DeleteTechonologyRequest;
import Devs.business.requests.TechonologyRequest.UpdateTechonologyRequest;
import Devs.business.responses.Techonology.GetAllTechnologiesResponse;
import Devs.business.responses.Techonology.GetByIdTechnologyResponse;
import Devs.core.utilities.results.DataResult;

import javax.xml.transform.Result;
import java.util.List;

public interface TechonologyService {

    DataResult<List<GetAllTechnologiesResponse>> getAll();
    DataResult<GetByIdTechnologyResponse> getById(int id);
    Result add(CreateTechonologyRequest createTechnologyRequest);
    Result update(UpdateTechonologyRequest updateTechnologyRequest);
    Result delete(DeleteTechonologyRequest deleteTechnologyRequest);
}
