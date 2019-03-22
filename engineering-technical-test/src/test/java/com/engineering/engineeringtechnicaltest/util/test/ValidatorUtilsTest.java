package com.engineering.engineeringtechnicaltest.util.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import com.engineering.technicaltest.util.ValidatorUtils;

import java.security.InvalidParameterException;

/**
 * Unit tests of ValidatorUtil class
 * 
 * @author Renan
 */
public class ValidatorUtilsTest
{
	
	private static final String NAME = "José Ferreira Filho";
	private static final String CPF = "400.500.600.20";
	private static final String INVALID_NAME = "José";
	private static final String INVALID_CPF = "1306003552ade4";

	@Test(expected = InvalidParameterException.class)
	public void entity_withInvalidCPFValue_shouldReturnError()
	{
		ValidatorUtils.isValidCPF(INVALID_CPF);
	}

	@Test(expected = InvalidParameterException.class)
	public void entity_withInvalidName_shouldReturnError()
	{
		ValidatorUtils.isValidCPF(INVALID_NAME);
	}

	@Test
	public void entity_withValidCPF_shouldReturnSuccess()
	{
		boolean cpf = ValidatorUtils.isValidCPF((CPF));
		assertTrue(cpf);
	}

	@Test
	public void entity_withValidName_shouldReturnSuccess()
	{
		boolean name = ValidatorUtils.isValidName(NAME);
		assertTrue(name);
	}
}
