package ricardotenorio.geoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPrevButton;
    private Button mCheatButton;
    private TextView mQuestionTextView;
    private int pontos = 0;
    private int mCurrentIndex = 0;
    private List<Question> mQuestionBank = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        mQuestionBank.add( new Question(R.string.questao1, true, 5));
        mQuestionBank.add(new Question(R.string.questao2, true, 2));
        mQuestionBank.add(new Question(R.string.questao3, false, 3));
        mQuestionBank.add(new Question(R.string.questao4, false, 1));
        mQuestionBank.add(new Question(R.string.questao5, false, 1));

        Collections.sort(mQuestionBank);


        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextButton = (Button) findViewById(R.id.next_button);
        mPrevButton = (Button) findViewById(R.id.prev_button);
        mCheatButton = (Button) findViewById(R.id.cheat_button);

        updateQuestion();

        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nextQuestion(1);
                updateQuestion();
            }
        });

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkAnswer(true);
                nextQuestion(1);
                updateQuestion();
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkAnswer(false);
                nextQuestion(1);
                updateQuestion();
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nextQuestion(1);
                updateQuestion();
            }
        });

        mPrevButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nextQuestion(-1);
                updateQuestion();
            }
        });

        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean answerIsTrue = mQuestionBank.get(mCurrentIndex).isAnswerTrue();
                Intent intent = CheatActivity.newIntent(QuizActivity.this, answerIsTrue);
                startActivity(intent);
            }
        });

    }

    private void updateQuestion() {
        int Question = mQuestionBank.get(mCurrentIndex).getTextResID();
        mQuestionTextView.setText(Question);
    }

    private void nextQuestion(int i) {
        mCurrentIndex = (mCurrentIndex + i) % mQuestionBank.size();
    }

    private void checkAnswer(boolean userPressedTrue) {
        int idMessagem = 0;

        if (userPressedTrue == mQuestionBank.get(mCurrentIndex).isAnswerTrue()) {
            idMessagem = R.string.correct_toast;
            pontos += 10;
        } else {
            idMessagem = R.string.incorrect_toast;
        }

        Toast.makeText(this, idMessagem, Toast.LENGTH_SHORT).show();
    }



    public TextView getQuestionTextView() {
        return mQuestionTextView;
    }

    public Button getTrueButton() {
        return mTrueButton;
    }

    public void setTrueButton(Button trueButton) {
        mTrueButton = trueButton;
    }

    public Button getFalseButton() {
        return mFalseButton;
    }

    public void setFalseButton(Button falseButton) {
        mFalseButton = falseButton;
    }

    public Button getNextButton() {
        return mNextButton;
    }

    public void setNextButton(Button nextButton) {
        mNextButton = nextButton;
    }

    public Button getPrevButton() {
        return mPrevButton;
    }

    public void setPrevButton(Button prevButton) {
        mPrevButton = prevButton;
    }

    public void setQuestionTextView(TextView questionTextView) {
        mQuestionTextView = questionTextView;
    }

    public List getQuestionBank() {
        return mQuestionBank;
    }

    public void setQuestionBank(List questionBank) {
        mQuestionBank = questionBank;
    }

    public int getCurrentIndex() {
        return mCurrentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        mCurrentIndex = currentIndex;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
