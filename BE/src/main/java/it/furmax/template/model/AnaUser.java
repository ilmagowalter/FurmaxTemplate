package it.furmax.template.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import it.furmax.template.converter.JPACryptoConverter;

/**
 * The persistent class for the ana_users database table.
 * 
 */
@Entity
@Table(name = "ana_users")
@NamedQuery(name = "AnaUser.findAll", query = "SELECT a FROM AnaUser a")
public class AnaUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ANA_USERS_ID_GENERATOR", sequenceName = "SEQ_ANA_USERS", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANA_USERS_ID_GENERATOR")
	private Long id;

	private String username;

	private String email;

	private String firstname;

	private String lastname;

	private String phone;

	// NOTE: be aware, password are hashed, see related class
	@Convert(converter = JPACryptoConverter.class)
	private String password;

	private Boolean enabled;

	@Column(name = "last_change_pwd")
	private Timestamp lastChangePwd;

	@Column(name = "last_connect_time")
	private Timestamp lastConnectTime;

	private Long version;

	@Column(name = "insert_time")
	private Timestamp insertTime;

	@Column(name = "update_time")
	private Timestamp updateTime;

	@Column(name = "id_user_insert")
	private Long idUserInsert;

	@Column(name = "id_user_update")
	private Long idUserUpdate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Timestamp getLastChangePwd() {
		return lastChangePwd;
	}

	public void setLastChangePwd(Timestamp lastChangePwd) {
		this.lastChangePwd = lastChangePwd;
	}

	public Timestamp getLastConnectTime() {
		return lastConnectTime;
	}

	public void setLastConnectTime(Timestamp lastConnectTime) {
		this.lastConnectTime = lastConnectTime;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Timestamp getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Long getIdUserInsert() {
		return idUserInsert;
	}

	public void setIdUserInsert(Long idUserInsert) {
		this.idUserInsert = idUserInsert;
	}

	public Long getIdUserUpdate() {
		return idUserUpdate;
	}

	public void setIdUserUpdate(Long idUserUpdate) {
		this.idUserUpdate = idUserUpdate;
	}

}