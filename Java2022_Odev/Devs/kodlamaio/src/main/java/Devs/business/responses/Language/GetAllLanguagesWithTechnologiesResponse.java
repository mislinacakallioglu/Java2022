package Devs.business.responses.Language;


import Devs.business.responses.Techonology.GetAllTechnologiesNameResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllLanguagesWithTechnologiesResponse {

    private int id;
    private String name;
    private List<GetAllTechnologiesNameResponse> Technologies;
}
