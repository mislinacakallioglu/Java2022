package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.respoonses.GetAllBrandsResponse;

import java.util.List;


public interface BrandService {
    abstract List<GetAllBrandsResponse> getAll();

    void add(CreateBrandRequest createBrandRequest);
    }

