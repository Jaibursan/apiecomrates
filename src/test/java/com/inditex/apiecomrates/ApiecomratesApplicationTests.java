package com.inditex.apiecomrates;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class ApiecomratesApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	/*
	 * Test 1 for getPricesPricetoapply().
	 * This test receives brandId = 1, productId = 35455 and date = 2020-06-14 10:00:00.
	 * This test checks that the priceList is 1 and that the price amount is not empty.
	 */
	@Test
	void getPricesPricetoapplyFirstTest() throws Exception {

		String brandId = "1";
		String productId = "35455";
		String date = "2020-06-14 10:00:00";

		mockMvc.perform(get("/prices/pricetoapply")
			.param("brandId", brandId)
			.param("productId", productId)
			.param("date", date)               
		)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("1"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.price.amount").isNotEmpty());
	}

	/*
	 * Test 2 for getPricesPricetoapply().
	 * This test receives brandId = 1, productId = 35455 and date = 2020-06-14 16:00:00.
	 * This test checks that the priceList is 2 and that the price amount is not empty.
	 */
	@Test
	void getPricesPricetoapplySecondTest() throws Exception {

		String brandId = "1";
		String productId = "35455";
		String date = "2020-06-14 16:00:00";

		mockMvc.perform(get("/prices/pricetoapply")
			.param("brandId", brandId)
			.param("productId", productId)
			.param("date", date)               
		)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("2"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.price.amount").isNotEmpty());
	}

	/*
	 * Test 3 for getPricesPricetoapply().
	 * This test receives brandId = 1, productId = 35455 and date = 2020-06-14 21:00:00.
	 * This test checks that the priceList is 1 and that the price amount is not empty.
	 */
	@Test
	void getPricesPricetoapplyThirdTest() throws Exception {

		String brandId = "1";
		String productId = "35455";
		String date = "2020-06-14 21:00:00";

		mockMvc.perform(get("/prices/pricetoapply")
			.param("brandId", brandId)
			.param("productId", productId)
			.param("date", date)               
		)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("1"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.price.amount").isNotEmpty());
	}

	/*
	 * Test 4 for getPricesPricetoapply().
	 * This test receives brandId = 1, productId = 35455 and date = 2020-06-15 10:00:00.
	 * This test checks that the priceList is 3 and that the price amount is not empty.
	 */
	@Test
	void getPricesPricetoapplyFourthTest() throws Exception {

		String brandId = "1";
		String productId = "35455";
		String date = "2020-06-15 10:00:00";

		mockMvc.perform(get("/prices/pricetoapply")
			.param("brandId", brandId)
			.param("productId", productId)
			.param("date", date)               
		)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("3"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.price.amount").isNotEmpty());
	}

	/*
	 * Test 5 for getPricesPricetoapply().
	 * This test receives brandId = 1, productId = 35455 and date = 2020-06-16 21:00:00.
	 * This test checks that the priceList is 4 and that the price amount is not empty.
	 */
	@Test
	void getPricesPricetoapplyFifthTest() throws Exception {

		String brandId = "1";
		String productId = "35455";
		String date = "2020-06-16 21:00:00";

		mockMvc.perform(get("/prices/pricetoapply")
			.param("brandId", brandId)
			.param("productId", productId)
			.param("date", date)               
		)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("4"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.price.amount").isNotEmpty());
	}
}
