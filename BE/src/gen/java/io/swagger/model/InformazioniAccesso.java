package io.swagger.model;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Utente;
import javax.validation.constraints.*;
import io.swagger.annotations.*;



public class InformazioniAccesso   {
  
  private String tipoToken = null;
  private Long scadenza = null;
  private String token = null;
  private Utente utente = null;

  /**
   * descrive la tipologia di token, es. Bearer
   **/
  
  @ApiModelProperty(value = "descrive la tipologia di token, es. Bearer")
  @JsonProperty("tipoToken")
  public String getTipoToken() {
    return tipoToken;
  }
  public void setTipoToken(String tipoToken) {
    this.tipoToken = tipoToken;
  }

  /**
   * tempo di scadenza del token, in minuti
   **/
  
  @ApiModelProperty(value = "tempo di scadenza del token, in minuti")
  @JsonProperty("scadenza")
  public Long getScadenza() {
    return scadenza;
  }
  public void setScadenza(Long scadenza) {
    this.scadenza = scadenza;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("token")
  public String getToken() {
    return token;
  }
  public void setToken(String token) {
    this.token = token;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("utente")
  public Utente getUtente() {
    return utente;
  }
  public void setUtente(Utente utente) {
    this.utente = utente;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InformazioniAccesso informazioniAccesso = (InformazioniAccesso) o;
    return Objects.equals(tipoToken, informazioniAccesso.tipoToken) &&
        Objects.equals(scadenza, informazioniAccesso.scadenza) &&
        Objects.equals(token, informazioniAccesso.token) &&
        Objects.equals(utente, informazioniAccesso.utente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tipoToken, scadenza, token, utente);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InformazioniAccesso {\n");
    
    sb.append("    tipoToken: ").append(toIndentedString(tipoToken)).append("\n");
    sb.append("    scadenza: ").append(toIndentedString(scadenza)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    utente: ").append(toIndentedString(utente)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

