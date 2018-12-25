package ua.vadym.sfgpetclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ua.vadym.sfgpetclinic.model.Speciality;
import ua.vadym.sfgpetclinic.repository.SpecialityRepository;
import ua.vadym.sfgpetclinic.services.SpecialityService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class SpecialityServiceImpl implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialityServiceImpl(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long identifier) {
        return specialityRepository.findById(identifier).orElse(null);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        specialityRepository.delete(speciality);
    }

    @Override
    public void deleteById(Long identifier) {
        specialityRepository.findById(identifier);
    }
}
