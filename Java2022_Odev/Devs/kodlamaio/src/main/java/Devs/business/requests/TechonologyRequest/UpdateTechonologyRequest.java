package Devs.business.requests.TechonologyRequest;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTechonologyRequest {

    private int id;
    private String name;
    private int LanguageId;
}
