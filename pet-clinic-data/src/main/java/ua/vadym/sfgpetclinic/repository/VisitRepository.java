package ua.vadym.sfgpetclinic.repository;

import org.springframework.data.repository.CrudRepository;
import ua.vadym.sfgpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
