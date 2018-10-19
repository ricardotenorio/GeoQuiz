package ricardotenorio.geoquiz;

public class Question implements Comparable<Question>{

    private int mTextResID;
    private boolean mAnswerTrue;
    private int mDificulty;

    public Question(int id, boolean res, int dificulty){
        this.mTextResID = id;
        this.mAnswerTrue = res;
        this.mDificulty = dificulty;
    }

    @Override
    public int compareTo(Question otherQuestion) {

        if (this.mDificulty < otherQuestion.getDificulty())
            return -1;
        if (this.mDificulty > otherQuestion.getDificulty())
            return 1;
        return 0;
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

    public int getDificulty() {
        return mDificulty;
    }

    public void setDificulty(int dificulty) {
        mDificulty = dificulty;
    }

}
