package com.engineering.engineeringtechnicaltest.client.test;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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

import com.engineering.technicaltest.client.Client;
import com.engineering.technicaltest.client.ClientController;
import com.engineering.technicaltest.client.ClientRepository;

/**
 * Unit test to ClientController class.
 * 
 * @author Renan Mattos
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ClientController.class)
public class ClientControllerTest
{
	@Autowired private MockMvc mvc;
	
	@MockBean private ClientRepository clientRepository;

	private static final Integer CLIENT_ID = 1;
	private static final String CLIENT_EMAIL = "rennanbhz@hotmail.com";
	private static final String CLIENT_CPF = "12030065032";
	private static final Character GENDER = 'm';
	
	private Client mockClient = new Client(CLIENT_ID, CLIENT_EMAIL, CLIENT_CPF, GENDER);
	private String mockClientJson =
		      "{\"clientId\":1\",\"email\":\"joao.silva@gmail.com\",\"cpf\":\"12350030020\",\"gender\":\'m'}";
	
	@Test
	public void createClient_withValidInformation_returnCreated() throws Exception
	{
		when(clientRepository.save(Mockito.any())).thenReturn(mockClient);
		
		mvc.perform(
	            post("/client")
	                .accept(MediaType.APPLICATION_JSON)
	                .content(mockClientJson)
	                .contentType(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$.clientId", is(CLIENT_ID)));
	}
	
	@Test
	public void deleteClient_withValidInformation_returnSuccess() throws Exception
	{
		 when(clientRepository.findById(CLIENT_ID)).thenReturn(Optional.of(mockClient));
		    when(clientRepository.save(Mockito.any())).thenReturn(mockClient);

		    mvc.perform(
		            put("/client/" + CLIENT_ID)
		                .accept(MediaType.APPLICATION_JSON)
		                .content(mockClientJson)
		                .contentType(MediaType.APPLICATION_JSON))
		        .andExpect(status().isNoContent());
	}
	
	@Test
	public void searchForAllClients_withoutFilter_shouldReturClientList() throws Exception
	{
		List<Client> clientList = Collections.singletonList(mockClient);

	    when(clientRepository.findAll()).thenReturn(clientList);

	    mvc.perform(get("/client").contentType(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$", hasSize(1)))
	        .andExpect(jsonPath("$[0].clientId", is(mockClient.getClientId())));
	}
	
	@Test
	  public void searchForAllClients_filteringByClientId_shouldReturClientList() throws Exception {

	    when(clientRepository.findById(CLIENT_ID)).thenReturn(Optional.of(mockClient));

	    mvc.perform(get("/client/" + CLIENT_ID).contentType(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$.name", is(mockClient.getClientId())));
	  }
	
	@Test
	  public void deleteclient_withValidInformation_returnOKStatus() throws Exception {

	    mvc.perform(
	            delete("/client/" + CLIENT_ID)
	                .accept(MediaType.APPLICATION_JSON)
	                .content(mockClientJson)
	                .contentType(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk());
	  }
}

