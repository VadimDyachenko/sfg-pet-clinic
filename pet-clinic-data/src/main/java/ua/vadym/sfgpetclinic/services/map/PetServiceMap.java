package ua.vadym.sfgpetclinic.services.map;

import ua.vadym.sfgpetclinic.model.Pet;
import ua.vadym.sfgpetclinic.services.CrudService;

import java.util.Set;

public class PetServiceMap extends AbstarctMapService<Pet, Long> implements CrudService<Pet, Long> {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        super.findById(id);
    }
}
