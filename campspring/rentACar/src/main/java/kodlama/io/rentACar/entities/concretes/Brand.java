package kodlama.io.rentACar.entities.concretes;



import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name="brands")
//@Data // getter + setter
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id'i otomatik artırma
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Model> models;

}
