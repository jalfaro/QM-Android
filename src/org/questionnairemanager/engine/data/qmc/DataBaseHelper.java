
package org.questionnairemanager.engine.data.qmc;

import java.io.IOException;
import java.util.ArrayList;

import org.questionnairemanager.engine.MainActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DataBaseHelper extends SQLiteOpenHelper {

    // The Android's default system path of your application database.
    private static String DB_PATH = "/data/data/" + MainActivity.PACKAGE_NAME + "/databases/";

    private static String DB_NAME = "db.db";

    private SQLiteDatabase myDataBase;

    private final Context myContext;

    /**
     * Constructor Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * 
     * @param context
     */
    public DataBaseHelper(Context context) {

	super(context, DB_NAME, null, 1);
	this.myContext = context;
    }

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     */
    public void createDataBase() throws IOException {

	boolean dbExist = checkDataBase();

	if (dbExist) {
	    // do nothing - database already exist
	} else {

	    // By calling this method and empty database will be created into the default system path
	    // of your application so we are gonna be able to overwrite that database with our database.
	    this.getReadableDatabase();

	    try {

		copyDataBase();

	    } catch (IOException e) {

		throw new Error("Error copying database");

	    }
	}

    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * 
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase() {

	SQLiteDatabase checkDB = null;

	try {
	    String myPath = DB_PATH + DB_NAME;
	    checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

	} catch (SQLiteException e) {

	    // database does't exist yet.
	    Log.d("DEBUG", "Error open database ! " + e.getMessage());

	}

	if (checkDB != null) {

	    checkDB.close();

	}

	return checkDB != null ? true : false;
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the system folder, from where it can be accessed and handled. This is done by transfering bytestream.
     */
    private void copyDataBase() throws IOException {

	// // Open your local db as the input stream
	// InputStream myInput = myContext.getAssets().open(DB_NAME);
	//
	// // Path to the just created empty db
	// String outFileName = DB_PATH + DB_NAME;
	//
	// // Open the empty db as the output stream
	// OutputStream myOutput = new FileOutputStream(outFileName);
	//
	// // transfer bytes from the inputfile to the outputfile
	// byte[] buffer = new byte[1024];
	// int length;
	// while ((length = myInput.read(buffer)) > 0) {
	// myOutput.write(buffer, 0, length);
	// }
	//
	// // Close the streams
	// myOutput.flush();
	// myOutput.close();
	// myInput.close();

	System.out.println("salud >>>");

    }

    public void openDataBase() throws SQLException {

	// Open the database
	String myPath = DB_PATH + DB_NAME;
	myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {

	if (myDataBase != null) myDataBase.close();

	super.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // Add your public helper methods to access and get content from the database.
    // You could return cursors by doing "return myDataBase.query(....)" so it'd be easy
    // to you to create adapters for your views.

    // THIS FUNCTION SHOWS DATA FROM THE DATABASE
    public ArrayList<Study> getStudies() {

	ArrayList<Study> alStudies = new ArrayList<Study>();
	Study study;

	try {
	    // mydb = openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE, null);
	    Cursor allrows = myDataBase.rawQuery("SELECT StudyGuid, ShortName FROM Study", null);
	    System.out.println("COUNT : " + allrows.getCount());

	    // Nos aseguramos de que existe al menos un registro
	    if (allrows.moveToFirst()) {
		// Recorremos el cursor hasta que no haya mas registros
		do {
		    study = new Study();
		    study.setStudyGUID(allrows.getString(0));
		    study.setShortName(allrows.getString(1));

		    alStudies.add(study);

		}
		while (allrows.moveToNext());
	    }
	    // myDataBase.close();
	} catch (Exception e) {
	    Toast.makeText(this.myContext.getApplicationContext(), "Error encountered.", Toast.LENGTH_LONG);

	}

	return alStudies;
    }

    /**
     * Get all subjects for study
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>Aug 31, 2013</date>
     * @return all studies.
     */
    public ArrayList<SubjectStudy> getSubjects() {

	ArrayList<SubjectStudy> alSubjects = new ArrayList<SubjectStudy>();
	SubjectStudy sSubject;

	Cursor allrows = myDataBase.rawQuery("SELECT * FROM User", null);

	System.out.println("count user : " + allrows.getCount());

	if (allrows.moveToFirst()) {

	    do {
		sSubject = new SubjectStudy();
		sSubject.setUserGuid(allrows.getString(0));
		sSubject.setName(allrows.getString(1));
		sSubject.setPassword(allrows.getString(2));
		sSubject.setRoleName(allrows.getString(3));
		sSubject.setDefaultSiteID(allrows.getFloat(4));
		sSubject.setOrdinal(allrows.getFloat(5));
		sSubject.setActive(allrows.getFloat(6));

		alSubjects.add(sSubject);
	    }
	    while (allrows.moveToNext());

	}

	return alSubjects;

    }

}
