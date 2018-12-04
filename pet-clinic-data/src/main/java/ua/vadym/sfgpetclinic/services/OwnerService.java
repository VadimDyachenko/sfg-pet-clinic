package ua.vadym.sfgpetclinic.services;

import ua.vadym.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
