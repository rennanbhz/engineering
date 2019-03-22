package com.engineering.technicaltest.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class responsible for validate CPF and name.
 *
 * @author Renan Mattos
 */
public class ValidatorUtils
{
	/**
	 * This method handles the validation of cpf formatting.
	 * 
	 * @param cpf
	 * @return cpf CPF number
	 */
	public static boolean isValidCPF(String cpf)
	{
		if (cpf.isEmpty())
		{
			return false;
		}

		Pattern pattern = Pattern.compile("[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}-?[0-9]{2}");
		Matcher matcher = pattern.matcher(cpf);

		return matcher.matches();
	}
	
	/**
	 * This method handles the validation of name formatting.
	 * 
	 * @param name
	 * @return cpf Name of client or seller
	 */
	public static boolean isValidName(String name)
	{
		if(name.isEmpty()) 
		{
			return false;
		}
		Pattern pattern = Pattern.compile(("[A-Z][a-z]{5,50}"));
		Matcher matcher = pattern.matcher(name);
		
		return matcher.matches();
	}
}