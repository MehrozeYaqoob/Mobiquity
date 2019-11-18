package com.mobiquity.assignment

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test

/**
 * Created by Mehroze on 11/18/2019.
 */
class MainActivityTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testWidgetsNotNull() {
        assertNotNull("Activity is null", activityRule.activity)
        assertNotNull("SwipeRefresh is null", activityRule.activity.findViewById(R.id.pullToRefresh))
        assertNotNull("RecyclerView is null", activityRule.activity.findViewById(R.id.recyclerview))
     }

    @Test
    fun areViewDisplayed(){
        onView(withId(R.id.pullToRefresh)).check(matches((isDisplayed())))
        onView(withId(R.id.recyclerview)).check(matches((isDisplayed())))
    }
}