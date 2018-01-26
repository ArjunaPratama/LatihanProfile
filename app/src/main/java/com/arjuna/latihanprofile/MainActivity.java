package com.arjuna.latihanprofile;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etname, etemail, etalamat;
    Button btnsubmit, btnexit;
    TextView txthasil, txthasil2, txthasil3, txthasil4, txthasil5;
    Spinner spinSex, spinClass;
    String item;
    String sex;
    String kelas;
    String[] datasex = new String[]{
            "Laki Laki", "Perempuan"
    };
    String[] datakelas = new String[]{
            "TKJ", "RPL", "Mesin"
    };
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txthasil = (TextView) findViewById(R.id.txthasil);
        txthasil2 = (TextView) findViewById(R.id.txthasil2);
        txthasil3 = (TextView) findViewById(R.id.txthasil3);
        txthasil4 = (TextView) findViewById(R.id.txthasil4);
        txthasil5 = (TextView) findViewById(R.id.txthasil5);
        txthasil5 = (TextView) findViewById(R.id.txthasil5);
        etname = (EditText) findViewById(R.id.etname);
        etemail = (EditText) findViewById(R.id.etemail);
        etalamat = (EditText) findViewById(R.id.etalamat);
        btnsubmit = (Button) findViewById(R.id.btnsubmit);
        btnexit = (Button) findViewById(R.id.btnexit);

        btn

        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle("Apakah Anda Yakin Ingin Keluar")

                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //kondisi ketika kita pencet yes
                                MainActivity.this.finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();

                            }
                        });
                AlertDialog alert = alertDialog.create();
                alert.show();
                dialog.setContentView(R.layout.layout_custom);
                //mengatur title
                dialog.setTitle("Warning!");
            }
        });

        spinSex = (Spinner) findViewById(R.id.spinSex);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datasex);

        spinSex.setAdapter(adapter);

        spinSex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sex = adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinClass = (Spinner) findViewById(R.id.spinClass);
        final ArrayAdapter<String> adapterr = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datakelas);

        spinClass.setAdapter(adapterr);
        spinClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                kelas = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  nname = etname.getText().toString();
                String  nalamat = etalamat.getText().toString();
                String  nemail = etemail.getText().toString();

                txthasil.setText(nname);
                txthasil2.setText(nalamat);
                txthasil3.setText(nemail);
                txthasil4.setText(sex);
                txthasil5.setText(kelas);
            }
        });


    }
}
