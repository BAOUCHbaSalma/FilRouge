package com.demo;

import com.demo.dto.OrderUserInsertionDto;
import com.demo.model.*;
import com.demo.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.control.MappingControl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class DoowasteApplicationTests {

//	@Autowired
//	private MessageService messageService;
//	@Autowired
//	private MealService mealService;
//	@Autowired
//	private ReactionService reactionService;
//	@Autowired
//	private PersonService personService;
//	@Autowired
//	private MerchantService merchantService;
//	@Autowired
//	private OrderUserService orderUserService;
//	@Autowired
//	private UserService userService;
//	@Autowired
//	private RestaurantService restaurantService;
//
//	@Test
//	void addPersonTest(){
//		Person person=new Person("Safaa","safaa@gmail.com","1234","img.png", Erole.USER);
//
//		Person person1=personService.Signup(person);
//
//		assertNotNull(person1.getId());
//		assertEquals("Safaa", person1.getUsername());
//		assertEquals("safaa@gmail.com", person1.getEmail());
//		assertEquals("img.png", person1.getImg());
//		assertEquals(Erole.USER, person1.getRole());
//
//
//	}
//
//	@Test
//	void findById(){
//		Person person=personService.findById(13);
//		assertEquals(13,person.getId());
//		assertEquals("Safaa", person.getUsername());
//		assertEquals("safaa@gmail.com", person.getEmail());
//		assertEquals("img.png", person.getImg());
//		assertEquals(Erole.USER, person.getRole());
//
//	}
//
//	@Test
//	void findAllMerchantTest(){
//		List<Merchant> merchants=merchantService.findAllMerchant();
//		assertEquals(2,merchants.get(0).getId());
//		assertEquals(4, merchants.get(1).getId());
//
//	}
//
//	@Test
//	void findByIdTest(){
//		Merchant merchant=merchantService.findById(2);
//		assertEquals(2,merchant.getId());
//		assertEquals("Hajar", merchant.getUsername());
//		assertEquals("hajar0@gmail.com", merchant.getEmail());
//		assertEquals("https://i.ibb.co/SQ4S9jW/Capture-d-cran-2024-09-22-230003.png", merchant.getImg());
//		assertEquals(Erole.MERCHANT, merchant.getRole());
//
//	}
//
//	@Test
//	void updateRestaurantTest(){
//		Restaurant restaurant=new Restaurant("Bella","Beni Mellal",32.5958283,-6.2694608);
//		Restaurant restaurant1=restaurantService.updateRestaurant(10,restaurant);
//		assertEquals("Bella",restaurant1.getName());
//		assertEquals("Beni Mellal",restaurant1.getVille());
//		assertEquals(32.5958283,restaurant1.getLatitude());
//		assertEquals(-6.2694608,restaurant1.getLongitude());
//	}
//
//	@Test
//	void findAllRestaurantTest(){
//		List<Restaurant> restaurants=restaurantService.findAllRestaurants();
//		assertEquals(1,restaurants.get(0).getIdRestaurant());
//		assertEquals(5,restaurants.get(1).getIdRestaurant());
//		assertEquals(10,restaurants.get(2).getIdRestaurant());
//	}
//
//	@Test
//	void addMessageTest(){
//		Merchant merchant=merchantService.findById(2);
//		User user =userService.findById(13);
//		Message message=new Message("Reclamation","Message Reclamation",user,merchant);
//		Message message1=messageService.addMessage(message);
//		assertNotNull(message1.getId());
//		assertEquals("Reclamation",message1.getSubject());
//		assertEquals("Message Reclamation",message1.getContent());
//		assertEquals(user.getId(),message1.getUser().getId());
//		assertEquals(merchant.getId(),message1.getMerchant().getId());
//	}
//	@Test
//	void findAllByUserTest(){
//		List<Message> messageList=messageService.findAllByUser(13);
//		assertEquals(3,messageList.get(0).getId());
//
//	}
//
//	@Test
//	void findMealRestaurantTest(){
//		List<Meal> mealList=mealService.findMealRestaurant(1);
//		assertEquals(1,mealList.get(0).getId());
//		assertEquals(2,mealList.get(1).getId());
//	}
//
//	@Test
//	void addMealTest(){
//		Meal meal=new Meal("Tagine viande","picture.pnj",50,3);
//		Meal meal1=mealService.addMeal(1,meal);
//		assertNotNull(meal1.getId());
//		assertEquals("Tagine viande",meal1.getName());
//		assertEquals("picture.pnj",meal1.getPicture());
//		assertEquals(50,meal1.getPrice());
//		assertEquals(3,meal1.getQuantity());
//
//	}
//
//	@Test
//	void findReactionMealTest(){
//		List<Reaction> reactionList=reactionService.findReactionMeal(1);
//		assertEquals(1,reactionList.get(0).getId());
//		assertEquals(2,reactionList.get(1).getId());
//
//	}
//	@Test
//	void passCommandeTest(){
//		Meal meal=mealService.findById(3);
//
//		OrderUserInsertionDto dto=new OrderUserInsertionDto(3,3,3,"hay houda beni mellal");
//		OrderUser orderUser=orderUserService.passeCommande(dto);
//		assertEquals(3,orderUser.getUser().getId());
//		assertEquals(3,orderUser.getMeal().getId());
//		assertEquals(3,orderUser.getQuantity());
//		assertEquals("hay houda beni mellal",orderUser.getAddress());
//		assertEquals(meal.getPrice()*3,orderUser.getPrice());
//		assertEquals(Evalidation.PENDING,orderUser.getValidation());
//	}
//
//		@Mock
//		private PersonService personService;
//		@Mock
//		private MerchantService merchantService;
//
//
//		@BeforeEach
//		void setUp() {
//			MockitoAnnotations.openMocks(this);
//		}
//
//		@Test
//		void addPersonTest(){
//			Person person = new Person("Safaa", "safaa@gmail.com", "1234", "img.png", Erole.USER);
//
//			when(personService.Signup(any(Person.class))).thenReturn(person);
//
//			Person person1 = personService.Signup(person);
//
//			assertNotNull(person1);
//			assertEquals("Safaa", person1.getUsername());
//			assertEquals("safaa@gmail.com", person1.getEmail());
//			assertEquals("img.png", person1.getImg());
//			assertEquals(Erole.USER, person1.getRole());
//
//			verify(personService, times(1)).Signup(any(Person.class));
//		}
//
//		@Test
//		void findByIdTest() {
//			Merchant merchant = new Merchant();
//			merchant.setId(2);
//			merchant.setUsername("Hajar");
//			merchant.setEmail("hajar0@gmail.com");
//			merchant.setImg("https://i.ibb.co/SQ4S9jW/Capture-d-cran-2024-09-22-230003.png");
//			merchant.setRole(Erole.MERCHANT);
//
//			when(merchantService.findById(2)).thenReturn(merchant);
//
//			Merchant merchant1 = merchantService.findById(2);
//
//			assertNotNull(merchant1);
//			assertEquals(2, merchant1.getId());
//			assertEquals("Hajar", merchant1.getUsername());
//			assertEquals("hajar0@gmail.com", merchant1.getEmail());
//			assertEquals("https://i.ibb.co/SQ4S9jW/Capture-d-cran-2024-09-22-230003.png", merchant1.getImg());
//			assertEquals(Erole.MERCHANT, merchant1.getRole());
//
//			verify(merchantService, times(1)).findById(2);
//		}


}











