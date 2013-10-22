
package org.questionnairemanager.engine.data.qmc;

import android.util.Log;

public class Study {

    // private String study_id;
    private String shortname;
    // private String name;
    // private String version;
    private String studyGUID;

    /**
     * @return the studyGUID
     */
    public String getStudyGUID() {

	return studyGUID;
    }

    /**
     * @param studyGUID the studyGUID to set
     */
    public void setStudyGUID(String studyGUID) {

	this.studyGUID = studyGUID;
    }

    /**
     * @return the version
     */
    // public String getVersion() {
    //
    // return version;
    // }

    /**
     * @param version the version to set
     */
    // public void setVersion(String version) {
    //
    // this.version = version;
    // }

    /**
     * @return the study_id
     */
    // public String getStudy_id() {
    //
    // return study_id;
    // }

    /**
     * @return the shortname
     */
    public String getShortName() {

	return shortname;
    }

    /**
     * @return the name
     */
    // public String getName() {
    //
    // return name;
    // }

    /**
     * @param study_id the study_id to set
     */
    // public void setStudy_id(String study_id) {
    //
    // this.study_id = study_id;
    // }

    /**
     * @param shortname the shortname to set
     */
    public void setShortName(String shortname) {

	this.shortname = shortname;
    }

    /**
     * @param name the name to set
     */
    // public void setName(String name) {
    //
    // this.name = name;
    // }

    /**
     * Constructor class
     * 
     * @param study_id
     * @param shortname
     * @param name
     */
    public Study(String study_id, String shortname, String name) {

	// this.study_id = study_id;
	this.shortname = shortname;
	// this.name = name;
    }

    /**
     * Constructor class
     */
    public Study() {

    }

    /**
     * Show information for study
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>Aug 30, 2013</date>
     */
    public void show() {

	Log.i("STUDY", "GUID " + this.getStudyGUID());
	Log.i("STUDY", "SHORTNAME " + this.getShortName());
    }

}
