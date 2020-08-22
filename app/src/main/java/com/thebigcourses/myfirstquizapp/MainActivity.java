package com.thebigcourses.myfirstquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView QuestionView;
    private Button TrueButton, FalseButton;
    private ImageButton SkipQuestion;
    String todo = "todo";
    int nextQuestionID = 0;
    private Question[] question = new Question[]{
            new Question(R.string.question1,false),
            new Question(R.string.question2,true),
            new Question(R.string.question3,true),
            new Question(R.string.question4,false),
            new Question(R.string.question5,false)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QuestionView = findViewById(R.id.textView);
        TrueButton = findViewById(R.id.button);
        FalseButton = findViewById(R.id.button2);
        SkipQuestion = findViewById(R.id.imageButton);

        TrueButton.setOnClickListener(this);
        FalseButton.setOnClickListener(this);
        SkipQuestion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                userCheckAnswer(true);

                break;

            case R.id.button2:
                userCheckAnswer(false);
                break;

            case R.id.imageButton:
                Toast.makeText(getApplicationContext(),"3"+todo,Toast.LENGTH_LONG).show();
                nextQuestionID = (nextQuestionID +1) %question.length;
                QuestionView.setText(question[nextQuestionID].getResID());
                break;

        }
    }
    private void userCheckAnswer(boolean answerCheck){
        int massageID = 0;
        boolean abc = question[nextQuestionID].isTrue();
        if(answerCheck == abc){
            massageID = R.string.correct_answer;
        }else {
            massageID = R.string.wrong_answer;
        }
        Toast.makeText(getApplicationContext(),massageID,Toast.LENGTH_LONG).show();

    }
}
