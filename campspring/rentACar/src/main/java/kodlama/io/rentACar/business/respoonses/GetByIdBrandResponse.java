package kodlama.io.rentACar.business.respoonses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdBrandResponse {

    private int id;
    private String name;
}
