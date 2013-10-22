package org.questionnairemanager.engine.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

import android.os.Environment;
import android.util.Log;

public class BackUpDBUtility {
	public static void moveDBtoSD(String name) {
		try {
	        File sd = Environment.getExternalStorageDirectory();
	        File data = Environment.getDataDirectory();

	        if (sd.canWrite()) {
	            String currentDBPath = "//data//org.questionairemanager.engine//databases//"+ name;
	            String backupDBPath = name;
	            Log.d("DEBUG", backupDBPath);
	            
	            File currentDB = new File(data, currentDBPath);
	            File backupDB = new File(sd, backupDBPath);

	            if (currentDB.exists()) {
	                FileChannel src = new FileInputStream(currentDB).getChannel();
	                FileChannel dst = new FileOutputStream(backupDB).getChannel();
	                dst.transferFrom(src, 0, src.size());
	                src.close();
	                dst.close();
	            }
	        }
	    } catch (Exception e) {
	    	Log.d("SD", "Error moviendo la db error:" + e.getMessage());
	    }
	}
	
	public static void loadDBtoAPP(String path) {
		
	}
}
