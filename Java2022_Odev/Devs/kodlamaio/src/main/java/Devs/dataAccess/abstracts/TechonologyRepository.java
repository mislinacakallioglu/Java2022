package Devs.dataAccess.abstracts;

import Devs.entities.concretes.Techonology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechonologyRepository extends JpaRepository<Techonology,Integer> {
}
