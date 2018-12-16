package ua.vadym.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import ua.vadym.sfgpetclinic.model.Speciality;
import ua.vadym.sfgpetclinic.services.SpecialityService;

import java.util.Set;

@Service
public class SpecialityServiceMap extends AbstarctMapService<Speciality, Long> implements SpecialityService {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return super.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        super.delete(speciality);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
