package it.furmax.template.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the cfg_system_messages database table.
 * 
 */
@Entity
@Table(name = "cfg_system_messages")
@NamedQuery(name = "CfgSystemMessage.findAll", query = "SELECT c FROM CfgSystemMessage c")
public class CfgSystemMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CFG_SYSTEM_MESSAGES_ID_GENERATOR", sequenceName = "SEQ_CFG_SYSTEM_MESSAGES")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CFG_SYSTEM_MESSAGES_ID_GENERATOR")
	private Long id;

	private String code;

	private String message;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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