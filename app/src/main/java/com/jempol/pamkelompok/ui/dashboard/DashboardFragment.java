package com.jempol.pamkelompok.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.jempol.pamkelompok.R;
import com.jempol.pamkelompok.modul1;
import com.jempol.pamkelompok.modul11;
import com.jempol.pamkelompok.modul2;
import com.jempol.pamkelompok.modul3;
import com.jempol.pamkelompok.modul4;
import com.jempol.pamkelompok.modul5;
import com.jempol.pamkelompok.modul6;
import com.jempol.pamkelompok.modul7;
import com.jempol.pamkelompok.modul8;
import com.jempol.pamkelompok.modul9;
import com.jempol.pamkelompok.modul10;
import com.jempol.pamkelompok.modul12;
import com.jempol.pamkelompok.modul13;
import com.jempol.pamkelompok.modul14;
import com.jempol.pamkelompok.modul15;
import com.jempol.pamkelompok.modul16;
import com.jempol.pamkelompok.modul17;
import com.jempol.pamkelompok.modul18;
import com.jempol.pamkelompok.modul19;
import com.jempol.pamkelompok.modul20;
import com.jempol.pamkelompok.modul21;
import com.jempol.pamkelompok.modul22;
import com.jempol.pamkelompok.modul23;
import com.jempol.pamkelompok.modul24;
import com.jempol.pamkelompok.modul25;


public class DashboardFragment extends Fragment {

    private CardView module1;
    private CardView module2;
    private CardView module3;
    private CardView module4;
    private CardView module5;
    private CardView module6;
    private CardView module7;
    private CardView module8;
    private CardView module9;
    private CardView module10;
    private CardView module11;
    private CardView module12;
    private CardView module13;
    private CardView module14;
    private CardView module15;
    private CardView module16;
    private CardView module17;
    private CardView module18;
    private CardView module19;
    private CardView module20;
    private CardView module21;
    private CardView module22;
    private CardView module23;
    private CardView module24;
    private CardView module25;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        // Inisialisasi CardView
        module1 = root.findViewById(R.id.cdm1);
        module2 = root.findViewById(R.id.cdm2);
        module3 = root.findViewById(R.id.cdm3);
        module4 = root.findViewById(R.id.cdm4);
        module5 = root.findViewById(R.id.cdm5);
        module6 = root.findViewById(R.id.cdm6);
        module7 = root.findViewById(R.id.cdm7);
        module8 = root.findViewById(R.id.cdm8);
        module9 = root.findViewById(R.id.cdm9);
        module10 = root.findViewById(R.id.cdm10);
        module11 = root.findViewById(R.id.cdm11);
        module12 = root.findViewById(R.id.cdm12);
        module13 = root.findViewById(R.id.cdm13);
        module14 = root.findViewById(R.id.cdm14);
        module15 = root.findViewById(R.id.cdm15);
        module16 = root.findViewById(R.id.cdm16);
        module17 = root.findViewById(R.id.cdm17);
        module18 = root.findViewById(R.id.cdm18);
        module19 = root.findViewById(R.id.cdm19);
        module20 = root.findViewById(R.id.cdm20);
        module21 = root.findViewById(R.id.cdm21);
        module22 = root.findViewById(R.id.cdm22);
        module23 = root.findViewById(R.id.cdm23);
        module24 = root.findViewById(R.id.cdm24);
        module25 = root.findViewById(R.id.cdm25);

        // Listener untuk modul 1
        module1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul1.class);
                startActivity(intent);
            }
        });

        // Listener untuk modul 2
        module2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul2.class);
                startActivity(intent);
            }
        });

        module3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul3.class);
                startActivity(intent);
            }
        });

        module4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul4.class);
                startActivity(intent);
            }
        });

        module5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul5.class);
                startActivity(intent);
            }
        });

        module6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul6.class);
                startActivity(intent);
            }
        });

        module7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul7.class);
                startActivity(intent);
            }
        });

        module8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul8.class);
                startActivity(intent);
            }
        });

        module9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul9.class);
                startActivity(intent);
            }
        });

        module10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul10.class);
                startActivity(intent);
            }
        });

        module11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul11.class);
                startActivity(intent);
            }
        });

        module12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul12.class);
                startActivity(intent);
            }
        });

        module13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul13.class);
                startActivity(intent);
            }
        });

        module14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul14.class);
                startActivity(intent);
            }
        });

        module15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul15.class);
                startActivity(intent);
            }
        });

        module16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul16.class);
                startActivity(intent);
            }
        });

        module17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul17.class);
                startActivity(intent);
            }
        });

        module18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul18.class);
                startActivity(intent);
            }
        });

        module19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul19.class);
                startActivity(intent);
            }
        });

        module20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul20.class);
                startActivity(intent);
            }
        });

        module21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul21.class);
                startActivity(intent);
            }
        });

        module22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul22.class);
                startActivity(intent);
            }
        });

        module23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul23.class);
                startActivity(intent);
            }
        });

        module24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul24.class);
                startActivity(intent);
            }
        });

        module25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), modul25.class);
                startActivity(intent);
            }
        });

        return root;
    }
}
