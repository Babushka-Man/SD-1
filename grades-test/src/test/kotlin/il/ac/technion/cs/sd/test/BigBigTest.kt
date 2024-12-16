package il.ac.technion.cs.sd.test
/** JUnit5 imports. Add more if needed */
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

import java.io.FileNotFoundException

import il.ac.technion.cs.sd.app.GradesReader
import il.ac.technion.cs.sd.app.GradesInitializer


class BigBigTest {

    private fun getGradesReader(fileName: String): GradesReader {
        val fileContents: String =
            javaClass.getResource(fileName)?.readText() ?:
            throw FileNotFoundException("Could not open file $fileName")

        val gradesInitializer = GradesInitializer()
        gradesInitializer.setup(fileContents)

        return GradesReader()
    }

    private val gradesReader = getGradesReader("numbers_file_1.txt")

//    @BeforeEach
//    fun `reset LineStorage`() {
//        LineStorage.reset()
//    }

    @Test
    fun `Succeed to get a student from large files`() {
        val gradesReader1 = getGradesReader("numbers_file_1.txt")
        Assertions.assertEquals(581, gradesReader1.getGrade("323244371"))
    }

    @Test
    fun `Get last grade from large file`() {
        Assertions.assertEquals(839, gradesReader.getGrade("486789589"))
    }

    @Test
    fun `Large file should return null`() {
        Assertions.assertEquals(null, gradesReader.getGrade("1"))
    }

}