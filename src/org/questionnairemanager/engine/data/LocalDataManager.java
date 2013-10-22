
package org.questionnairemanager.engine.data;

import java.util.ArrayList;

import org.questionnairemanager.engine.data.qmc.Study;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class LocalDataManager {

    public static final String DB_LS_NAME = "locals";
    public static final int DB_LS_VER = 1;

    public static final String TBL_STDY = "Study";
    public static final String FLD_STD_ID = "study_id";
    public static final String FLD_STD_SHRNAME = "shortname";
    public static final String FLD_STD_NAME = "name";

    public Context ctx;
    public LocalDataHelper conn;

    public LocalDataManager(Context ctx) {

	this.ctx = ctx;
	conn = new LocalDataHelper(ctx);
    }
    
    public void insertStudy(String id, String shortname, String name) {

	SQLiteDatabase db = conn.getWritableDatabase();
	String insertQuery = "INSERT INTO " + TBL_STDY + "(" + FLD_STD_ID + "," + FLD_STD_NAME + "," + FLD_STD_SHRNAME + ") VALUES " + "('" + id + "','" + name
		+ "','" + shortname + "')";
	db.execSQL(insertQuery);
    }

    public ArrayList<Study> getStudy() {
		ArrayList<Study> array = new ArrayList<Study>();
		Study temp;
		SQLiteDatabase db = conn.getReadableDatabase();
		Cursor c;
		String selectQuery = "SELECT " + FLD_STD_ID + "," + FLD_STD_NAME + "," + FLD_STD_SHRNAME + " FROM " + TBL_STDY;
		c = db.rawQuery(selectQuery, null);
		c.moveToFirst();
		if (c.getCount() > 0) {
		    while (!c.isAfterLast()) {
			temp = new Study();
			temp.setShortName(c.getString(c.getColumnIndex(FLD_STD_SHRNAME)));
			temp.setStudyGUID(c.getString(c.getColumnIndex(FLD_STD_ID)));
			array.add(temp);
			c.moveToNext();
		    }
		}
		return array;
	   }
    public ArrayList<String> getStudyList() {
    	ArrayList<String> array = new ArrayList<String>();
    	String temp;
    	SQLiteDatabase db = conn.getReadableDatabase();
    	Cursor c;
    	String selectQuery = "SELECT " + FLD_STD_ID + "," + FLD_STD_NAME + "," + FLD_STD_SHRNAME + " FROM " + TBL_STDY;
    	c = db.rawQuery(selectQuery, null);
		c.moveToFirst();
		if (c.getCount() > 0) {
		    while (!c.isAfterLast()) {
		    	temp= c.getString(c.getColumnIndex(FLD_STD_SHRNAME));
		    	array.add(temp);
		    	c.moveToNext();
		    }
		}
		return array;
    }
}
