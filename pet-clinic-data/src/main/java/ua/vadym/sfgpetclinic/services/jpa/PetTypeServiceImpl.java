package ua.vadym.sfgpetclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ua.vadym.sfgpetclinic.model.PetType;
import ua.vadym.sfgpetclinic.repository.PetTypeRepository;
import ua.vadym.sfgpetclinic.services.PetTypeService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class PetTypeServiceImpl implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeServiceImpl(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long identifier) {
        return petTypeRepository.findById(identifier).orElse(null);
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeRepository.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        petTypeRepository.delete(petType);
    }

    @Override
    public void deleteById(Long identifier) {
        petTypeRepository.deleteById(identifier);
    }
}
