package Devs.business.responses.Techonology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetByIdTechnologyResponse {

    private int id;
    private String name;
    private String LanguageName;
}

