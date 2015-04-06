package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class PracticalTest01MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);
        
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment1, new TopFragment());
        fragmentTransaction.commit();

        EditText nameText = (EditText)findViewById(R.id.name);
        EditText websiteText = (EditText)findViewById(R.id.website);
/*
        if (savedInstanceState != null) {
        	String name = savedInstanceState.getString("name");
        	if (name != null) {
        		nameText.setText(name);
        	} else {
        		nameText.setText("");
        	}
        	String website = savedInstanceState.getString("website");
        	if (website != null) {
        		websiteText.setText(website);
        	} else {
        		websiteText.setText("");
        	}
        } else {
        	nameText.setText("");
        	websiteText.setText("");
        }
*/    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
      EditText name = (EditText)findViewById(R.id.name);
      EditText website = (EditText)findViewById(R.id.website);
      
      if (name.getText().toString() != null) {
    	  savedInstanceState.putString("name", name.getText().toString());
      }
      if (website.getText().toString() != null) {
    	  savedInstanceState.putString("website", website.getText().toString());
      }
    
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
    	super.onRestoreInstanceState(savedInstanceState);
    	EditText name = (EditText)findViewById(R.id.name);
        EditText website = (EditText)findViewById(R.id.website);
        
        if (savedInstanceState != null) {

        	if (savedInstanceState.getString("name") != null) {
        		name.setText(savedInstanceState.getString("name"));
        	}
        	if (savedInstanceState.getString("website") != null) {
        		website.setText(savedInstanceState.getString("website"));
        	}
        }
    }
}
