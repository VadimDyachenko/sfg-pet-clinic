package ua.vadym.sfgpetclinic.services.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ua.vadym.sfgpetclinic.model.Visit;
import ua.vadym.sfgpetclinic.repository.VisitRepository;
import ua.vadym.sfgpetclinic.services.VisitService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class VisitServiceImpl implements VisitService {

    private VisitRepository visitRepository;

    public VisitServiceImpl(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long identifier) {
        return visitRepository.findById(identifier).orElse(null);
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);
    }

    @Override
    public void deleteById(Long identifier) {
        visitRepository.deleteById(identifier);
    }
}
