package androiddeveloper.belajarandroiddasar

import org.junit.Assert
import org.junit.Test

class HelloTest {

    @Test
    fun testSayHello() {
        val result = Hello.sayHello("Andri")

        Assert.assertEquals("Hello Andri", result)
    }
}