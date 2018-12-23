package ua.vadym.sfgpetclinic.repository;

import org.springframework.data.repository.CrudRepository;
import ua.vadym.sfgpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
