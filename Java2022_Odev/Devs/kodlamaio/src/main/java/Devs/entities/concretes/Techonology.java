package Devs.entities.concretes;


import lombok.*;
import nonapi.io.github.classgraph.json.Id;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "techonology")
public class Techonology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinColumn(name = "language_id")
    private Language language;

    }
