package onlinefood;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import onlinefood.dao.FoodDao;
import onlinefood.model.Food;

@SpringBootTest
class OnlineFoodOrdering1ApplicationTests {
	@Autowired
	private FoodDao dao;
	@Test
	void contextLoads() {
	}
	@Test
	public void testAddFood() {
		Food f1=new Food();
		f1.setFoodName("biryani");
	}
	@Test
	public void testUpdateFood() {
		Food f=dao.findByFoodName("biryani");
		f.setFoodPrice(100);
		dao.save(f);
		assertEquals(500, f.getFoodPrice());
	}
	@Test
	public void testPrintFood() {
		Food f=dao.findByFoodName("biryani");
	}
	@Test
	public void testDeleteFood() {
		Food f=dao.findByFoodName("butter chicken");
		dao.delete(f);
		
	}
	@Test
	public void testByPrice() {
		Food f=dao.findByFoodName("biryani");
		assertEquals(500, f.getFoodPrice());
	}
	@Test
	public void testByType() {
		Food f=dao.findByFoodName("biryani");
		assertEquals("nonveg", f.getFoodType());
	}

}
