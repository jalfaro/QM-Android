/**
 * 
 */

package org.questionnairemanager.engine.data.qmc;

import android.util.Log;

/**
 * @author Enner Escobedo C. <date>Aug 30, 2013</date> <email>enner.castillo@centrikal.com</email>
 */
public class SubjectStudy {

    private String UserGuid;
    private String Name;
    private String Password;
    private String RoleName;
    private float DefaultSiteID;
    private float Ordinal;
    private float Active;

    /**
     * @return the userGuid
     */
    public String getUserGuid() {

	return UserGuid;
    }

    /**
     * @return the name
     */
    public String getName() {

	return Name;
    }

    /**
     * @return the password
     */
    public String getPassword() {

	return Password;
    }

    /**
     * @return the roleName
     */
    public String getRoleName() {

	return RoleName;
    }

    /**
     * @return the defaultSiteID
     */
    public float getDefaultSiteID() {

	return DefaultSiteID;
    }

    /**
     * @return the ordinal
     */
    public float getOrdinal() {

	return Ordinal;
    }

    /**
     * @return the active
     */
    public float getActive() {

	return Active;
    }

    /**
     * @param userGuid the userGuid to set
     */
    public void setUserGuid(String userGuid) {

	UserGuid = userGuid;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {

	Name = name;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {

	Password = password;
    }

    /**
     * @param roleName the roleName to set
     */
    public void setRoleName(String roleName) {

	RoleName = roleName;
    }

    /**
     * @param defaultSiteID the defaultSiteID to set
     */
    public void setDefaultSiteID(float defaultSiteID) {

	DefaultSiteID = defaultSiteID;
    }

    /**
     * @param ordinal the ordinal to set
     */
    public void setOrdinal(float ordinal) {

	Ordinal = ordinal;
    }

    /**
     * @param active the active to set
     */
    public void setActive(float active) {

	Active = active;
    }

    /**
     * 
     */
    public SubjectStudy() {

    }

    /**
     * Information for subject of study.
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>Aug 30, 2013</date>
     * @param userGuid, GUID for user
     * @param name, Name user
     * @param password, Password user
     * @param roleName, Role Name
     * @param defaultSiteID, ID site
     * @param ordinal, Number position
     * @param active, is active ?
     */
    public SubjectStudy(String userGuid, String name, String password, String roleName, float defaultSiteID, float ordinal, float active) {

	UserGuid = userGuid;
	Name = name;
	Password = password;
	RoleName = roleName;
	DefaultSiteID = defaultSiteID;
	Ordinal = ordinal;
	Active = active;
    }

    /**
     * Show information for subject study
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>Aug 30, 2013</date>
     */
    public void show() {

	Log.i("SUBJECT", "GUID " + this.getUserGuid());
	Log.i("SUBJECT", "SHORTNAME " + this.getName());
	Log.i("SUBJECT", "PASSWORD " + this.getPassword());
	Log.i("SUBJECT", "ROLENAME " + this.getRoleName());
	Log.i("SUBJECT", "DEFAULT ID " + this.getDefaultSiteID());
	Log.i("SUBJECT", "ORDINAL " + this.getOrdinal());
	Log.i("SUBJECT", "ACTIVE " + this.getActive());

    }
}
