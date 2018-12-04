package ua.vadym.sfgpetclinic.services.map;

import ua.vadym.sfgpetclinic.model.Owner;
import ua.vadym.sfgpetclinic.services.CrudService;

import java.util.Set;

public class OwnerServiceMap extends AbstarctMapService<Owner, Long> implements CrudService<Owner, Long> {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.findById(id);
    }
}
