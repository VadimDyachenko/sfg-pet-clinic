package ua.vadym.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import ua.vadym.sfgpetclinic.model.Pet;
import ua.vadym.sfgpetclinic.services.PetService;

import java.util.Set;

@Service
public class PetServiceMap extends AbstarctMapService<Pet, Long> implements PetService {

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
