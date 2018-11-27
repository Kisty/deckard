package com.example.activity

import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DeckardActivityTest {

    @get:Rule
    var rule: ActivityTestRule<DeckardActivity> = ActivityTestRule(DeckardActivity::class.java)

    @Test
    fun testSomething() {
        assertNotNull(ApplicationProvider.getApplicationContext())
        assertTrue(rule.activity != null)
    }

    @Test
    fun testText() {
        onView(withText("Hello Espresso!")).check(matches(isCompletelyDisplayed()))
    }

    @Test
    fun testTitle() {
        onView(withText("Deckard")).check(matches(isCompletelyDisplayed()))
    }
}