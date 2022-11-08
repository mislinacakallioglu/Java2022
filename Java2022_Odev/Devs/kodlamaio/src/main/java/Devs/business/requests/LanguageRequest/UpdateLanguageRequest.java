package Devs.business.requests.LanguageRequest;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateLanguageRequest {

    private int id;
    private String name;
}
