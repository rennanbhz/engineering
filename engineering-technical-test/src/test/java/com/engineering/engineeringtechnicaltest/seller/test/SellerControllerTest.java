package com.engineering.engineeringtechnicaltest.seller.test;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.engineering.technicaltest.client.Client;
import com.engineering.technicaltest.client.ClientRepository;
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
	@MockBean private ClientRepository clientRepository;
	

	private static final Integer CLIENT_ID = 1;
	private static final String CLIENT_EMAIL = "rennanbhz@hotmail.com";
	private static final String CLIENT_CPF = "12030065032";
	
	private static final Integer SELLER_ID = 10;
	private static final String SELLER_NAME = "João_da_Silva";
	private static final String SELLER_CPF = "13030060022";
	
	private Client mockClient = new Client(CLIENT_ID, CLIENT_EMAIL, CLIENT_CPF, 'm');
	private Seller mockSeller = new Seller(SELLER_ID, SELLER_NAME, SELLER_CPF);
	
}
	

