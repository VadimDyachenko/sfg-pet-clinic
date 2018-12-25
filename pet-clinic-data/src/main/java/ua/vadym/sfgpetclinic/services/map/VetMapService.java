package ua.vadym.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ua.vadym.sfgpetclinic.model.Speciality;
import ua.vadym.sfgpetclinic.model.Vet;
import ua.vadym.sfgpetclinic.services.SpecialityService;
import ua.vadym.sfgpetclinic.services.VetService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstarctMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

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
        if(vet.getSpecialities().size() > 0) {
            vet.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null) {
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
