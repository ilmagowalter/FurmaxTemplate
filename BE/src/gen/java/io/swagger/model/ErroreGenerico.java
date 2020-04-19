package io.swagger.model;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import javax.validation.constraints.*;
import io.swagger.annotations.*;



public class ErroreGenerico   {
  
  private String codice = null;
  private String codiceErrore = null;
  private String descrizione = null;

  /**
   * codice di errore http
   **/
  
  @ApiModelProperty(value = "codice di errore http")
  @JsonProperty("codice")
  public String getCodice() {
    return codice;
  }
  public void setCodice(String codice) {
    this.codice = codice;
  }

  /**
   * codice di errore del messaggio corrispondente
   **/
  
  @ApiModelProperty(value = "codice di errore del messaggio corrispondente")
  @JsonProperty("codiceErrore")
  public String getCodiceErrore() {
    return codiceErrore;
  }
  public void setCodiceErrore(String codiceErrore) {
    this.codiceErrore = codiceErrore;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("descrizione")
  public String getDescrizione() {
    return descrizione;
  }
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErroreGenerico erroreGenerico = (ErroreGenerico) o;
    return Objects.equals(codice, erroreGenerico.codice) &&
        Objects.equals(codiceErrore, erroreGenerico.codiceErrore) &&
        Objects.equals(descrizione, erroreGenerico.descrizione);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codice, codiceErrore, descrizione);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErroreGenerico {\n");
    
    sb.append("    codice: ").append(toIndentedString(codice)).append("\n");
    sb.append("    codiceErrore: ").append(toIndentedString(codiceErrore)).append("\n");
    sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
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

