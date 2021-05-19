import com.sun.org.slf4j.internal.LoggerFactory

class LoggingTest {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
    }

    fun loggingTest() {
        val util = UtilTest()
        util.warn(log)
    }
}