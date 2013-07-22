/**
 * 
 */
package co.com.rentavoz.dao.impl;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.rentavoz.dao.GenericDAOJPAImpl;
import co.com.rentavoz.dao.MenuDao;
import co.com.rentavoz.entities.Menu;
  
@Repository("menuDao")  
public class MenuDaoImpl extends GenericDAOJPAImpl<Menu, Integer> implements MenuDao{  
  
	 @Autowired
	    public MenuDaoImpl(EntityManagerFactory entityManagerFactory)
	    {
	        setEntityManagerFactory(entityManagerFactory);
	    }
}
