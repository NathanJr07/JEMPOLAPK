package com.jempol.pamkelompok.ui.notifications;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.jempol.pamkelompok.MapsActivity;
import com.jempol.pamkelompok.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashSet;
import java.util.Set;

public class NotificationsFragment extends Fragment {

    private ProgressBar progressCircular;
    private TextView tvProgressText, emailTextView;
    private SharedPreferences sharedPreferences;
    private Set<String> finishedDays;
    private Button btnUpgrade;

    private String uid = "default_user"; // ✅ UID default jika belum login

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        // Bind Views
        progressCircular = root.findViewById(R.id.progressCircular);
        tvProgressText = root.findViewById(R.id.tvProgressText);
        emailTextView = root.findViewById(R.id.email);
        btnUpgrade = root.findViewById(R.id.premiumbtn);

        // Ambil UID dari Firebase
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            uid = user.getUid();
        }

        // Inisialisasi SharedPreferences
        sharedPreferences = requireActivity().getSharedPreferences("FilterPrefs", Context.MODE_PRIVATE);

        // Load data dan tampilkan UI
        loadFinishedDays();
        displayUsername();

        // Aksi tombol UPGRADE
        if (btnUpgrade != null) {
            btnUpgrade.setOnClickListener(v -> {
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);
            });
        }

        return root;
    }

    private void loadFinishedDays() {
        finishedDays = new HashSet<>(sharedPreferences.getStringSet(uid + "_finishedDays", new HashSet<>()));
        updateProgress();
    }

    private void updateProgress() {
        int finishedCount = finishedDays.size();
        int totalDays = 14;

        tvProgressText.setText(finishedCount + " of " + totalDays);

        int progressPercentage = (finishedCount * 100) / totalDays;
        progressCircular.setProgress(progressPercentage);
    }

    private void displayUsername() {
        SharedPreferences userPrefs = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String email = userPrefs.getString("user_email", "Guest");

        if (email.contains("@")) {
            email = email.substring(0, email.indexOf("@"));
        }

        emailTextView.setText(email);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadFinishedDays();
        displayUsername();
    }
}
