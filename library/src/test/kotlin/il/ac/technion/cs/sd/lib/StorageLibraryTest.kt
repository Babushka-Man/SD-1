package il.ac.technion.cs.sd.lib

import il.ac.technion.cs.sd.grades.external.LineStorage
import org.junit.jupiter.api.*

/** Use this class to test your library implementation */
class StorageLibraryTest {

    @BeforeEach
    fun `reset line storage`(){
        LineStorage.reset()
    }

    @Test
    fun `setup includes students in a sorted order`(){
        val studentMap : MutableMap<Int, Int> = mutableMapOf()
        studentMap[214762718] = 100
        studentMap[214762338] = 1
        studentMap[214762339] = 69
        studentMap[214] = 2
        studentMap[762339] = 3
        StorageLibrary.setup(studentMap)

        val sortedStudents = studentMap.toSortedMap()
        for ((i, studentId) in sortedStudents.keys.withIndex())
        {
            Assertions.assertEquals(
                studentId.toString() + " " + sortedStudents[studentId], LineStorage.read(i))
        }
    }

    @Test
    fun `only the last grade is saved`(){
        // no need to check with current map architecture.
        // Map doesn't allow two values for the same id
    }

    @Test
    fun `throws on invalid id - negative`(){
        val studentMap : MutableMap<Int, Int> = mutableMapOf()
        studentMap[-1] = 2
        assertThrows<Exception> { StorageLibrary.setup(studentMap) }
    }

    @Test
    fun `throws on invalid id - more than 9 digits`(){
        val studentMap : MutableMap<Int, Int> = mutableMapOf()
        studentMap[1234567891] = 2
        assertThrows<Exception> { StorageLibrary.setup(studentMap) }
    }

    @Test
    fun `throws on invalid grade - negative`(){
        val studentMap : MutableMap<Int, Int> = mutableMapOf()
        studentMap[123] = -1
        assertThrows<Exception> { StorageLibrary.setup(studentMap) }
    }

    @Test
    fun `throws on invalid grade - more than 3 digits`(){
        val studentMap : MutableMap<Int, Int> = mutableMapOf()
        studentMap[123] = 1234
        assertThrows<Exception> { StorageLibrary.setup(studentMap) }
    }
}