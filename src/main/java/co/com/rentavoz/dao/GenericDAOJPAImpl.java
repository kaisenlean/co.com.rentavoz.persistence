package co.com.rentavoz.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;



@PersistenceContext(unitName = "tutoriales")
public class GenericDAOJPAImpl<T, PK extends Serializable> extends
		JpaDaoSupport implements GenericDAO<T, PK> {

	private Class<T> type;
	
	  @SuppressWarnings("unchecked")
	    public GenericDAOJPAImpl() {
	        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	    }

	
	@Transactional
	public void insert(T t) {
		getJpaTemplate().persist(t);
	}

	@Transactional(readOnly = true)
	public T findByPK( PK id) {
		return getJpaTemplate().find(type, id);
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<T> findAll() {

		final StringBuilder sql = new StringBuilder("select c from ").append(
				type.getSimpleName()).append(" c");
		return (List<T>) getJpaTemplate().find(sql.toString());

	}

	@Transactional
	public void remove(T object) {
		getJpaTemplate().remove(getJpaTemplate().merge(object));
	}

	@Transactional
	public void update(T object) {
		getJpaTemplate().merge(object);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> getPaginated( int startPosition,
			int maxResult) {
		final StringBuilder sql = new StringBuilder("select c from ").append(
				type.getSimpleName()).append(" c");
		final Query query = getJpaTemplate().getEntityManagerFactory()
				.createEntityManager().createQuery(sql.toString());
		query.setFirstResult(startPosition);
		query.setMaxResults(maxResult);

		return (List<T>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> getOrderedPaginated(int startPosition,
			int maxResult, String order, int dir) {
		String direccion = "ASC";
		if (dir == 2) {
			direccion = "DESC";
		}
		final StringBuilder sql = new StringBuilder("select c from ")
				.append(type.getSimpleName()).append(" c order by ")
				.append(order).append(" ").append(direccion);
		final Query query = getJpaTemplate().getEntityManager().createQuery(
				sql.toString());
		query.setFirstResult(startPosition);
		query.setMaxResults(maxResult);

		return (List<T>) query.getResultList();
	}

}
