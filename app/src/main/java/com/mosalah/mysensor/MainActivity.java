package com.mosalah.mysensor;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void getsensor(View view) {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        TextView txt=findViewById(R.id.txt);
        if (sensorManager!=null){
            List<Sensor> list = sensorManager.getSensorList(Sensor.TYPE_ALL);
            for (int i = 1; i < list.size(); i++) {
                txt.append("\n" + "sensor name: "+list.get(i).getName() + "\n" +
                       "sensor vendor : "+ list.get(i).getVendor() + "\n"+
                        "sensor version : "+ list.get(i).getVersion()+"\n\n");
            }
        }


    }
}
