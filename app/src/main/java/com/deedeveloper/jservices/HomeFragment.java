package com.deedeveloper.jservices;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.deedeveloper.jservices.DetailActivity.ActivityTwo;
import com.deedeveloper.jservices.DetailActivity.TaxiActivity;

public class HomeFragment extends Fragment implements View.OnClickListener {

    ImageView carpenter, technician, worker, mechanic, plumber, painter, teacher, programmer, taxiBooking;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        carpenter = view.findViewById(R.id.carpenter);
        technician = view.findViewById(R.id.technician);
        worker = view.findViewById(R.id.worker);
        mechanic = view.findViewById(R.id.mechanic);
        plumber = view.findViewById(R.id.plumber);
        painter = view.findViewById(R.id.painter);
        teacher = view.findViewById(R.id.teacher);
        programmer = view.findViewById(R.id.programmer);
        taxiBooking = view.findViewById(R.id.taxiBooking);

        carpenter.setOnClickListener(this);
        technician.setOnClickListener(this);
        worker.setOnClickListener(this);
        mechanic.setOnClickListener(this);
        plumber.setOnClickListener(this);
        painter.setOnClickListener(this);
        teacher.setOnClickListener(this);
        programmer.setOnClickListener(this);
        taxiBooking.setOnClickListener(this);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getContext(), "Button Clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.carpenter:
                Intent intent = new Intent(getContext(), ActivityTwo.class);
                startActivity(intent);
                break;
            case R.id.technician:
                Toast.makeText(getContext(), "Technician Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.worker:
                Toast.makeText(getContext(), "Worker Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mechanic:
                Toast.makeText(getContext(), "Mechanic Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.plumber:
                Toast.makeText(getContext(), "Plumber Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.painter:
                Toast.makeText(getContext(), "Painter Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.teacher:
                Toast.makeText(getContext(), "Teacher Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.programmer:
                Toast.makeText(getContext(), "Programmer Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.taxiBooking:
                Intent intent1 = new Intent(getContext(), TaxiActivity.class);
                startActivity(intent1);
        }
    }
}