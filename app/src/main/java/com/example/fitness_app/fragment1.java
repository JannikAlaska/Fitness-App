package com.example.fitness_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment1 extends Fragment {
    private LinearLayout rootLayout;
    private LinearLayout exerciseLayout;
    private TextView exerciseTextView;
    private CheckBox checkbox;
    private Button saveButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =inflater.inflate(R.layout.fragment_fragment1,container,false);

        rootLayout = view.findViewById(R.id.rootLayout);
        //exerciseTextView = view.findViewById(R.id.exerciseTextView);
        //checkbox = view.findViewById(R.id.checkbox);
        //saveButton = view.findViewById(R.id.saveButton);


        // Erstellen Sie TextViews und EditTexts für die Übungen
        String[] exercises = {"Beinpresse", "Beinstrecker", "Butterfly", "Brustpresse", "Rückenstrecker", "Latzug", "Beinheben", "Bauchbeuger"};
        for (String exercise : exercises) {
            LinearLayout exerciseLayout = new LinearLayout(getContext());
            exerciseLayout.setOrientation(LinearLayout.HORIZONTAL);

            TextView exerciseTextView = new TextView(getContext());
            exerciseTextView.setText(exercise);
            exerciseLayout.addView(exerciseTextView);
            if (!exercise.equals("Beinheben")) {
                EditText weightEditText = new EditText(getContext());
                weightEditText.setHint("kg");
                exerciseLayout.addView(weightEditText);
            } else {
                CheckBox checkbox = new CheckBox(getContext());
                exerciseLayout.addView(checkbox);
            }

            rootLayout.addView(exerciseLayout);
        }

        // Erstellen Sie einen Button zum Speichern der eingegebenen Werte
        Button saveButton = new Button(getContext());
        saveButton.setText("Speichern");
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Speichern Sie die eingegebenen Werte in einer Variablen oder einer Datenbank
                
            }
        });
        rootLayout.addView(saveButton);
        return view;
    }
}