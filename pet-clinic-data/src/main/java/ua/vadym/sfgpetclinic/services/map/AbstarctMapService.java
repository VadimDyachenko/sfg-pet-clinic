package ua.vadym.sfgpetclinic.services.map;

import ua.vadym.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstarctMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if (Objects.nonNull(object)) {

            if (Objects.isNull(object.getId())) {
                object.setId(getNextId());
            }

            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }

        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {

        return map.keySet().stream()
                .max(Long::compareTo)
                .map(id -> ++id)
                .orElse(1L);
    }
}
