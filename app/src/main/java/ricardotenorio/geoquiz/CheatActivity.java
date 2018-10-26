package ricardotenorio.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String EXTRA_ANSWER_IS_TRUE = "ricardotenorio.geoquiz.answer_is_true";

    private boolean answer;
    private TextView questionTxt;
    private Button showAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        answer = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        questionTxt = (TextView) findViewById(R.id.answer_text_view);
        showAnswer = (Button) findViewById(R.id.show_answer_bt);
    }

    public static Intent newIntent(Context packageContext, boolean answerIsTrue){
        Intent intent = new Intent(packageContext, CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return intent;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public static String getExtraAnswerIsTrue() {
        return EXTRA_ANSWER_IS_TRUE;
    }
}
