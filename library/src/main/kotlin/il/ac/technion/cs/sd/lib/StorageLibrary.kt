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
                validateId(s.key)
                validateGrade(s.value)
                LineStorage.appendLine(s.key.toString() + " " + s.value.toString())
            }
    }

    fun getGrade(id: Int): Int? {
        // can make it more efficient probably

        validateId(id)

        val requestedStudentLine : String? = findStudentLine(id)

        return if (requestedStudentLine != null) getGradeFromStudentLine(requestedStudentLine) else null
    }

    private fun findStudentLine(id: Int): String? {
        var left = 0
        var right = LineStorage.numberOfLines() - 1
        var lastLine : String

        while (left <= right) {
            val mid = left + (right - left) / 2

            lastLine = LineStorage.read(mid)

            when {
                getIdFromStudentLine(lastLine) == id -> return lastLine
                getIdFromStudentLine(lastLine) < id -> left = mid + 1
                else -> right = mid - 1
            }
        }

        return null
    }

    private fun getIdFromStudentLine(line : String) : Int {
        return line.split(' ')[0].toInt()
    }

    private fun getGradeFromStudentLine(line : String) : Int {
        return line.split(' ')[1].toInt()
    }

    private fun validateId(id : Int) {
        if (id.toString().length > 9 || id < 0) {
            throw Exception(
                "Invalid student id: " + id +
                        ". Should be positive and up to 9 digits"
            )
        }
    }

    private fun validateGrade(grade : Int) {
        if (grade.toString().length > 3 || grade < 0) {
            throw Exception(
                "Invalid student grade: " + grade +
                        ". Should be positive and up to 3 digits"
            )
        }
    }
}