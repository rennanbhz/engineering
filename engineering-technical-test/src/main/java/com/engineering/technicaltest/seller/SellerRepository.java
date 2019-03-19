package com.engineering.technicaltest.seller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Class aresponsible for exposing the operations of the Seller referring to the means of persistence.
 * 
 * @author Renan
 */
@Repository
public interface SellerRepository extends CrudRepository<Seller, Integer>
{
}
