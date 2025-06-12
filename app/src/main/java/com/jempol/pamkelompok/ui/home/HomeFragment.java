package com.jempol.pamkelompok.ui.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.jempol.pamkelompok.databinding.FragmentHomeBinding;
import com.google.firebase.auth.FirebaseAuth; // ✅ Tambahkan
import com.google.firebase.auth.FirebaseUser;   // ✅ Tambahkan

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private final List<View> dayViews = new ArrayList<>();
    private SharedPreferences sharedPreferences;
    private Set<String> finishedDays;
    private boolean isReceiverRegistered = false;
    private String uid = "default_user"; // ✅ UID Default

    private final BroadcastReceiver updateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            loadFinishedDays();
        }
    };

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // ✅ Ambil UID dari Firebase
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            uid = user.getUid(); // Gunakan UID untuk menyimpan data
        }

        // Inisialisasi SharedPreferences
        sharedPreferences = requireActivity().getSharedPreferences("FilterPrefs", Context.MODE_PRIVATE);
        finishedDays = new HashSet<>(sharedPreferences.getStringSet(uid + "_finishedDays", new HashSet<>())); // ✅ Gunakan UID

        // Menampilkan nama pengguna tanpa @gmail.com
        displayUsername();

        // Inisialisasi UI
        setupUI();
    }

    private void displayUsername() {
        // Ambil email dari SharedPreferences
        SharedPreferences userPrefs = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String email = userPrefs.getString("user_email", "Guest");

        // Hapus "@gmail.com" jika ada
        if (email.contains("@")) {
            email = email.substring(0, email.indexOf("@"));
        }

        // Tampilkan nama di UI
        binding.email.setText(email);
    }

    private void setupUI() {
        if (binding == null) return;

        dayViews.clear();
        dayViews.add(binding.day1);
        dayViews.add(binding.day2);
        dayViews.add(binding.day3);
        dayViews.add(binding.day4);
        dayViews.add(binding.day5);
        dayViews.add(binding.day6);
        dayViews.add(binding.day7);
        dayViews.add(binding.day8);
        dayViews.add(binding.day9);
        dayViews.add(binding.day10);
        dayViews.add(binding.day11);
        dayViews.add(binding.day12);
        dayViews.add(binding.day13);
        dayViews.add(binding.day14);

        for (int i = 0; i < dayViews.size(); i++) {
            final int index = i + 1;
            View dayView = dayViews.get(i);

            dayView.setOnClickListener(v -> {
                try {
                    Intent intent = new Intent(getActivity(), Class.forName("com.jempol.pamkelompok.day" + index));
                    intent.putExtra("dayNumber", index);
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });
        }

        binding.rbAll.setOnClickListener(v -> {
            binding.rbFinished.setChecked(false);
            showAllDays();
        });

        binding.rbFinished.setOnClickListener(v -> {
            binding.rbAll.setChecked(false);
            showFinishedDays();
        });

        binding.rbAll.setChecked(true);
        showAllDays();
    }

    @Override
    public void onResume() {
        super.onResume();

        if (!isReceiverRegistered) {
            requireActivity().registerReceiver(updateReceiver,
                    new IntentFilter("UPDATE_FINISHED_LIST"),
                    Context.RECEIVER_NOT_EXPORTED);
            isReceiverRegistered = true;
        }

        loadFinishedDays();
    }

    private void loadFinishedDays() {
        // ✅ Muat berdasarkan UID
        finishedDays = new HashSet<>(sharedPreferences.getStringSet(uid + "_finishedDays", new HashSet<>()));
        Log.d("HomeFragment", "Finished days loaded: " + finishedDays.toString());

        if (binding.rbAll.isChecked()) {
            showAllDays();
        } else {
            showFinishedDays();
        }
    }

    private void showAllDays() {
        if (binding == null) return;
        for (View day : dayViews) {
            day.setVisibility(View.VISIBLE);
        }
    }

    private void showFinishedDays() {
        if (binding == null) return;
        for (int i = 0; i < dayViews.size(); i++) {
            String dayKey = "day" + (i + 1);
            dayViews.get(i).setVisibility(finishedDays.contains(dayKey) ? View.VISIBLE : View.GONE);
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        if (isReceiverRegistered) {
            try {
                requireActivity().unregisterReceiver(updateReceiver);
                isReceiverRegistered = false;
            } catch (IllegalArgumentException e) {
                Log.e("HomeFragment", "Receiver was not registered", e);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
