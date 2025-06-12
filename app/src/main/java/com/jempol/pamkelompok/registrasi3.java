package com.jempol.pamkelompok;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class registrasi3 extends AppCompatActivity {

    private ImageView back;
    private EditText inputemail, inputpassword;
    private Button login;
    private FirebaseAuth mAuth;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrasi3);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Inisialisasi SharedPreferences
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        // Inisialisasi UI
        inputemail = findViewById(R.id.email);
        inputpassword = findViewById(R.id.confirmpsw);
        login = findViewById(R.id.btnloginn);
        back = findViewById(R.id.backbtnl);

        // Tombol login
        login.setOnClickListener(v -> ceklogin());

        // Tombol kembali
        back.setOnClickListener(v -> {
            Intent intent = new Intent(registrasi3.this, registrasi2.class);
            startActivity(intent);
        });

        // Navigasi ke halaman registrasi
        TextView register = findViewById(R.id.textregister);
        register.setOnClickListener(v -> {
            Intent intent = new Intent(registrasi3.this, registrasi2.class);
            startActivity(intent);
        });
    }

    private void ceklogin() {
        String email = inputemail.getText().toString().trim();
        String password = inputpassword.getText().toString().trim();

        // Validasi input kosong
        if (email.isEmpty()) {
            inputemail.setError("Email Tidak Boleh Kosong");
            inputemail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            inputpassword.setError("Password Tidak Boleh Kosong");
            inputpassword.requestFocus();
            return;
        }

        // Proses login dengan Firebase
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Ambil username tanpa @gmail.com
                            String username = email.contains("@") ? email.substring(0, email.indexOf("@")) : email;

                            // Simpan username ke SharedPreferences
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("user_email", username);
                            editor.apply();

                            Toast.makeText(registrasi3.this, "Login Sukses", Toast.LENGTH_LONG).show();

                            // Intent ke halaman utama setelah login sukses
                            Intent intent = new Intent(registrasi3.this, Challenge.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                            finish();
                        } else {
                            try {
                                throw task.getException();
                            } catch (FirebaseAuthInvalidUserException e) {
                                Toast.makeText(registrasi3.this, "Email Tidak Terdaftar", Toast.LENGTH_LONG).show();
                            } catch (FirebaseAuthInvalidCredentialsException e) {
                                Toast.makeText(registrasi3.this, "Password Salah", Toast.LENGTH_LONG).show();
                            } catch (Exception e) {
                                Toast.makeText(registrasi3.this, "Login Gagal: " + e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });
    }
}