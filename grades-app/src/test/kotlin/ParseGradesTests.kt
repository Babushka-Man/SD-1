import il.ac.technion.cs.sd.app.parseGrades
import il.ac.technion.cs.sd.lib.Csv
import il.ac.technion.cs.sd.lib.CsvLine
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ParseGradesTests {
    @Test
    fun `parse empty returns empty`() {
        val expected = parseGrades(Csv(emptyList()))
        val actual = emptyMap<Int, Int>()
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `parse valid csv works`() {
        val expected = parseGrades(Csv(listOf(
            CsvLine(listOf("123", "3")),
            CsvLine(listOf("124", "4")),
            CsvLine(listOf("524", "99")),
        )))
        val actual = mapOf(
            123 to 3,
            124 to 4,
            524 to 99,
        )
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `parse on throws on non integer ids`() {
        val badInput = Csv(listOf(
            CsvLine(listOf("123", "3")),
            CsvLine(listOf("1a24", "4")),
            CsvLine(listOf("524", "99")),
        ))
        Assertions.assertThrows(Exception::class.java) {
            parseGrades(badInput)
        }
    }
}