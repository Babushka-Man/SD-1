import il.ac.technion.cs.sd.app.GradesReader
import il.ac.technion.cs.sd.grades.external.LineStorage
import il.ac.technion.cs.sd.lib.Csv
import il.ac.technion.cs.sd.lib.CsvLine
import il.ac.technion.cs.sd.lib.StorageLibrary
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GradesReaderTests {
    @BeforeEach
    fun `clear storage`() {
        LineStorage.reset()
    }

    @Test
    fun `reader reads grades from StorageLibrary`() {
        StorageLibrary.setup(mapOf(
            214762777 to 100,
            214762666 to 90,
        ))
        val r = GradesReader()
        Assertions.assertEquals(100, r.getGrade("214762777"))
        Assertions.assertEquals(90, r.getGrade("214762666"))
        Assertions.assertEquals(null, r.getGrade("214762555"))
    }

    @Test
    fun `reader on invalid id returns null`() {
        StorageLibrary.setup(mapOf(
            214762777 to 100,
            214762666 to 90,
        ))
        val r = GradesReader()
        Assertions.assertEquals(null, r.getGrade("Hello!"))
    }
}