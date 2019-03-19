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
	
	@Column private String email;
	@Column private Integer cpf;
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
	 */
	public Client(Integer clientId, String email, Integer cpf, Character gender)
	{
		this.clientId = clientId;
		this.email = email;
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
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public Integer getCpf()
	{
		return cpf;
	}
	
	public void setCpf(Integer cpf)
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
