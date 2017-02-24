import static org.junit.Assert.*;

import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deviser.service.CategoryService;
import com.deviser.service.impl.CategoryServiceImpl;
import com.deviser.shop.model.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class SSHTest {
	@Resource
	private Date date;
	@Resource
	private CategoryService categoryService;
	
	private ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");


	@Test
	public void test() {
		//date = (Date) ctx.getBean("date");
		System.out.println(date);
	}
	
	@Test
	public void testHibernate() {
		/*Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		System.out.println("c2");
		Session session = null;
		System.out.println("c1");
		
		try {
			session = sf.openSession();
			session.beginTransaction();
			
			Category category = new Category();
			category.setType("生活用品");
			category.setHot(1);
			
			session.save(category);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (null != session && session.isOpen()) {
				session.close();
			}
		}*/
		
		CategoryService categoryService = new CategoryServiceImpl();
		Category category = new Category();
		category.setType("食品");
		category.setHot(true);
		categoryService.save(category);
	}

	@Test
	public void hibernateAndSpring() {
		Category cg = new Category();
		cg.setId(1);
		cg.setType("化妆品");
		cg.setHot(false);
		categoryService.update(cg);
	}
}
