package za.ac.cput.service;
import java.util.List;

public interface IService<T, ID>{
    public T create(T obj);
    public T read(ID id);
    public void delete(T obj);
    public List<T> getAll();
}
