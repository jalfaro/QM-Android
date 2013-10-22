
package org.questionnairemanager.engine;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.questionnairemanager.engine.data.LocalDataManager;
import org.questionnairemanager.engine.utility.UnzipUtility;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class MainActivity extends Activity implements OnClickListener {

    private Button btnLoad, btnOpen;

    public static String PACKAGE_NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

    	super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		
		PACKAGE_NAME = getApplicationContext().getPackageName();
		btnLoad = (Button) findViewById(R.id.btnLoadStudios);
		btnOpen = (Button) findViewById(R.id.btnOpenNewStudio);
		btnLoad.setOnClickListener(this);
		btnOpen.setOnClickListener(this);
    }

	/* (non-Javadoc)
     * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (resultCode == RESULT_OK) {
		    switch (requestCode) {
			case FilePickerActivity.ACTION_PICKAFILE:
			    if (data.hasExtra(FilePickerActivity.EXTRA_FILE_PATH)) {
				// Get the file path
				File f = new File(data.getStringExtra(FilePickerActivity.EXTRA_FILE_PATH));
	
				UnzipUtility.unpackZip(f.getPath().substring(0, f.getPath().length() - f.getName().length()), f.getName());
				// connCD = new ConfigDataManager(this, f.getName() + "C", f.getPath().substring(0, f.getPath().length() - f.getName().length()));
	
				// Set the file path text view
				try {
				    Log.d("DEBUG", "AbsolutePath : " + f.getAbsolutePath() + ", CanonicalPath: " + f.getCanonicalPath() + ", Name : " + f.getName()
					    + ", CanonicalFile : " + f.getCanonicalFile() + ",solo path : "
					    + f.getPath().substring(0, f.getPath().length() - f.getName().length()));
				} catch (IOException e) {
				    // TODO Auto-generated catch block
				    e.printStackTrace();
				}
			    }
		    }
		}
    }

    @Override
    public void onClick(View v) {

	// TODO: Auto-generated method stub
		switch (v.getId()) {
		    case R.id.btnLoadStudios:
				Intent intentstudy = new Intent(getBaseContext(), StudyActivity.class);
				startActivity(intentstudy);
			break;
		    case R.id.btnOpenNewStudio:
				Intent intent = new Intent(getBaseContext(), FilePickerActivity.class);
				// Only make .QM files visible
				ArrayList<String> extensions = new ArrayList<String>();
				extensions.add(".QM");
				intent.putExtra(FilePickerActivity.EXTRA_ACCEPTED_FILE_EXTENSIONS, extensions);
				startActivityForResult(intent, FilePickerActivity.ACTION_PICKAFILE);
				Log.d("test", "every where");
			break;
		}
    }
}
