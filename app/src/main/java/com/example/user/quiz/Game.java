package com.example.user.quiz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Game extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[][] array = {{"Вопрос 1", "Number 1", "Number 2" ,"Number 3","Number 4", "Number 1"   }, {"Вопрос 2", "Number 1/2", "Num2ber 2.2" ,"Number 3.2","Number 4.2", "Number 2.2" },};

        View rootView = inflater.inflate(R.layout.fragment_game, container, false);
        Button ans1 = (Button) rootView.findViewById(R.id.answer1);
        ans1.setText(array[0][0]);
        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(), "Ответ1", Toast.LENGTH_LONG).show();

            }
        });
        Button ans2 = (Button) rootView.findViewById(R.id.answer2);
        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(), "Ответ2", Toast.LENGTH_LONG).show();
            }
        });
        Button ans3 = (Button) rootView.findViewById(R.id.answer3);
        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(), "Ответ3", Toast.LENGTH_LONG).show();
            }
        });
        Button ans4 = (Button) rootView.findViewById(R.id.answer4);
        ans4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(), "Ответ4", Toast.LENGTH_LONG).show();
            }
        });
        return rootView;
    }
}

