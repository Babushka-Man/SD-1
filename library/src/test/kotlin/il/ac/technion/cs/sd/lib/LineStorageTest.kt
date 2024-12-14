package il.ac.technion.cs.sd.lib

import il.ac.technion.cs.sd.grades.external.LineStorage
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.math.absoluteValue

class LineStorageTest {
    companion object {
        const val MARGIN_FOR_ERROR_IN_WAITING: Int = 20
    }

    // We want to make sure our methods take *long* enough for them to
    // simulate our desired API.
    private fun <T> assertWaited(milliseconds: Int, methodName: String, call: () -> T) {
        val before = java.time.Instant.now()
        call()
        val after = java.time.Instant.now()
        val delay = java.time.Duration.between(before, after)
        val error = (milliseconds.toLong() - delay.toMillis()).absoluteValue
        Assertions.assertTrue(
            error < MARGIN_FOR_ERROR_IN_WAITING,
            "'" + methodName + "' must take " + milliseconds +
            " milliseconds to run, but took " + delay.toMillis(),
        )
    }

    @BeforeEach
    fun `reset LineStorage`() {
        LineStorage.reset()
    }

    @Test
    fun `number of lines starts at zero`() {
        Assertions.assertEquals(0, LineStorage.numberOfLines())
    }

    @Test
    fun `numberOfLines takes 100ms to run`() {
        assertWaited(100, "numberOfLines", LineStorage::numberOfLines)
    }

    @Test
    fun `number of lines changes from 0 to 1 after appendLine`() {
        Assertions.assertEquals(0, LineStorage.numberOfLines())
        LineStorage.appendLine("")
        Assertions.assertEquals(1, LineStorage.numberOfLines())
    }

    @Test
    fun `read function returns correct line`() {
        LineStorage.appendLine("a")
        LineStorage.appendLine("b")
        LineStorage.appendLine("c")
        Assertions.assertEquals("b", LineStorage.read(1))
    }

    @Test
    fun `read takes 1ms per character`() {
        val s = "Yonatan Sheterenbergerpf!!! WHat a handsome man. WHat a main. seriesly. like hell dawg can I get a hug"
        LineStorage.appendLine(s)
        assertWaited(s.length, "read") { LineStorage.read(0) }
    }

    @Test
    fun `read of an empty line takes 0ms`() {
        val whatACoolStringgg = ""
        LineStorage.appendLine(whatACoolStringgg)
        assertWaited(whatACoolStringgg.length, "read") { LineStorage.read(0) }
    }
}