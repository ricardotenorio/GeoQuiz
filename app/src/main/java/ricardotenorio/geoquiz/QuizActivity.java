package ricardotenorio.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private ImageButton mTrueButton;
    private ImageButton mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPrevButton;
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
        mTrueButton = (ImageButton) findViewById(R.id.true_button);
        mFalseButton = (ImageButton) findViewById(R.id.false_button);
        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mPrevButton = (ImageButton) findViewById(R.id.prev_button);

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

    public ImageButton getTrueButton() {
        return mTrueButton;
    }

    public void setTrueButton(ImageButton trueButton) {
        mTrueButton = trueButton;
    }

    public ImageButton getFalseButton() {
        return mFalseButton;
    }

    public void setFalseButton(ImageButton falseButton) {
        mFalseButton = falseButton;
    }

    public ImageButton getNextButton() {
        return mNextButton;
    }

    public void setNextButton(ImageButton nextButton) {
        mNextButton = nextButton;
    }

    public ImageButton getPrevButton() {
        return mPrevButton;
    }

    public void setPrevButton(ImageButton prevButton) {
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
