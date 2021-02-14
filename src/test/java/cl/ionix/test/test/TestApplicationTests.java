package cl.ionix.test.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cl.ionix.test.test.controller.CifradoController;
import cl.ionix.test.test.controller.UserController;
import cl.ionix.test.test.model.AllUserOutput;
import cl.ionix.test.test.model.EmailRequest;
import cl.ionix.test.test.model.RegisterResponse;
import cl.ionix.test.test.model.UserCreateOuput;
import cl.ionix.test.test.model.UserEmailOutput;
import cl.ionix.test.test.model.UserInput;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestApplicationTests {
	
	@Autowired
	 private UserController userController = new UserController();
	
	@Autowired
	 private CifradoController cifradoController = new CifradoController();
	
	


	@Test
	void testHolaundoOK() {
		Assert.assertEquals("Hello World User", userController.helloWorld());
	}

	
	@Test
	void testCreateUserOK() {
		UserInput user = new UserInput();
		UserCreateOuput response = userController.createUser(user);
        Assert.assertEquals(response.isResult(), true);
		
	}
	
	@Test
	void testAllUserOK() {
		
        AllUserOutput response = userController.allUser();
        Assert.assertEquals(response.isResult(), true);
		
	}
	
	@Test
	void testUserByEmailOK() {
		EmailRequest email = new EmailRequest();
		UserEmailOutput response = userController.userByEmail(email);
        Assert.assertEquals(response.isResult(), false);
		
	}
	
	@Test
	void testCifradoOK() {
		
		RegisterResponse response = cifradoController.cifrado("1-9");
        Assert.assertEquals(response.getDescription(), "OK");
		
	}

}
