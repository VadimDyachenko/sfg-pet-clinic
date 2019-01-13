package ua.vadym.sfgpetclinic.repository;

import org.springframework.data.repository.CrudRepository;
import ua.vadym.sfgpetclinic.model.Owner;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findByLastNameLike(String lastName);
}
