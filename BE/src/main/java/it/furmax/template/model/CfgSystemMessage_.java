package it.furmax.template.model;

import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2018-10-22T14:37:09.808+0200")
@StaticMetamodel(CfgSystemMessage.class)
public class CfgSystemMessage_ {
	public static volatile SingularAttribute<CfgSystemMessage, Long> id;
	public static volatile SingularAttribute<CfgSystemMessage, String> code;
	public static volatile SingularAttribute<CfgSystemMessage, String> message;
	public static volatile SingularAttribute<CfgSystemMessage, Long> version;
	public static volatile SingularAttribute<CfgSystemMessage, Timestamp> insertTime;
	public static volatile SingularAttribute<CfgSystemMessage, Timestamp> updateTime;
	public static volatile SingularAttribute<CfgSystemMessage, Long> idUserInsert;
	public static volatile SingularAttribute<CfgSystemMessage, Long> idUserUpdate;
}
