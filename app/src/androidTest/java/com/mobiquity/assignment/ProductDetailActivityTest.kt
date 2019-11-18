package com.mobiquity.assignment

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.mobiquity.assignment.view.ProductDetailActivity
import junit.framework.Assert.assertNotNull
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Rule
import org.junit.Test


/**
 * Created by Mehroze on 11/17/2019.
 */
class ProductDetailActivityTest {

    @Rule @JvmField
    var activityRule = ActivityTestRule(ProductDetailActivity::class.java)

    @Test
    fun testWidgetsNotNull() {

        assertNotNull("Activity is null", activityRule.activity)
        assertNotNull("Root LinearLayout is null",activityRule.activity.findViewById(R.id.layout_linear_root))
        assertNotNull("Image is null",activityRule.activity.findViewById(R.id.image))
        assertNotNull("Name is null",activityRule.activity.findViewById(R.id.name))
        assertNotNull("Price is null",activityRule.activity.findViewById(R.id.price))
    }
}