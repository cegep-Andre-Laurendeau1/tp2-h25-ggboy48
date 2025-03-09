package ca.cal.tp2.repository;

import ca.cal.tp2.exception.DuplicateEntityException;

public interface Repository <T> {
    void save(T entity) throws DuplicateEntityException;
    T find(long id);
}
