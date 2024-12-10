package il.ac.technion.cs.sd.app

import il.ac.technion.cs.sd.lib.StorageLibrary

/**
 * This class will only be instantiated after
 * GradesInitializer has been called
 */
class GradesReader {
    /** Returns the grade associated with 'id', or null */
    fun getGrade(id: String): Int? {
        // TODO("Implement me!")
        if (!isValidId(id)) return null
        return StorageLibrary.getGrade(id)
    }
}