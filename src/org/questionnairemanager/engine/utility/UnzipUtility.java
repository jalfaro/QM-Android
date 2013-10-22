
package org.questionnairemanager.engine.utility;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.questionnairemanager.engine.MainActivity;

import android.util.Log;

public class UnzipUtility {

    public static boolean unpackZip(String path, String file) {

	String pathZip = new String();

	InputStream is;
	ZipInputStream zis;
	String filename = "";
	try {

	    is = new FileInputStream(path + file);
	    zis = new ZipInputStream(new BufferedInputStream(is));
	    ZipEntry ze;
	    byte[] buffer = new byte[1024];
	    int count;

	    while ((ze = zis.getNextEntry()) != null) {
		// zapis do souboru
		filename = ze.getName();

		pathZip = "//data/data/" + MainActivity.PACKAGE_NAME + "/databases/";
		Log.d("DEBUG", "CONTENT " + filename);

		// Need to create directories if not exists, or
		// it will generate an Exception...
		if (ze.isDirectory()) {
		    File fmd = new File(pathZip);
		    fmd.mkdirs();
		    continue;
		}

		FileOutputStream fout = new FileOutputStream(pathZip + filename);
		Log.d("DEBUG", filename + " ----- " + path + " --- " + pathZip);
		// cteni zipu a zapis
		while ((count = zis.read(buffer)) != -1) {
		    fout.write(buffer, 0, count);
		}

		fout.close();

		/**
		 * Name of file with extension QMC
		 */
		File nameFile = new File(pathZip, filename);

		/**
		 * Delete next string "QMC"
		 */
		String newNameFile = filename.substring(0, filename.length() - 3);

		/**
		 * Concat extension "db"
		 */
		newNameFile += "db";
		// Compruebas que si lo borro

		/**
		 * Generate new file with extension .db
		 */
		File renameFile = new File(pathZip, newNameFile);

		/**
		 * Rename file origin to file with extension .db
		 */
		nameFile.renameTo(renameFile);

		zis.closeEntry();
	    }

	    zis.close();

	} catch (IOException e) {
	    e.printStackTrace();
	    Log.d("DEBUG", e.getMessage() + "  <<ERROR EN DESCOMPRIMIR ZIP");
	    return false;
	}

	return true;
    }
}
