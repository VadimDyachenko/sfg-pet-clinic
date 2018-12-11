package ua.vadym.sfgpetclinic.services.map;

import ua.vadym.sfgpetclinic.model.Vet;
import ua.vadym.sfgpetclinic.services.VetService;

import java.util.Set;

public class VetServiceMap extends AbstarctMapService<Vet, Long> implements VetService {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.findById(id);
    }
}
