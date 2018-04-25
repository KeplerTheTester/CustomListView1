package test.dance.com.customlistview1;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import junit.framework.Test;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by OUI  CE MWEN on 18/03/2018.
 */

public class CustomListAdapter extends ArrayAdapter<TestClass> {

    Context context;
    int resource;
    List<TestClass> testClassList;
    List<TestClass> testClasses;
    boolean trial;
    public CustomListAdapter(Context context, int resource, List<TestClass> testClassList, List<TestClass> testClasses)
    {
        super(context, resource, testClassList);
        this.testClasses = testClasses;
        this.context = context;
        this.resource = resource;
        this.testClassList = testClassList;
    }
    public boolean setColor(boolean userPrompt)
    {
        this.trial = userPrompt;
        return trial;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        TestClass testClass = testClassList.get(position);

        View view = layoutInflater.inflate(resource, null);
        TextView descriptionText = (TextView) view.findViewById(R.id.description_textView);
        TextView titleText = (TextView) view.findViewById(R.id.title_textView);
        if(testClasses.contains(testClass)) {
            view.setBackgroundColor(Color.CYAN);
            //Toast.makeText(context, "Signed up for this already", Toast.LENGTH_SHORT).show();
        }
        if(testClass.getSignedUp() == true)
            view.setBackgroundColor(0Xac9c9300);
        if(trial == true)
            view.setBackgroundColor(Color.CYAN);
        descriptionText.setText(testClass.getDescription());
        titleText.setText(testClass.getTitle());
        return view;
    }
}
