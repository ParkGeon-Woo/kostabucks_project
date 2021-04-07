import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.my.dao.DrinkDAO;
import com.my.exception.FindException;
import com.my.vo.Drink;

import lombok.extern.log4j.Log4j;

//Spring용 단위테스트
//@WebAppConfiguration //JUnit5인 경우
@RunWith(SpringJUnit4ClassRunner.class) //Juni4인 경우

//Spring 컨테이너용 XML파일 설정
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Log4j
public class DrinkDAOOracle {
	@Autowired
	private DrinkDAO dao;
	
	@Test
	public void selectAll() throws FindException{
		List<Drink> list = dao.selectAll();
		int expListSize = 0;
		assertTrue(expListSize < list.size());
	}
}
