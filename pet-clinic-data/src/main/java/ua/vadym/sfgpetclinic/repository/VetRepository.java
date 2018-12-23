package ua.vadym.sfgpetclinic.repository;

import org.springframework.data.repository.CrudRepository;
import ua.vadym.sfgpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
