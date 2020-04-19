package it.furmax.template.converter;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import it.furmax.template.converter.JPACryptoConverter;

public final class JPACryptoConverterTest {

	private static final String TEST_VALUE = "123";
	private static final String TEST_HASH = "3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2";
	private JPACryptoConverter converter = new JPACryptoConverter();

	@Test
	public void nullConvertToDatabase() {
		assertNull(converter.convertToDatabaseColumn(null));
	}

	@Test
	public void nullConvertToEntityAttribute() {
		assertNull(converter.convertToEntityAttribute((null)));
	}

	@Test
	public void convertToDatabase() {
		assertTrue(converter.convertToDatabaseColumn(TEST_VALUE).equals(TEST_HASH));
	}

	@Test
	public void convertToEntityAttribute() {
		assertTrue(converter.convertToEntityAttribute(TEST_VALUE).equals(TEST_HASH));
	}

	@Test
	public void avoidDoubleHashConversionToDatabase() {
		assertTrue(converter.convertToDatabaseColumn(TEST_HASH).equals(TEST_HASH));
	}

	@Test
	public void avoidDoubleHashConversionToEntityAttribute() {
		assertTrue(converter.convertToEntityAttribute(TEST_HASH).equals(TEST_HASH));
	}

}
