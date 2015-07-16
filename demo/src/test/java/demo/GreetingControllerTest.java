package demo;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GreetingController.class)
@WebAppConfiguration
public class GreetingControllerTest {

	private MockMvc mockMvc;

	@Autowired
  private WebApplicationContext wac;

  @Before
  public void setUp() throws Exception {
      mockMvc = webAppContextSetup(wac).build();
  }

	@Test
	public void contextLoads() {
		try {
			mockMvc.perform(get("/greetings/hello"))
							 .andExpect(status().isOk());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
