package Devs.business.responses.Language;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllLanguagesResponse {

    private int id;
    private String name;
    //private List<ProgrammingTechnology> programmingTechnologies;
}
