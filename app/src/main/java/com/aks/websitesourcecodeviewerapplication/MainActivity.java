package com.aks.websitesourcecodeviewerapplication;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ConnectInternetTask c1;
    static TextView myText;
    private Spinner sp;
    EditText edt;
    String edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=(Spinner)findViewById(R.id.spinner);
        edt=(EditText)findViewById(R.id.editText);
        myText = (TextView)findViewById(R.id.MyResult);
    }

    public boolean isOnline(){
        ConnectivityManager cm=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netifo=cm.getActiveNetworkInfo();
        if(netifo!=null&&netifo.isConnectedOrConnecting()){
            return true;
        }
        return false;
    }

    public void DoSomething(View view){
        if(isOnline()==true){
            c1 = new ConnectInternetTask(this);
            c1.execute(sp.getSelectedItem() + edt.getText().toString());
        }
        else{
            Toast.makeText(this,"Connection Not Avalilable",Toast.LENGTH_SHORT).show();
        }
    }
}
