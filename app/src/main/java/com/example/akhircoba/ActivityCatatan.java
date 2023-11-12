package com.example.akhircoba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class ActivityCatatan extends AppCompatActivity {

    Button btSimpan;
    EditText etJudul;
    EditText etIsi;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catatan);

        btSimpan = findViewById(R.id.btSimpan);
        etJudul = findViewById(R.id.etJudul);
        etIsi = findViewById(R.id.etIsi);

        btSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Judul = etJudul.getText().toString();
                String Isi = etIsi.getText().toString();

                if (Judul.isEmpty()){
                    etJudul.setError("Tidak boleh ksosng");
                    return;
                }
                if (Isi.isEmpty()){
                    etIsi.setError("Tidak boleh kosong");
                    return;
                }

                addCatatanToDB(Judul,Isi);
            }
        });


    }

    private void addCatatanToDB(String judul, String isi) {
        HashMap<String, Object> CatatanHashmap = new HashMap<>();
        CatatanHashmap.put("Judul",judul);
        CatatanHashmap.put("Isi",isi);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference CatatansRef = database.getReference("Catatan");

        String key = CatatansRef.push().getKey();
        CatatanHashmap.put("key",key);

        CatatansRef.child(key).setValue(CatatanHashmap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(ActivityCatatan.this, "Added", Toast.LENGTH_SHORT).show();
                etJudul.getText().clear();
                etIsi.getText().clear();
            }
        });


    }

}

