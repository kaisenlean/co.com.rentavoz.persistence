/**
 * 
 */
package co.com.rentavoz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import co.com.rentavoz.dao.MenuDao;
import co.com.rentavoz.entities.Menu;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project co.com.rentavoz.persistence
 * @class MenuDaoImpl
 * @date 21/07/2013
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/spring/app-context.xml" }) 
@Transactional
@TransactionConfiguration(defaultRollback=true)  
public class MenuDaoImplTest {

	@Resource 
	private MenuDao menuDao;
	
	private Logger log = Logger.getLogger(MenuDaoImplTest.class);
	/**
	 * Test method for {@link co.com.rentavoz.dao.impl.MenuDaoImpl#findPersons(int, int)}.
	 */
	@Test
	public void testFindPersons()throws Exception {
		List<Menu> menus = menuDao.findAll();
		log.info(menus);
		
	}

}
