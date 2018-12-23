package ua.vadym.sfgpetclinic.repository;

import org.springframework.data.repository.CrudRepository;
import ua.vadym.sfgpetclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
