package io.swagger.model;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import javax.validation.constraints.*;
import io.swagger.annotations.*;



public class Utente   {
  
  private Long idUtente = null;
  private String nomeUtente = null;
  private String email = null;
  private String nome = null;
  private String cognome = null;
  private String telefono = null;
  private Boolean abilitato = null;
  private Long dataUltimoCambioPassword = null;
  private Long dataUltimaConnessione = null;

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("idUtente")
  public Long getIdUtente() {
    return idUtente;
  }
  public void setIdUtente(Long idUtente) {
    this.idUtente = idUtente;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("nomeUtente")
  public String getNomeUtente() {
    return nomeUtente;
  }
  public void setNomeUtente(String nomeUtente) {
    this.nomeUtente = nomeUtente;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("nome")
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("cognome")
  public String getCognome() {
    return cognome;
  }
  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("telefono")
  public String getTelefono() {
    return telefono;
  }
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  /**
   * true indica abilitato, false disabilitato
   **/
  
  @ApiModelProperty(value = "true indica abilitato, false disabilitato")
  @JsonProperty("abilitato")
  public Boolean isAbilitato() {
    return abilitato;
  }
  public void setAbilitato(Boolean abilitato) {
    this.abilitato = abilitato;
  }

  /**
   * data ultimo cambio password espressa in millisecondi
   **/
  
  @ApiModelProperty(value = "data ultimo cambio password espressa in millisecondi")
  @JsonProperty("dataUltimoCambioPassword")
  public Long getDataUltimoCambioPassword() {
    return dataUltimoCambioPassword;
  }
  public void setDataUltimoCambioPassword(Long dataUltimoCambioPassword) {
    this.dataUltimoCambioPassword = dataUltimoCambioPassword;
  }

  /**
   * data ultima connessione espressa in millisecondi
   **/
  
  @ApiModelProperty(value = "data ultima connessione espressa in millisecondi")
  @JsonProperty("dataUltimaConnessione")
  public Long getDataUltimaConnessione() {
    return dataUltimaConnessione;
  }
  public void setDataUltimaConnessione(Long dataUltimaConnessione) {
    this.dataUltimaConnessione = dataUltimaConnessione;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Utente utente = (Utente) o;
    return Objects.equals(idUtente, utente.idUtente) &&
        Objects.equals(nomeUtente, utente.nomeUtente) &&
        Objects.equals(email, utente.email) &&
        Objects.equals(nome, utente.nome) &&
        Objects.equals(cognome, utente.cognome) &&
        Objects.equals(telefono, utente.telefono) &&
        Objects.equals(abilitato, utente.abilitato) &&
        Objects.equals(dataUltimoCambioPassword, utente.dataUltimoCambioPassword) &&
        Objects.equals(dataUltimaConnessione, utente.dataUltimaConnessione);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idUtente, nomeUtente, email, nome, cognome, telefono, abilitato, dataUltimoCambioPassword, dataUltimaConnessione);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Utente {\n");
    
    sb.append("    idUtente: ").append(toIndentedString(idUtente)).append("\n");
    sb.append("    nomeUtente: ").append(toIndentedString(nomeUtente)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    cognome: ").append(toIndentedString(cognome)).append("\n");
    sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
    sb.append("    abilitato: ").append(toIndentedString(abilitato)).append("\n");
    sb.append("    dataUltimoCambioPassword: ").append(toIndentedString(dataUltimoCambioPassword)).append("\n");
    sb.append("    dataUltimaConnessione: ").append(toIndentedString(dataUltimaConnessione)).append("\n");
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

