package il.ac.technion.cs.sd.lib

// TODO: Feel free to change anything here! This is not the final API

/**
 *
 */
class CsvParser {
    companion object {
        private fun parseLine(line: String): CsvLine {
            if (line.trim().isEmpty()) {
                return CsvLine(emptyList())
            }
            return CsvLine(line.split(","))
        }

        fun parse(csv: String) : Csv {
            val lines = csv.split("\n").map(::parseLine)
            return Csv(lines)
        }
    }
}

data class Csv(val lines: List<CsvLine>)

data class CsvLine(val values: List<String>)
