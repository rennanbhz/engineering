package com.engineering.technicaltest.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.engineering.technicaltest.seller.Seller;
import com.engineering.technicaltest.seller.SellerRepository;

/**
 * Class responsible for exposing Client Rest operations.
 *
 * @author Renan Mattos
 */
@RestController
public class ClientController
{
	@Autowired private ClientRepository clientRepository;
	@Autowired private SellerRepository sellerRepository;
	
	/**
	 * Creates a client in database.
	 * 
	 * @param client Information to be assigned to a new client
	 * @return Client with id filled in
	 */
	@PostMapping("/client")
	public ResponseEntity<Object> createClient(@RequestBody Client client)
	{
		Client createdClient = clientRepository.save(client);
		
		return ResponseEntity.ok(createdClient);
	}
	
	/**
	 * Gets all registered clients in the database.
	 * 
	 * @return List of registered clients
	 */
	@GetMapping("/client")
	public List<Client> searchAllClients()
	{
		List<Client> clientList = new ArrayList<>();
		
		clientRepository.findAll().forEach(client -> clientList.add(client));
		
		return clientList;
	}
	
	/**
	 * Gets the client information by its identifier
	 * 
	 * @param clientId Client identificator
	 * @return client containing the Id
	 */
	@GetMapping("/client/{clientId}")
	public ResponseEntity<Client> searchClientById(@PathVariable Integer clientId)
	{
		Optional<Client> client = clientRepository.findById(clientId);
		
		if(!client.isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(client.get());
	}
	
	/**
	 * Associates seller with clients
	 * 
	 * @param client Client to be associated 
	 * @param clientId client identificator
	 * @return status OK
	 */
	@PutMapping("/client/seller/{sellerId}")
	public ResponseEntity<Object> associateClientToSeller(@RequestBody Client client, @PathVariable Integer clientId)
	{
		Optional<Seller> seller = sellerRepository.findById(clientId);
		
		if (!seller.isPresent()) 
		{
			return ResponseEntity.notFound().build();
		}
		
		Optional<Client> clientLoad = clientRepository.findById(client.getClientId());
		
		if (!clientLoad.isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		
		if (seller.get().getClientList() == null)
		{
			seller.get().setClientList(new ArrayList<>());
		}
		
		seller.get().getClientList().add(clientLoad.get());
		sellerRepository.save(seller.get());
		
		return ResponseEntity.noContent().build();
	}
	
	/**
	 * Delete client by Id
	 * 
	 * @param id Client identificator
	 */
	@DeleteMapping("/client/{clientId}")
	public void deletClient(@PathVariable Integer clientId)
	{
		clientRepository.deleteById(clientId);
	}
}
