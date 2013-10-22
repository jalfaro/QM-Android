
package org.questionnairemanager.engine;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SubjectActivity extends Activity implements OnClickListener {

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.subject_layout);

	Button btnNext = (Button) findViewById(R.id.btnNextsa);
	btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

	switch (v.getId()) {
	    case R.id.btnNextsa:
		// Intent intentuser = new Intent(SubjectActivity.this, SubjectActivity.class);
		// startActivity(intentuser);

		break;
	    case R.id.btnBacksa:
		break;
	    default:
		break;
	}
    }
}
