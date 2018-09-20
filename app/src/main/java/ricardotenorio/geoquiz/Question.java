package ricardotenorio.geoquiz;

public class Question {

    private int mTextResID;
    private boolean mAnswerTrue;

    public Question(int id, boolean res){
        this.mTextResID = id;
        this.mAnswerTrue = res;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    public int getTextResID() {

        return mTextResID;
    }

    public void setTextResID(int textResID) {
        mTextResID = textResID;
    }
}
