package io.github.piejak.morsecode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //user clicks the dash button
    public void appendDash(View view){
        TextView textView = (TextView) findViewById(R.id.morseText);
        String morseText = textView.getText().toString();
        if(morseText.equals("Your morse code will be displayed here")){
            morseText = "-";
            textView.setText(morseText);
        } else{
            morseText += "-";
            textView.setText(morseText);
        }
    }

    //user clicks the dot button
    public void appendDot(View view){
        TextView textView = (TextView) findViewById(R.id.morseText);
        String morseText = textView.getText().toString();
        if(morseText.equals("Your morse code will be displayed here")){
            morseText = ".";
            textView.setText(morseText);
        } else{
            morseText += ".";
            textView.setText(morseText);
        }
    }

    //user clicks the space button
    public void appendSpace(View view){
        TextView textView = (TextView) findViewById(R.id.morseText);
        String morseText = textView.getText().toString();
        if(morseText.equals("Your morse code will be displayed here")){
            // The morse code shouldn't lead with a space
            // TODO: handle this as an error
        } else{
            morseText += " ";
            textView.setText(morseText);
        }
    }

    //user clicks the slash button
    public void appendSlash(View view){
        TextView textView = (TextView) findViewById(R.id.morseText);
        String morseText = textView.getText().toString();
        if(morseText.equals("Your morse code will be displayed here")){
            // The morse code shouldn't lead with a slash
            // TODO: handle this as an error
        } else{
            morseText += " / ";
            textView.setText(morseText);
        }
    }

    //user clicks the submit button
    public void submit(View view){
        //Translate the morse code
        //T TODO: implement the morse code translation I already have written
    }

}
