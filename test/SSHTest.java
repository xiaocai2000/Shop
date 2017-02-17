import static org.junit.Assert.*;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class SSHTest {
	@Resource
	private Date date;
	
	//private ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");


	@Test
	public void test() {
		//date = (Date) ctx.getBean("date");
		System.out.println(date);
	}

}
