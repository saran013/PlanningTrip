package saran.android.example.PlanningTrip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Home extends Activity {

    public static DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        myDb = new DatabaseHelper(this);
    }


    public void invokeMap(View view)
    {
        Intent intent = new Intent(this, MapSearch.class);
        startActivity(intent);
    }

    public void invokeLocations(View view)
    {
        Intent intent = new Intent(this, LocationList.class);
        startActivity(intent);
    }
}
