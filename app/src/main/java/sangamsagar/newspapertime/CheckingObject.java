package sangamsagar.newspapertime;

public class CheckingObject {

    private int mDrawable;
    private String mName;
    private float mRating;

    public CheckingObject(String name, int drawable, float rating) {
        mName = name;
        mDrawable = drawable;
        mRating = rating;
    }

    public float getRating() {
        return mRating;
    }

    public int getDrawable() {
        return mDrawable;
    }

    public String getName() {
        return mName;
    }
}