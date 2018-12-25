package ua.vadym.sfgpetclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ua.vadym.sfgpetclinic.model.Vet;
import ua.vadym.sfgpetclinic.repository.VetRepository;
import ua.vadym.sfgpetclinic.services.VetService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class VetServiceImpl implements VetService{

    private final VetRepository vetRepository;

    public VetServiceImpl(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long identifier) {
        return vetRepository.findById(identifier).orElse(null);
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long identifier) {
        vetRepository.deleteById(identifier);
    }
}
