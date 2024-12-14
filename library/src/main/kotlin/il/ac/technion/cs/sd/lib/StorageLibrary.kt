package il.ac.technion.cs.sd.lib

import il.ac.technion.cs.sd.grades.external.LineStorage


/**
 * Implement your library here. Feel free to change the class name,
 * but note that if you choose to change the class name,
 * you will need to update the import statements in GradesInitializer.kt
 * and in GradesReader.kt.
 */
object StorageLibrary {
    fun setup(studentGrades: Map<Int, Int>) {
        val sortedStudentGrades = studentGrades.toSortedMap()

        sortedStudentGrades
            .forEach { s ->
                if (s.key.toString().length > 9 || s.key < 0) {
                    throw Exception(
                        "Invalid student id: " + s.key +
                                ". Should be positive and up to 9 digits"
                    )
                }
                if (s.value.toString().length > 3 || s.value < 0)
                {
                    throw Exception(
                        "Invalid student grade: " + s.value +
                                ". Should be positive and up to 3 digits"
                    )
                }
                LineStorage.appendLine(s.key.toString() + " " + s.value.toString())
            }
    }

    fun getGrade(id: Int): Int? {
        TODO()
    }
}