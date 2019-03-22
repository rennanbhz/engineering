package com.engineering.technicaltest.seller;

import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.engineering.technicaltest.client.Client;

/**
 * Represents a Seller
 *
 * @author Renan Mattos
 */
@Entity
public class Seller
{
	@Id @GeneratedValue private Integer sellerId;

	@Column private String name;
	
	@Column private String cpf;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Client> clients;

	public Seller()
	{
		super();
	}

	/**
	 * Constructor with some defined informations.
	 *
	 * @param id Seller identificator
	 * @param name Name of seller
	 * @param email Seller e-mail
	 */
	public Seller(Integer sellerId, String name, String cpf)
	{
		this.sellerId = sellerId;
		this.name = name;
		this.cpf = cpf;
	}

	/**
	 * Constructor with all defined informations.
	 *
	 * @param id Seller identificator
	 * @param name Name of seller
	 * @param cpf Seller CPF
	 * @param clients Clients to be associated to a seller
	 */
	public Seller(Integer sellerId, String name, String cpf, Client clients)
	{
		this.sellerId = sellerId;
		this.name = name;
		this.cpf = cpf;
		this.clients = Collections.singletonList(clients);
	}

	public Integer getSellerId()
	{
		return sellerId;
	}

	public void setSellerId(Integer sellerId)
	{
		this.sellerId = sellerId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}
	
	public List<Client> getClientList() 
	  {
	    return clients;
	  }

	public void setClientList(List<Client> clients) 
	  {
	    this.clients = clients;
	  }
}
