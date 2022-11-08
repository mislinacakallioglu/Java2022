package Devs.business.abstracts;

import Devs.business.requests.LanguageRequest.CreateLanguageRequest;
import Devs.business.requests.LanguageRequest.DeleteLanguageRequest;
import Devs.business.requests.LanguageRequest.UpdateLanguageRequest;
import Devs.business.responses.Language.GetAllLanguagesResponse;
import Devs.business.responses.Language.GetAllLanguagesWithTechnologiesResponse;
import Devs.business.responses.Language.GetByIdLanguageResponse;
import Devs.core.utilities.results.DataResult;


import javax.xml.transform.Result;
import java.util.List;

public interface LanguageService {

    DataResult<List<GetAllLanguagesResponse>> getAll();
    DataResult<List<GetAllLanguagesWithTechnologiesResponse>> getAllWithTechnologies();
    DataResult<GetByIdLanguageResponse> getById(int id);
    Result add(CreateLanguageRequest createLanguageRequest);
    Result update(UpdateLanguageRequest updateLanguageRequest);
    Result delete(DeleteLanguageRequest deleteLanguageRequest);




}
