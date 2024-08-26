package za.ac.cput.service.interfaces;

import java.util.List;

public interface IService <T, ID>{

    public T save(T obj);

    public T read(ID id);

    public T update(T obj);

    public Boolean delete(ID id);

    public List<T> getAll();
}