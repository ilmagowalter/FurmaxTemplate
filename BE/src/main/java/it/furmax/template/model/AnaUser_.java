package it.furmax.template.model;

import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2019-03-04T14:55:02.769+0100")
@StaticMetamodel(AnaUser.class)
public class AnaUser_ {
	public static volatile SingularAttribute<AnaUser, Long> id;
	public static volatile SingularAttribute<AnaUser, String> username;
	public static volatile SingularAttribute<AnaUser, String> email;
	public static volatile SingularAttribute<AnaUser, String> firstname;
	public static volatile SingularAttribute<AnaUser, String> lastname;
	public static volatile SingularAttribute<AnaUser, String> phone;
	public static volatile SingularAttribute<AnaUser, String> password;
	public static volatile SingularAttribute<AnaUser, Boolean> enabled;
	public static volatile SingularAttribute<AnaUser, Timestamp> lastChangePwd;
	public static volatile SingularAttribute<AnaUser, Timestamp> lastConnectTime;
	public static volatile SingularAttribute<AnaUser, Long> version;
	public static volatile SingularAttribute<AnaUser, Timestamp> insertTime;
	public static volatile SingularAttribute<AnaUser, Timestamp> updateTime;
	public static volatile SingularAttribute<AnaUser, Long> idUserInsert;
	public static volatile SingularAttribute<AnaUser, Long> idUserUpdate;
}
