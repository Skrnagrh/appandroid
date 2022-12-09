package com.example.pertmuan5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseManager dm;
    EditText nama, harga, GetId, updateNama, updateHarga, updateMade, made, idDel;
    Button addBtn, getIdBtn, updateBtn,delBtn;
    TableLayout tabel4data;// tabel for data


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dm = new DatabaseManager(this);
        setupView();
        fungsiBtn();
        updateTable();
    }

    public void setupView() {
        tabel4data = (TableLayout) findViewById(R.id.tabel_data);
        nama = (EditText) findViewById(R.id.nama);
        harga = (EditText) findViewById(R.id.harga);
        made = (EditText) findViewById(R.id.made);
        updateNama = (EditText) findViewById(R.id.nama);
        updateHarga = (EditText) findViewById(R.id.harga);
        updateMade = (EditText) findViewById(R.id.made);
        GetId = (EditText) findViewById(R.id.inGetId);
        idDel=(EditText)findViewById(R.id.inGetId);

        addBtn = (Button) findViewById(R.id.btnAdd);
        getIdBtn = (Button) findViewById(R.id.btnGetId);
        updateBtn = (Button) findViewById(R.id.btnUpdate);
        delBtn = (Button) findViewById(R.id.btnDel);
    }

    public void fungsiBtn() {
        addBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                simpKamuta();
                kosongkanField();
            }
        });
        getIdBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View b) {
                ambilBaris();
            }
        });
        updateBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View c) {
                updateBaris();
                kosongkanField();
            }
        });
        delBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View d) {
                // TODO Auto-generated method stub
                deleteData();
                kosongkanField();
            }
        });
    }
    protected void kosongkanField(){
        nama.setText("");
        harga.setText("");
        made.setText("");
        updateNama.setText("");
        updateHarga.setText("");
        updateMade.setText("");
        GetId.setText("");
        idDel.setText("");
    }

    private void deleteData(){
        dm.deleteBaris(Long.parseLong(idDel.getText().toString()));
        updateTable();
    }

    protected void updateBaris() {
        dm.updateBaris(Long.parseLong(GetId.getText().toString()),
                updateNama.getText().toString(),
                updateHarga.getText().toString(),
                updateMade.getText().toString());
        updateTable();
    }

    private void ambilBaris() {
        try {
            ArrayList<Object> baris;
            baris =
                    dm.ambilBaris(Long.parseLong(GetId.getText().toString()));
            updateNama.setText((String) baris.get(1));
            updateHarga.setText((String) baris.get(2));
            updateMade.setText((String) baris.get(3));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Log.e("eror db", e.toString());
            Toast.makeText(getBaseContext(), e.toString(),
                    Toast.LENGTH_LONG).show();
        }
    }

    protected void simpKamuta() {
        try {
            dm.addRow(nama.getText().toString(),
                    harga.getText().toString(),
                    made.getText().toString());
            updateTable();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getBaseContext(),"gagal simpan,"
                    +e.toString(),Toast.LENGTH_LONG).show();
        }
    }

    protected void updateTable() {
        while (tabel4data.getChildCount() > 1) {
            tabel4data.removeViewAt(1);
        }
        ArrayList<ArrayList<Object>> data = dm.ambilSemuaBaris();//
        for (int posisi = 0; posisi < data.size(); posisi++) {
            TableRow tabelBaris = new TableRow(this);
            ArrayList<Object> baris = data.get(posisi);

            TextView idTxt = new TextView(this);
            idTxt.setText(baris.get(0).toString());
            tabelBaris.addView(idTxt);

            TextView namaTxt = new TextView(this);
            namaTxt.setText(baris.get(1).toString());
            tabelBaris.addView(namaTxt);

            TextView hargaTxt = new TextView(this);
            hargaTxt.setText(baris.get(2).toString());
            tabelBaris.addView(hargaTxt);

            TextView madeTxt = new TextView(this);
            madeTxt.setText(baris.get(3).toString());
            tabelBaris.addView(madeTxt);

            tabel4data.addView(tabelBaris);
        }
    }
}