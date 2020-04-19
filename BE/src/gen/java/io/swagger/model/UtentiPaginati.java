package io.swagger.model;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Paginazione;
import io.swagger.model.Utente;
import java.util.List;
import javax.validation.constraints.*;
import io.swagger.annotations.*;



public class UtentiPaginati   {
  
  private List<Utente> data = new ArrayList<Utente>();
  private Paginazione paginazione = null;

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("data")
  public List<Utente> getData() {
    return data;
  }
  public void setData(List<Utente> data) {
    this.data = data;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("paginazione")
  public Paginazione getPaginazione() {
    return paginazione;
  }
  public void setPaginazione(Paginazione paginazione) {
    this.paginazione = paginazione;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UtentiPaginati utentiPaginati = (UtentiPaginati) o;
    return Objects.equals(data, utentiPaginati.data) &&
        Objects.equals(paginazione, utentiPaginati.paginazione);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, paginazione);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UtentiPaginati {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    paginazione: ").append(toIndentedString(paginazione)).append("\n");
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

