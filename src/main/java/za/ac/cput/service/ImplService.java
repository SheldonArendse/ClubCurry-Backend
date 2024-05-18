package za.ac.cput.service;

import java.util.List;

public interface ImplService <T, ID>{
    public T create(T obj);
    public T read(ID id);
    public T update(T obj);
    public void delete(T obj);
    public List<T> getAll();
}
