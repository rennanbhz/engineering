package com.engineering.technicaltest.client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/** 
 * Represents a Client
 *
 * @author Renan Mattos
 */
@Entity
public class Client
{
	@Id @GeneratedValue private Integer clientId;
	
	@Column private String name;
	@Column private String cpf;
	@Column private Character gender;
	
	public Client()
	{
		super();
	}

	/**
	 * Constructor with some defined informations.
	 *
	 * @param clientId Client identificator
	 * @param name Name of client
	 * @param email Client e-mail
	 * @param gender Gender of client
	 */
	public Client(Integer clientId, String name, String cpf, Character gender)
	{
		this.clientId = clientId;
		this.name = name;
		this.cpf = cpf;
		this.gender = gender;
	}

	public Integer getClientId()
	{
		return clientId;
	}
	
	public void setClientId(Integer id)
	{
		this.clientId = id;
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
	
	public Character getGender()
	{
		return gender;
	}
	
	public void setGender(Character gender)
	{
		this.gender = gender;
	}
}
