package ua.vadym.sfgpetclinic.services.map;

import ua.vadym.sfgpetclinic.model.Visit;
import ua.vadym.sfgpetclinic.services.VisitService;

import java.util.Set;

public class VisitMapService extends AbstarctMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long identifier) {
        return super.findById(identifier);
    }

    @Override
    public Visit save(Visit visit) {

        if(!isValid(visit)) {
            throw new RuntimeException("Invalid visit");
        }
        return super.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }


    @Override
    public void deleteById(Long id) {

    }

    private boolean isValid(Visit visit) {
        return visit.getPet() != null
                && visit.getPet().getOwner() != null
                && visit.getPet().getId() != null
                && visit.getPet().getOwner().getId() != null;
    }

}
