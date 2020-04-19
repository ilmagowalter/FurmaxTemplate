package io.swagger.model;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import javax.validation.constraints.*;
import io.swagger.annotations.*;



public class Paginazione   {
  
  private Long dimensionePagina = null;
  private Long numeroPagina = null;
  private Long totalePagine = null;
  private Long totaleElementi = null;

  /**
   * dimensione della pagina di risultati
   **/
  
  @ApiModelProperty(value = "dimensione della pagina di risultati")
  @JsonProperty("dimensionePagina")
  public Long getDimensionePagina() {
    return dimensionePagina;
  }
  public void setDimensionePagina(Long dimensionePagina) {
    this.dimensionePagina = dimensionePagina;
  }

  /**
   * numero della pagina
   **/
  
  @ApiModelProperty(value = "numero della pagina")
  @JsonProperty("numeroPagina")
  public Long getNumeroPagina() {
    return numeroPagina;
  }
  public void setNumeroPagina(Long numeroPagina) {
    this.numeroPagina = numeroPagina;
  }

  /**
   * numero totale delle pagine
   **/
  
  @ApiModelProperty(value = "numero totale delle pagine")
  @JsonProperty("totalePagine")
  public Long getTotalePagine() {
    return totalePagine;
  }
  public void setTotalePagine(Long totalePagine) {
    this.totalePagine = totalePagine;
  }

  /**
   * numero totale degli elemtni
   **/
  
  @ApiModelProperty(value = "numero totale degli elemtni")
  @JsonProperty("totaleElementi")
  public Long getTotaleElementi() {
    return totaleElementi;
  }
  public void setTotaleElementi(Long totaleElementi) {
    this.totaleElementi = totaleElementi;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Paginazione paginazione = (Paginazione) o;
    return Objects.equals(dimensionePagina, paginazione.dimensionePagina) &&
        Objects.equals(numeroPagina, paginazione.numeroPagina) &&
        Objects.equals(totalePagine, paginazione.totalePagine) &&
        Objects.equals(totaleElementi, paginazione.totaleElementi);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dimensionePagina, numeroPagina, totalePagine, totaleElementi);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Paginazione {\n");
    
    sb.append("    dimensionePagina: ").append(toIndentedString(dimensionePagina)).append("\n");
    sb.append("    numeroPagina: ").append(toIndentedString(numeroPagina)).append("\n");
    sb.append("    totalePagine: ").append(toIndentedString(totalePagine)).append("\n");
    sb.append("    totaleElementi: ").append(toIndentedString(totaleElementi)).append("\n");
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

