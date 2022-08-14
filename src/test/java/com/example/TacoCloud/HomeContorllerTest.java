package com.example.TacoCloud;

import com.example.TacoCloud.Controllers.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HomeController.class)
public class HomeContorllerTest {
	@Autowired
	private MockMvc mocMvc;

	@Test
	public void homePageTest() throws Exception {
		
		mocMvc.perform(get("/"))
			.andExpect(status().isOk());
			
	}
	
}
