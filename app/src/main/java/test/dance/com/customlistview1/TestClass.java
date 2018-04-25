package test.dance.com.customlistview1;

/**
 * Created by OUI  CE MWEN on 18/03/2018.
 */

public class TestClass {
    String title;
    String description;
    boolean signedUp;

    public TestClass(String title, String description)
    {
        this.title = title;
        this.description = description;
    }
    public TestClass(String title, String description, boolean signedUp) {
        this.title = title;
        this.description = description;
        this.signedUp = signedUp;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setSignedUp(boolean signedUp) {
        this.signedUp = signedUp;
    }

    public boolean getSignedUp()
    {
        return signedUp;

    }
}
