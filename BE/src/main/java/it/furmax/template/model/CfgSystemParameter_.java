package it.furmax.template.model;

import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2018-10-22T14:37:09.811+0200")
@StaticMetamodel(CfgSystemParameter.class)
public class CfgSystemParameter_ {
	public static volatile SingularAttribute<CfgSystemParameter, Long> id;
	public static volatile SingularAttribute<CfgSystemParameter, String> paramCode;
	public static volatile SingularAttribute<CfgSystemParameter, String> paramValue;
	public static volatile SingularAttribute<CfgSystemParameter, String> description;
	public static volatile SingularAttribute<CfgSystemParameter, Long> version;
	public static volatile SingularAttribute<CfgSystemParameter, Timestamp> insertTime;
	public static volatile SingularAttribute<CfgSystemParameter, Timestamp> updateTime;
	public static volatile SingularAttribute<CfgSystemParameter, Long> idUserInsert;
	public static volatile SingularAttribute<CfgSystemParameter, Long> idUserUpdate;
}
