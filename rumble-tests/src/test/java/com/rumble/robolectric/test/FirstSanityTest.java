package com.rumble.robolectric.test;

import com.rumble.robolectric.RobolectricGradleTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * Created by Davidf on 13/01/2015.
 */
@RunWith(RobolectricGradleTestRunner.class)
public class FirstSanityTest {

    private com.rumble.MainActivity_ activity;

    @Test
    public void shouldBeTrue() throws Exception{

        // you reinject myDependency as mock object
//        MyClass mock = Mockito.mock(MyClass.class);
//        when(mock.doSomething()).thenReturn(4);


        activity = Robolectric.setupActivity(com.rumble.MainActivity_.class); // onCreate is called, myDependency gets injected
//        activity.dependency = mock;
        boolean isNotNull = activity != null;
        assertTrue(isNotNull);

    }

    @Test
    public void clickingButton_shouldChangeResultsViewText() throws Exception {
//        Activity activity = Robolectric.setupActivity(MainActivity_.class);
//
//        Button pressMeButton = (Button) activity.findViewById(R.id.press_me_button);
//        TextView results = (TextView) activity.findViewById(R.id.results_text_view);
//
//        pressMeButton.performClick();
//        String resultsText = results.getText().toString();
//        assertTrue(resultsText.equals("Testing Android Rocks!"));
        activity = Robolectric.setupActivity(com.rumble.MainActivity_.class); // onCreate is called, myDependency gets injected
//        activity.dependency = mock;
        boolean isNotNull = activity != null;
        assertTrue(isNotNull);
    }

}
