package org.questionnairemanager.engine.data;

public class Constants {
	public static class SHAREDPREFS {
		public static final String USER_NAME = "user";
		public static final String VERSION = "version";
		public static final String CURRENT_GUID = "current_guid";
	}
	public static class DB {
		public static final String DBNAMED = ".QMD";
		public static final String DBNAMEC = ".QMC";
		public static final int DBVER = 1;
	}
	
	public static class STORE {
		public static final int FORDEL_NO = 0;
		public static final int FORDEL_YES = 1;
		public static final int COMP_NO = 0;
		public static final int COMP_YES = 1;
	}
	
	public static class TEXT {
		public static final String ISNOTSD = "There is not an SD Card present";
	}
	
	public static class MESSAGES {
		public static final String NOSTUDY ="There is not studies in this device!";
		public static final String POSITIVE_BUTTON = "Accept";
	}
}
