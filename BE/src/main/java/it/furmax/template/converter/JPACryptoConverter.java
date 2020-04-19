package it.furmax.template.converter;

import java.nio.charset.StandardCharsets;

import javax.persistence.AttributeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.hash.Hashing;

public class JPACryptoConverter implements AttributeConverter<String, String> {

	static Logger logger = LoggerFactory.getLogger(JPACryptoConverter.class);

	@Override
	public String convertToDatabaseColumn(String sensitive) {
		if (sensitive == null) {
			return null;
		}
		if (sensitive.length() < 128) {
			return Hashing.sha512().hashString(sensitive, StandardCharsets.UTF_8).toString();
		}
		return sensitive;
	}

	@Override
	public String convertToEntityAttribute(String sensitive) {
		if (sensitive == null) {
			return null;
		}
		if (sensitive.length() < 128) {
			return Hashing.sha512().hashString(sensitive, StandardCharsets.UTF_8).toString();
		}
		return sensitive;
	}
}