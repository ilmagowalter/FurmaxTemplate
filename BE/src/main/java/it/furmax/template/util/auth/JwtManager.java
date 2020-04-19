package it.furmax.template.util.auth;

import java.io.File;
import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;

import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

import org.jboss.logging.Logger;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.RSASSASigner;

import it.furmax.template.SystemConstants;

@ApplicationScoped
public class JwtManager {

	private static Logger log = Logger.getLogger(JwtManager.class.getName());
	private static final PrivateKey privateKey;
	private static final String CLAIM_ROLES = "groups";
	private static final String ISSUER = "chiave-jwt-issuer";
	private static final String AUDIENCE = "jwt-audience";

	static {
		char[] password = "secret".toCharArray();
		String alias = "alias";
		PrivateKey pk = null;
		String keyPath = ".." + File.separator + "standalone" + File.separator + "configuration" + File.separator
				+ "chiave.jwt.keystore";
		System.out.println("KeyPath=" + keyPath);
		if (!SystemConstants.JWT_KEYSTORE_DIR.isEmpty()) {
			keyPath = SystemConstants.JWT_KEYSTORE_DIR;
		}
		try (FileInputStream fis = new FileInputStream(keyPath);) {
			KeyStore ks = KeyStore.getInstance("JKS");
			log.debug(keyPath);
			ks.load(fis, password);
			Key key = ks.getKey(alias, password);
			if (key instanceof PrivateKey) {
				pk = (PrivateKey) key;
			}
		} catch (Exception e) {
			log.error("Error during JwtManager init", e);
		}
		privateKey = pk;
	}

	public String createJwt(final String id, final String[] roles, final int tokenValidityInSeconds)
			throws JOSEException {
		JWSSigner signer = new RSASSASigner(privateKey);
		JsonArrayBuilder rolesBuilder = Json.createArrayBuilder();
		for (String role : roles) {
			rolesBuilder.add(role);
		}
		// note: exp is number of seconds from start of unix era, see JWT RFC (7519)
		JsonObjectBuilder claimsBuilder = Json.createObjectBuilder().add("sub", id).add("iss", ISSUER)
				.add("aud", AUDIENCE).add(CLAIM_ROLES, rolesBuilder.build())
				.add("exp", ((System.currentTimeMillis() / 1000) + tokenValidityInSeconds));

		JWSObject jwsObject = new JWSObject(
				new JWSHeader.Builder(JWSAlgorithm.RS256).type(new JOSEObjectType("jwt")).build(),
				new Payload(claimsBuilder.build().toString()));

		jwsObject.sign(signer);

		return jwsObject.serialize();
	}
}
