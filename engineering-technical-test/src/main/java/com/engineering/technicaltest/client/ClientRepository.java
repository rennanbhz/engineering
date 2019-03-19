package com.engineering.technicaltest.client;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Class responsible for exposing the Client operations regarding the means of persistence.
 *
 * @author Renan Mattos
 */

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> 
{
}