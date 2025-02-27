package ca.cal.tp1.persistance;

public interface InterfaceRepository <T>{
    public void save(T object);
    public T get(Long id);
    public void delete(Long id);
}