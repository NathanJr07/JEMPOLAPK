package com.jempol.pamkelompok;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth; // ✅ Tambah import
import com.google.firebase.auth.FirebaseUser;  // ✅ Tambah import

import java.util.HashSet;
import java.util.Set;

public class day14 extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private int dayNumber;
    private String uid = "default_user"; // ✅ UID default

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day14);

        // Ambil nomor hari dari intent
        dayNumber = getIntent().getIntExtra("dayNumber", 1);

        // ✅ Ambil UID dari Firebase
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            uid = user.getUid(); // Gunakan UID sebagai key
        }

        // Inisialisasi SharedPreferences
        sharedPreferences = getSharedPreferences("FilterPrefs", MODE_PRIVATE);

        // Tombol Selesai
        Button finishButton = findViewById(R.id.btnSelesai);
        finishButton.setOnClickListener(v -> {
            markDayAsFinished();
            setResult(RESULT_OK);
            finish();
        });

        // Tombol Batal
        Button cancelButton = findViewById(R.id.btnBatal);
        cancelButton.setOnClickListener(v -> removeDayFromFinished());
    }

    private void markDayAsFinished() {
        // ✅ Gunakan UID sebagai key
        Set<String> finishedDays = new HashSet<>(sharedPreferences.getStringSet(uid + "_finishedDays", new HashSet<>()));
        finishedDays.add("day" + dayNumber);

        sharedPreferences.edit()
                .putStringSet(uid + "_finishedDays", finishedDays)
                .apply();

        sendBroadcast(new Intent("UPDATE_FINISHED_LIST"));
    }

    private void removeDayFromFinished() {
        Set<String> finishedDays = new HashSet<>(sharedPreferences.getStringSet(uid + "_finishedDays", new HashSet<>()));

        if (finishedDays.contains("day" + dayNumber)) {
            finishedDays.remove("day" + dayNumber);
        }

        sharedPreferences.edit()
                .putStringSet(uid + "_finishedDays", finishedDays)
                .apply();

        sendBroadcast(new Intent("UPDATE_FINISHED_LIST"));
        setResult(RESULT_OK);
        finish();
    }
}
