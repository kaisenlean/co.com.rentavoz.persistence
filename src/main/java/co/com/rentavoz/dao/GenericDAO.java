package co.com.rentavoz.dao;
import java.io.Serializable;
import java.util.List;

public interface GenericDAO <T, PK extends Serializable> {

    List<T> findAll();

    T findByPK( PK id);

    void update(T entity);

    void remove(T entity);

    void insert(T entity);
    
    List<T> getPaginated( int startPosition, int maxResult);
    
    List<T> getOrderedPaginated(int startPosition, int maxResult, String order, int dir);

}