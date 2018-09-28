package com.example.tp_t550.calculator80085;

import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    CalculatorMemory calculatorMemory;
    TextView tx;
    Dialog boobs;
    ImageView imageView;
    int[] drawableIds = {R.drawable.boobs1, R.drawable.boobs2, R.drawable.boobs3, R.drawable.boobs4, R.drawable.boobs5, R.drawable.boobs6};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Calculator font
        tx = findViewById(R.id.editText);
        Typeface digitalFont = Typeface.createFromAsset(getAssets(),  "fonts/digital-7.ttf");
        tx.setTypeface(digitalFont);

        calculatorMemory = new CalculatorMemory(Operator.NULL);
        MyBoobs();


     }

    public void MyBoobs(){
        boobs = new Dialog(MainActivity.this);
        boobs.setContentView(R.layout.custom_dialogue);
        boobs.setTitle("BOOBIES!");
        imageView = (ImageView) boobs.findViewById(R.id.imageView);
    }


    public void equals(View view) {
        int result = calculatorMemory.execute();
        tx.setText("" + result);
        if(result == 80085 || result == 5318008){
            int rn = ThreadLocalRandom.current().nextInt(0, 6);
            Picasso.get().load(drawableIds[rn]).into(imageView);
            boobs.show();
        }
        calculatorMemory.setJustPressedEquals(true);

    }

    //Should create a map from symbol to enum so only need one function for these but not working for some reason
    public void divide(View view) {
         calculatorMemory.updateOperator(Operator.DIVIDE);
         calculatorMemory.setJustPressedEquals(false);
    }

    public void multiply(View view) {
         calculatorMemory.updateOperator(Operator.MULTIPLY);
         calculatorMemory.setJustPressedEquals(false);
    }

    public void add(View view) {
        calculatorMemory.updateOperator(Operator.ADD);
        calculatorMemory.setJustPressedEquals(false);
    }

    public void minus(View view) {
         calculatorMemory.updateOperator(Operator.MINUS);
         calculatorMemory.setJustPressedEquals(false);
    }

    public void pressOperation(View view){
         Button button = findViewById(view.getId());
         String op = button.getText().toString();
         calculatorMemory.updateOperator(Operator.getBySymbol(op));
         calculatorMemory.setJustPressedEquals(false);
    }

    public void CE(View view) {
         calculatorMemory.clearMemory();
         tx.setText("" + 0);
         calculatorMemory.setJustPressedEquals(false);
         //make view 0
    }

    public void pressNumber(View view) {
        Button button = findViewById(view.getId());
        String text = button.getText().toString();
        int num = Integer.parseInt(text);
        int updateNum = calculatorMemory.enterNumber(num);
        if(updateNum == 0) {
            tx.setText("" + calculatorMemory.getNum1());
        }
        else{
            tx.setText("" + calculatorMemory.getNum2());
        }
        calculatorMemory.setJustPressedEquals(false);

    }

}
