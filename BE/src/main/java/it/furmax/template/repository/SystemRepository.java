package it.furmax.template.repository;

import java.util.List;

import org.jboss.logging.Logger;

import it.furmax.template.model.CfgSystemParameter;
import it.furmax.template.model.CfgSystemParameter_;

public class SystemRepository extends AbstractRepository<CfgSystemParameter> {

	private static Logger log = Logger.getLogger(SystemRepository.class.getName());

	private static final String TOKEN_TIME = "TOKEN_TIME";

	public SystemRepository() {
		type = CfgSystemParameter.class;
	}

//	private Map<String, String> findParams(final List<String> paramCodes) {
//		return findInValues(CfgSystemParameter_.paramCode, paramCodes, null).stream()
//				.collect(Collectors.toMap(CfgSystemParameter::getParamCode, CfgSystemParameter::getParamValue));
//	}
//
	private String findParam(final String paramCode) {
		List<CfgSystemParameter> res = find(CfgSystemParameter_.paramCode, paramCode);
		if (res == null || res.isEmpty()) {
			log.error("findTokenTime - parameter " + paramCode + " is not set");
			return null;
		}
		return res.get(0).getParamValue();
	}

	public String getTokenTime() {
		return findParam(TOKEN_TIME);
	}

}
