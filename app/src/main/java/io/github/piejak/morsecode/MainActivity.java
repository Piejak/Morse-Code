package io.github.piejak.morsecode;

import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity{
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private NavigationView navView;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] alphabetData = {"H", " ", ".", "R", "J", "0", "?", "-", "1", "W", "9", "G", "'", "S", "3", "M", "V", "T", "2", "@", ")", "K", ":", "/", "Y", "L", "X", "C", "F", "=", "D", "(", ",", "\"", "E", "7", "I", "8", "A", "4", "N", "Z", "6", "5", "B", "O", "P", "U", "Q"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolbar();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = setUpDrawerToggle();
        mDrawerLayout.setDrawerListener(drawerToggle);
        navView = (NavigationView) findViewById(R.id.navView);
        setupDrawerContent(navView);

        Class fragmentClass = fromMorse.class;
        Fragment fragment = null;
        try{
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flContent, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private ActionBarDrawerToggle setUpDrawerToggle(){
        return new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
    }

    private void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener(){
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem){
                        selectDrawerItem(menuItem);
                        return true;
                    }
                }
        );
    }

    public void selectDrawerItem(MenuItem menuItem){
        Class fragmentClass;

        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.nav_first:
                fragmentClass = fromMorse.class;
                break;
            case R.id.nav_second:
                fragmentClass = toMorse.class;
                break;
            case R.id.nav_third:
                fragmentClass = alphabet.class;
                break;
            default:
                fragmentClass = fromMorse.class;
        }
        try{
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flContent, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawerLayout.closeDrawers();
    }

    public void firstButton(View view){
        Class fragmentClass = fromMorse.class;
        Fragment fragment = null;
        try{
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flContent, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void secondButton(View view){
        Class fragmentClass = fromMorse.class;
        Fragment fragment = null;
        try{
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flContent, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void thirdButton(View view){
        Class fragmentClass = fromMorse.class;
        Fragment fragment = null;
        try{
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flContent, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void setUpToolbar(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if(mToolbar != null){
            setSupportActionBar(mToolbar);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (setUpDrawerToggle().onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);

        setUpDrawerToggle().syncState();
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
        if(morseText.equals("Your morse code will be displayed here") || morseText.equals("")){
            // The morse code shouldn't lead with a space
            Toast.makeText(MainActivity.this, "Can't start with a space", Toast.LENGTH_SHORT).show();
        } else{
            morseText += " ";
            textView.setText(morseText);
        }
    }

    //user clicks the slash button
    public void appendSlash(View view){
        TextView textView = (TextView) findViewById(R.id.morseText);
        String morseText = textView.getText().toString();
        if(morseText.equals("Your morse code will be displayed here") || morseText.equals("")){
            // The morse code shouldn't lead with a slash
            Toast.makeText(MainActivity.this, "Can't start with a slash", Toast.LENGTH_SHORT).show();
        } else{
            morseText += " / ";
            textView.setText(morseText);
        }
    }

    //user clicks the submit button
    public void submit(View view){
        //Translate the morse code
        TextView textView = (TextView) findViewById(R.id.morseText);
        String translation = translateFromMorse(textView.getText().toString());
        textView.setText(translation);
    }

    //user clicks submit on translate to morse
    public void submitToMorse(View view){
        EditText editText = (EditText) findViewById(R.id.regularText);
        TextView textView = (TextView) findViewById(R.id.transPlaceholder);
        String translation = translateToMorse(editText.getText().toString());
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

    public static String translateToMorse(String inString){
        HashMap transToMorseHM = transToMorseHM();
        String outString = "";
        String letterBuffer = "";
        for(int i = 0; i < inString.length(); i++){
            char letter = Character.toUpperCase(inString.charAt(i));
            String letterString = "" + letter;
            if(transToMorseHM.get(letterString) != null){
                outString += transToMorseHM.get(letterString) + " ";
            }
            else{
                return inString.charAt(i) + " could not be translated to morse, please try again.";
            }
        }

        return outString;
    }




}
