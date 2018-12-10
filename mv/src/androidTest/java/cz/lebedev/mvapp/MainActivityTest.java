package cz.lebedev.mvapp;

import androidx.test.rule.ActivityTestRule;
import junit.framework.AssertionFailedError;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import static java.lang.Thread.sleep;
import static org.hamcrest.Matchers.not;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ensureTextChangesWork() throws InterruptedException {
        onView(withId(R.id.tv)).check(matches(withText(DataModel.initData)));

        onView(withId(R.id.but_update)).perform(click());

        while (!conditionIsMet()){
            sleep(100);
        }

        onView(withId(R.id.tv)).check(matches(not(withText(DataModel.initData))));
    }

    private boolean conditionIsMet() {
      try {
          onView(withId(R.id.tv)).check(matches(isDisplayed()));
          return true;
      } catch (AssertionFailedError e) {
          return false;
      }
    }

}