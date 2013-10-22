package org.questionnairemanager.engine.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class LocalDataHelper extends SQLiteOpenHelper {

	public LocalDataHelper(Context context) {
		super(context, LocalDataManager.DB_LS_NAME, null, LocalDataManager.DB_LS_VER);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String createString = "CREATE TABLE " + LocalDataManager.TBL_STDY + " (" + LocalDataManager.FLD_STD_ID + " TEXT PRIMARY KEY," +
		LocalDataManager.FLD_STD_NAME + " TEXT," + LocalDataManager.FLD_STD_SHRNAME + " TEXT)";
		db.execSQL(createString);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
