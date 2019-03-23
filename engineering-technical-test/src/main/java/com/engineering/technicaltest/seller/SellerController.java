package com.engineering.technicaltest.seller;

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

import com.engineering.technicaltest.util.ValidatorUtils;

/**
 * Class responsible for exposing the Seller Rest operations.
 * 
 * @author Renan Mattos
 */
@RestController
public class SellerController
{
	@Autowired
	private SellerRepository sellerRepository;

	/**
	 * Generate a seller in database.
	 * 
	 * @param seller Seller Information to be assigned to a new seller
	 * @return Seller with id filled in
	 */
	@PostMapping("/seller")
	public ResponseEntity<Object> createSeller(@RequestBody Seller seller)
	{
		Seller createdSeller = sellerRepository.save(seller);
		
		try
		{
			if (ValidatorUtils.isValidCPF(createdSeller.getCpf()) & ValidatorUtils.isValidName(createdSeller.getName()));
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return ResponseEntity.ok(createdSeller);
	}

	/**
	 * updates a Seller information.
	 * 
	 * @param seller   Information to update
	 * @param sellerId identifier of seller to be updated
	 * @return Status Ok
	 */
	@PutMapping("/seller/{sellerId}")
	public ResponseEntity<Object> updateSeller(@RequestBody Seller seller, @PathVariable Integer sellerId)
	{
		Optional<Seller> sellerLoad = sellerRepository.findById(sellerId);

		if (!sellerLoad.isPresent())
		{
			return ResponseEntity.notFound().build();
		}

		seller.setSellerId(sellerId);

		sellerRepository.save(seller);

		return ResponseEntity.ok().build();
	}

	/**
	 * Gets all registered sellers in the database.
	 * 
	 * @return List of registered sellers
	 */
	@GetMapping("/seller")
	public List<Seller> searchAllSellers()
	{
		List<Seller> sellerList = new ArrayList<>();

		sellerRepository.findAll().forEach(seller -> sellerList.add(seller));

		return sellerList;
	}

	/**
	 * Gets the seller information by its identifier
	 * 
	 * @param sellerId Seller identificator
	 * @return Seller containing the seller Id
	 */
	@GetMapping("/seller/{sellerId}")
	public ResponseEntity<Seller> searchSellerById(@PathVariable Integer sellerId)
	{
		Optional<Seller> seller = sellerRepository.findById(sellerId);

		if (!seller.isPresent())
		{
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(seller.get());
	}

	/**
	 * Delete seller by Id
	 * 
	 * @param sellerId
	 */
	@DeleteMapping("/seller/{sellerId}")
	public void deleteSeller(@PathVariable Integer sellerId)
	{
		sellerRepository.deleteById(sellerId);
	}
}
