package Devs.business.responses.Techonology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllTechnologiesResponse {

    private int id;
    private String name;
    private String languageName;
}
