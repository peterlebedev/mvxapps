package cz.lebedev.mvapp;

import android.view.View;
import android.widget.TextView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLooper;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */


@RunWith(RobolectricTestRunner.class)
public class RoboelectricTest {

    private MainActivity activity;

    @Before
    public void setUp() throws Exception
    {
        activity = Robolectric.buildActivity( MainActivity.class )
                .create()
                .resume()
                .get();
    }

    @Test
    public void shouldNotBeNull() throws Exception
    {
        assertNotNull( activity );
    }

    @Test
    public void shouldHaveButton() throws Exception
    {
        assertNotNull( activity.findViewById( R.id.but_update) );
    }

    @Test
    public void onClick() throws Exception
    {

        activity.findViewById( R.id.but_update).performClick();

        TextView tv = activity.findViewById(R.id.tv);

        ShadowLooper.pauseMainLooper();
        Robolectric.getForegroundThreadScheduler().advanceBy(3000);
        ShadowLooper.unPauseMainLooper();

        assertTrue(!tv.getText().toString().equals(DataModel.initData));
    }

    private boolean conditionIsMet(View v) {
        return v.getVisibility() == View.VISIBLE;
    }

}