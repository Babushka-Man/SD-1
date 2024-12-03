package il.ac.technion.cs.sd.lib

// TODO: Feel free to change anything here! This is not the final API

/**
 *
 */
class CsvParser {
    companion object {
        fun Parse(csv: String) : Csv {
            throw Exception("Implement me!")
        }
    }
}

data class Csv(val lines: List<CsvLine>)

data class CsvLine(val values: List<String>)