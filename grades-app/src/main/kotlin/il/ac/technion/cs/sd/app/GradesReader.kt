package il.ac.technion.cs.sd.app

import il.ac.technion.cs.sd.lib.StorageLibrary

private fun isValidId(id: String): Boolean {
    return id.matches(Regex("[0-9]{0,9}"))
}

/**
 * This class will only be instantiated after
 * GradesInitializer has been called
 */
class GradesReader {
    /** Returns the grade associated with 'id', or null */
    fun getGrade(id: String): Int? {
        if (!isValidId(id)) return null
        return StorageLibrary.getGrade(id.toInt())
    }
}
