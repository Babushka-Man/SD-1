package il.ac.technion.cs.sd.app

import il.ac.technion.cs.sd.lib.Csv
import il.ac.technion.cs.sd.lib.CsvParser
import il.ac.technion.cs.sd.lib.StorageLibrary

fun parseGrades(csv: Csv): Map<Int, Int> {
    val ret = emptyMap<Int, Int>().toMutableMap()
    for (line in csv.lines) {
        if (line.values.size != 2) {
            throw Exception()
        }
        val key = line.values[0].toInt()
        val value = line.values[1].toInt()
        ret[key] = value
    }
    return ret
}


/** This class will be instantiated once per test */
class GradesInitializer {

    /** Saves csvData persistently, so that it could be run using GradesRunner. */
    fun setup(csvData: String) {
        // TODO("Implement me!")

        val csv = CsvParser.parse(csvData)
        val parsedGrades: Map<Int, Int> = parseGrades(csv)
        StorageLibrary.setup(parsedGrades)
    }
}
