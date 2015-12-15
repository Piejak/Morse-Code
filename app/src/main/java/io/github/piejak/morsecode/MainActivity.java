package io.github.piejak.morsecode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

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
        TextView textView = (TextView) findViewById(R.id.morseText);
        String translation = translateFromMorse(textView.getText().toString());
        textView.setText(translation);
    }

    //user clicks the clear button
    public void clear(View view){
        //clear the text
        TextView textView = (TextView) findViewById(R.id.morseText);
        textView.setText("");
    }

    //user clicks the backspace button
    public void backspace(View view){
        TextView textView = (TextView) findViewById(R.id.morseText);
        String morseText = textView.getText().toString();
        if(morseText.equals("Your morse code will be displayed here")){
            textView.setText("");
        } else{
            String newText = "";
            for(int i = 0; i < morseText.length() - 1; i++){
                newText += morseText.charAt(i);
            }
            textView.setText(newText);
        }
    }

    protected static HashMap transToMorseHM(){
        final HashMap transToMorseHM = new HashMap<>();
        transToMorseHM.put("6", "-....");
        transToMorseHM.put("B", "-...");
        transToMorseHM.put("3", "...--");
        transToMorseHM.put("7", "--...");
        transToMorseHM.put("N", "-.");
        transToMorseHM.put("V", "...-");
        transToMorseHM.put(":", "---...");
        transToMorseHM.put("\"", ".-..-.");
        transToMorseHM.put("M", "--");
        transToMorseHM.put("'", ".----.");
        transToMorseHM.put("Y", "-.--");
        transToMorseHM.put("S", "...");
        transToMorseHM.put("?", "..--..");
        transToMorseHM.put("K", "-.-");
        transToMorseHM.put(",", "--..--");
        transToMorseHM.put("R", ".-.");
        transToMorseHM.put("C", "-.-.");
        transToMorseHM.put("P", ".--.");
        transToMorseHM.put(".", ".-.-.-");
        transToMorseHM.put("H", "....");
        transToMorseHM.put(")", "-.--.-");
        transToMorseHM.put("D", "-..");
        transToMorseHM.put("G", "--.");
        transToMorseHM.put("(", "-.--.-");
        transToMorseHM.put("Z", "--..");
        transToMorseHM.put("E", ".");
        transToMorseHM.put("J", ".---");
        transToMorseHM.put("T", "-");
        transToMorseHM.put("9", "----.");
        transToMorseHM.put("8", "---..");
        transToMorseHM.put("=", "-...-");
        transToMorseHM.put("I", "..");
        transToMorseHM.put("-", "-....-");
        transToMorseHM.put("F", "..-.");
        transToMorseHM.put("/", "-..-.");
        transToMorseHM.put(" ", "/");
        transToMorseHM.put("4", "....-");
        transToMorseHM.put("5", ".....");
        transToMorseHM.put("A", ".-");
        transToMorseHM.put("X", "-..-");
        transToMorseHM.put("1", ".----");
        transToMorseHM.put("Q", "--.-");
        transToMorseHM.put("2", "..--");
        transToMorseHM.put("U", "..-");
        transToMorseHM.put("O", "---");
        transToMorseHM.put("@", ".--.-.");
        transToMorseHM.put("L", ".-..");
        transToMorseHM.put("0", "-----");
        transToMorseHM.put("W", ".--");

        return transToMorseHM;
    }

    protected static HashMap transFromMorseHM(){
        final HashMap transFromMorseHM = new HashMap<>();
        transFromMorseHM.put("..--..", "?");
        transFromMorseHM.put("...-", "V");
        transFromMorseHM.put("-....", "6");
        transFromMorseHM.put("--..--", ",");
        transFromMorseHM.put("---..", "8");
        transFromMorseHM.put("....", "H");
        transFromMorseHM.put(".---", "J");
        transFromMorseHM.put("--.-", "Q");
        transFromMorseHM.put("..--", "2");
        transFromMorseHM.put("..", "I");
        transFromMorseHM.put("-.", "N");
        transFromMorseHM.put("-...-", "=");
        transFromMorseHM.put(".----.", "'");
        transFromMorseHM.put("-.-", "K");
        transFromMorseHM.put("--...", "7");
        transFromMorseHM.put("...--", "3");
        transFromMorseHM.put("-.--", "Y");
        transFromMorseHM.put(".-", "A");
        transFromMorseHM.put("-", "T");
        transFromMorseHM.put("..-.", "F");
        transFromMorseHM.put("-..-.", "/");
        transFromMorseHM.put(".----", "1");
        transFromMorseHM.put("----.", "9");
        transFromMorseHM.put(".", "E");
        transFromMorseHM.put("....-", "4");
        transFromMorseHM.put(".-.", "R");
        transFromMorseHM.put(".-..", "L");
        transFromMorseHM.put("--", "M");
        transFromMorseHM.put("-.--.-", "(");
        transFromMorseHM.put("..-", "U");
        transFromMorseHM.put("--..", "Z");
        transFromMorseHM.put(".--.-.", "@");
        transFromMorseHM.put("/", " ");
        transFromMorseHM.put("...", "S");
        transFromMorseHM.put("---", "O");
        transFromMorseHM.put("-...", "B");
        transFromMorseHM.put(".....", "5");
        transFromMorseHM.put(".-..-.", "\"");
        transFromMorseHM.put("-..-", "X");
        transFromMorseHM.put("---...", ":");
        transFromMorseHM.put("-----", "0");
        transFromMorseHM.put(".--.", "P");
        transFromMorseHM.put("-....-", "-");
        transFromMorseHM.put("-.-.", "C");
        transFromMorseHM.put("-..", "D");
        transFromMorseHM.put("--.", "G");
        transFromMorseHM.put(".--", "W");
        transFromMorseHM.put(".-.-.-", ".");

        return transFromMorseHM;
    }

    public static String translateFromMorse(String inString){
        HashMap transFromMorseHM = transFromMorseHM();
        String outString = "";
        String letterBuffer = "";
        for(int i = 0; i < inString.length(); i++){
            if(inString.charAt(i) == ' '){
                outString += transFromMorseHM.get(letterBuffer);
                letterBuffer = "";
            } else{
                letterBuffer += inString.charAt(i);
            }
        }
        outString += transFromMorseHM.get(letterBuffer);

        return outString;
    }




}
