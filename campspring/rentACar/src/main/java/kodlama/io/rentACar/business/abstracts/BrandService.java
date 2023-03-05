package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.respoonses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.respoonses.GetByIdBrandResponse;

import java.util.List;


public interface BrandService {
     List<GetAllBrandsResponse> getAll();
     GetByIdBrandResponse getById(int id);
     void add(CreateBrandRequest createBrandRequest);
     void update(UpdateBrandRequest updateBrandRequest);
     void delete(int id);
    }

