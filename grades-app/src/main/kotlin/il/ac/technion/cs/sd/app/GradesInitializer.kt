package il.ac.technion.cs.sd.app

import il.ac.technion.cs.sd.lib.CsvParser
import il.ac.technion.cs.sd.lib.StorageLibrary

/** This class will be instantiated once per test */
class GradesInitializer {
    /** Saves csvData persistently, so that it could be run using GradesRunner. */
    fun setup(csvData: String) {
        // TODO("Implement me!")

        val csv = CsvParser.Parse(csvData)
        val parsedGrades: Map<Int, Int> = parseGrades(csv)
        StorageLibrary.setup(parsedGrades)
    }
}
