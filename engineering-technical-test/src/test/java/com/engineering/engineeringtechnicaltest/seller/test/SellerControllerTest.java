package com.engineering.engineeringtechnicaltest.seller.test;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.engineering.technicaltest.seller.Seller;
import com.engineering.technicaltest.seller.SellerController;
import com.engineering.technicaltest.seller.SellerRepository;

/**
 * Unit test to SellerController class.
 * 
 * @author Renan Mattos
 */
@RunWith(SpringRunner.class)
@WebMvcTest(SellerController.class)
public class SellerControllerTest
{
	@Autowired private MockMvc mvc;
	
	@MockBean private SellerRepository sellerRepository;
	
	private static final Integer SELLER_ID = 10;
	private static final String SELLER_NAME = "João_da_Silva";
	private static final String SELLER_CPF = "130.300.600.22";
	
	private Seller mockSeller = new Seller(SELLER_ID, SELLER_NAME, SELLER_CPF);
	private String mockSellerJson = "{\"sellerId\":1\",\"name\":\"renan\",\"cpf\":\"12350030020\"}";
		     
	
	  @Test
	  public void createSeller_withValidInformation_returnCreated() throws Exception {

	    when(sellerRepository.save(Mockito.any())).thenReturn(mockSeller);

	    mvc.perform(
	            post("/seller")
	                .accept(MediaType.APPLICATION_JSON)
	                .content(mockSellerJson)
	                .contentType(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$.id", is(SELLER_ID)));
	  }

	  @Test
	  public void updateSeller_withValidInformation_returnOKStatus() throws Exception {

	    when(sellerRepository.findById(SELLER_ID)).thenReturn(Optional.of(mockSeller));
	    when(sellerRepository.save(Mockito.any())).thenReturn(mockSeller);

	    mvc.perform(
	            put("/seller/" + SELLER_ID)
	                .accept(MediaType.APPLICATION_JSON)
	                .content(mockSellerJson)
	                .contentType(MediaType.APPLICATION_JSON))
	        .andExpect(status().isNoContent());
	  }

	  @Test
	  public void searchForAllSellers_withoutFilter_returnListOfSellers() throws Exception {
	    List<Seller> sellerLIst = Collections.singletonList(mockSeller);

	    when(sellerRepository.findAll()).thenReturn(sellerLIst);

	    mvc.perform(get("/seller").contentType(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$", hasSize(1)))
	        .andExpect(jsonPath("$[0].id", is(mockSeller.getSellerId())));
	  }

	  @Test
	  public void searchForAllSellers_withFilter_returnListOfSellers() throws Exception {

	    when(sellerRepository.findById(SELLER_ID)).thenReturn(Optional.of(mockSeller));

	    mvc.perform(get("/seller/" + SELLER_ID).contentType(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$.id", is(mockSeller.getName())));
	  }

	  @Test
	  public void deleteSeller_withValidInformation_returnOKStatus() throws Exception {

	    mvc.perform(
	            delete("/seller/" + SELLER_ID)
	                .accept(MediaType.APPLICATION_JSON)
	                .content(mockSellerJson)
	                .contentType(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk());
	  }
}
