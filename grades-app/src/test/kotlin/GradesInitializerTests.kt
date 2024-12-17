import il.ac.technion.cs.sd.app.GradesInitializer
import il.ac.technion.cs.sd.grades.external.LineStorage
import il.ac.technion.cs.sd.lib.Csv
import il.ac.technion.cs.sd.lib.CsvLine
import il.ac.technion.cs.sd.lib.LineStorageInner
import il.ac.technion.cs.sd.lib.StorageLibrary
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GradesInitializerTests {
    @Test
    fun `initialize initializes grades to StorageLibrary`() {
        GradesInitializer().setup("""
            214762777,100
            214762666,90
        """.trimIndent())
        Assertions.assertEquals(100, StorageLibrary.getGrade(214762777))
        Assertions.assertEquals(90, StorageLibrary.getGrade(214762666))
        Assertions.assertEquals(null, StorageLibrary.getGrade(214762555))
    }
}