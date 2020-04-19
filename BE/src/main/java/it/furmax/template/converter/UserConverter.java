package it.furmax.template.converter;

import io.swagger.model.Paginazione;
import io.swagger.model.Utente;
import io.swagger.model.UtentiPaginati;
import it.furmax.template.model.AnaUser;
import it.furmax.template.repository.PaginatedResult;

public final class UserConverter {

	public Utente toUtente(final AnaUser model) {
		if (model == null) {
			return new Utente();
		}
		Utente res = new Utente();
		res.setIdUtente(model.getId());
		res.setNomeUtente(model.getUsername());
		res.setEmail(model.getEmail());
		res.setNome(model.getFirstname());
		res.setCognome(model.getLastname());
		res.setTelefono(model.getPhone());
		res.setAbilitato(model.getEnabled());
		if (model.getLastChangePwd() != null) {
			res.setDataUltimoCambioPassword(model.getLastChangePwd().getTime());
		}
		if (model.getLastConnectTime() != null) {
			res.setDataUltimaConnessione(model.getLastConnectTime().getTime());
		}
		return res;
	}

	public UtentiPaginati toUtentiPaginati(PaginatedResult<AnaUser> model) {
		if (model == null) {
			UtentiPaginati pp = new UtentiPaginati();
			pp.setPaginazione(new Paginazione());
			return pp;
		}
		UtentiPaginati result = new UtentiPaginati();
		result.setPaginazione(new Paginazione());
		result.getPaginazione().setNumeroPagina(model.getPagination().getPageNumber());
		result.getPaginazione().setDimensionePagina(model.getPagination().getPageSize());
		result.getPaginazione().setTotaleElementi(model.getPagination().getTotalElements());
		result.getPaginazione().setTotalePagine(model.getPagination().getTotalPages());
		for (AnaUser ap : model.getData()) {
			result.getData().add(toUtente(ap));
		}
		return result;
	}

}
