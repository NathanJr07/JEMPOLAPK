package com.jempol.pamkelompok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registrasi2 extends AppCompatActivity {

    ImageView back;
    EditText inputemail, p, c;
    String email, password, confirm;
    Button registrasi;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrasi2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        back = findViewById(R.id.backbtnr);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act2 = new Intent(registrasi2.this, registrasi1.class);
                startActivity(act2);
            }
        });

        TextView masuk = findViewById(R.id.textlogin);
        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(registrasi2.this, registrasi3.class);
                startActivity(intent);
            }
        });

        inputemail = findViewById(R.id.email);
        p = findViewById(R.id.psw);
        c = findViewById(R.id.confirmpsw);
        registrasi = findViewById(R.id.btnregis);
        registrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrasi();
            }
        });
    }

    private void registrasi() {
        email = inputemail.getText().toString().trim();
        password = p.getText().toString().trim();
        confirm = c.getText().toString().trim();

        // Validasi input sebelum
        // registrasi
        if (email.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
            Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_LONG).show();
            return;
        }

        if (!password.equals(confirm)) {
            Toast.makeText(this, "Password tidak sesuai!", Toast.LENGTH_LONG).show();
            return;
        }

        // Mendaftarkan pengguna dengan email dan password
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(registrasi2.this, "Registrasi Sukses", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(registrasi2.this, registrasi3.class));
                            finish(); // Menutup aktivitas ini setelah sukses
                        } else {
                            Toast.makeText(registrasi2.this, "Registrasi Gagal: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}

