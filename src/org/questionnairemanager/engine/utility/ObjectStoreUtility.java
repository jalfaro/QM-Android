package org.questionnairemanager.engine.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.questionnairemanager.engine.data.Constants;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;

public class ObjectStoreUtility {
	public static String getGUID(Context ctx) {
		String guid =UUID.randomUUID().toString();
		return guid;
	}
	public static String getDate() {
		String date=(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")).format(new Date());
		return date;
	}
	
	public static String getDevice(Context ctx) {
		String device="";
		if (!Secure.getString(ctx.getContentResolver(),Secure.ANDROID_ID).equals("")) {
			device = Secure.getString(ctx.getContentResolver(),Secure.ANDROID_ID);
		}
		if ((TelephonyManager)ctx.getSystemService(Context.TELEPHONY_SERVICE)!= null) {
			TelephonyManager tm =(TelephonyManager)ctx.getSystemService(Context.TELEPHONY_SERVICE);
			 String tmDevice, tmSerial, androidId;
			 tmDevice =  tm.getDeviceId();
			 tmSerial =  tm.getSimSerialNumber();
			 androidId = android.provider.Settings.Secure.getString(ctx.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);

			 device = tmDevice+"-"+tmSerial+"-"+androidId;
		}
		return device;
	}
	public static String getUser(Context ctx) {
		SharedPreferences p =PreferenceManager.getDefaultSharedPreferences(ctx);
		String user = p.getString(Constants.SHAREDPREFS.USER_NAME, "");
		return user;
	}
	public static String getVersion(Context ctx) {
		SharedPreferences p =PreferenceManager.getDefaultSharedPreferences(ctx);
		String version = p.getString(Constants.SHAREDPREFS.VERSION, "");
		return version;	
	}
}
