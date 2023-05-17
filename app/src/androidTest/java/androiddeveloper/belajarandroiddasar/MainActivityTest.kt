package androiddeveloper.belajarandroiddasar

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.squareup.javawriter.JavaWriter.type
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering.Context

@RunWith(AndroidJUnit4::class)

class MainActivityTest {

//    lateinit var mainActivityScenario: ActivityScenario<MainActivity>
//
//    @Before
//    fun setUp() {
//        mainActivityScenario = ActivityScenario.launch(MainActivity::class.java)
//    }
//
//    @Test
//    fun testBlank() {
//
//    }
//
//    @After
//    fun tearDown() {
//        mainActivityScenario.close()
//    }

    @get:Rule
    var mainActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testBlank(){

        val context = ApplicationProvider.getApplicationContext<android.content.Context>()
        val name = "andri"

        onView(withId(R.id.nameET))
            .perform(typeText(name))

        onView(withId(R.id.sayButton))
            .perform(click())

        onView(withId(R.id.sayTV))
            .check(matches(withText(context.getString(R.string.sayTextView, name))))

        Thread.sleep(2000)
    }
}