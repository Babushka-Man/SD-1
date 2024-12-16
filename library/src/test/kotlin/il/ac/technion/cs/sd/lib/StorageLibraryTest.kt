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

    @Test
    fun `get correct existing grade`(){
        StorageLibrary.setup(mapOf(214 to 100, 718 to 200, 123456 to 0))

        Assertions.assertEquals(100, StorageLibrary.getGrade(214))
        Assertions.assertEquals(200, StorageLibrary.getGrade(718))
        Assertions.assertEquals(0, StorageLibrary.getGrade(123456))
    }

    @Test
    fun `null on non existing id`(){
        StorageLibrary.setup(mapOf(123 to 321))
        Assertions.assertNull(StorageLibrary.getGrade(1))
    }

    @Test
    fun `throw on invalid id - negative`(){
        StorageLibrary.setup(mapOf(123 to 321))
        assertThrows<Exception> { StorageLibrary.getGrade(-1) }
    }

    @Test
    fun `throw on invalid id - more than 9 digits`(){
        StorageLibrary.setup(mapOf(123 to 321))
        assertThrows<Exception> { StorageLibrary.getGrade(1234567891) }
    }
}