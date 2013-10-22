/**
 * 
 */

package org.questionnairemanager.engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.questionnairemanager.engine.data.Constants;
import org.questionnairemanager.engine.data.LocalDataManager;
import org.questionnairemanager.engine.data.qmc.DataBaseHelper;
import org.questionnairemanager.engine.data.qmc.Study;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class StudyActivity extends Activity implements OnClickListener {
    private Spinner sStudy;
    private LocalDataManager connLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.studies_layout);
		connLocal = new LocalDataManager(this);
		Log.d("COUNT STUDY", connLocal.getStudyList().size()+"");
		if (connLocal.getStudyList().size()<=0) {
			AlertDialog.Builder dialog = new AlertDialog.Builder(this);
			dialog.setMessage(Constants.MESSAGES.NOSTUDY)
			.setCancelable(false)
			.setPositiveButton(Constants.MESSAGES.POSITIVE_BUTTON,new  DialogInterface.OnClickListener(){

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					finish();
				}}).show();
		}else {
			sStudy = (Spinner) findViewById(R.id.sStudie);
			List<String> lStudies = new ArrayList<String>();
			ArrayList<String> studyList = connLocal.getStudyList();
			Log.d("Logitud",studyList.size()+"");
			ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, studyList ); 
			sStudy.setAdapter(adapter);
		
			ArrayAdapter<String> spinner_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lStudies);
			// Anadimos el layout para el menu y se lo damos al spinner
		
			Spinner spinner = (Spinner) findViewById(R.id.sStudie);
			spinner.setAdapter(spinner_adapter);
		
			Button btnLogin = (Button) findViewById(R.id.btnLogIn);
			btnLogin.setOnClickListener(this);
		
			Button btnExit = (Button) findViewById(R.id.btnExit);
			btnExit.setOnClickListener(this);
		}
		

    }

    @Override
    public void onClick(View v) {

		switch (v.getId()) {
		    case R.id.btnLogIn:
	
			Intent intentuser = new Intent(StudyActivity.this, SubjectActivity.class);
			startActivity(intentuser);
	
			break;
	
		    case R.id.btnExit:
			break;
	
		    default:
			break;
		}

    }
}
