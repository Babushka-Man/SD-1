package il.ac.technion.cs.sd.lib

// TODO: Feel free to change anything here! This is not the final API

/**
 *
 */
class CsvParser {
    companion object {
        private fun shouldLastBefore(lines: List<String>): Boolean {
            return lines.isNotEmpty() && lines.last().isEmpty()
        }

        private fun parseLine(line: String): CsvLine {
            if (line.trim().isEmpty()) {
                return CsvLine(emptyList())
            }
            return CsvLine(line.split(",").map { s -> s.trim {c -> " \r\n".contains(c)} })
        }

        fun parse(csv: String) : Csv {
            val lines = csv.split("\n")
            val skipped = (if (shouldLastBefore(lines)) lines.subList(0, lines.lastIndex) else lines)
            val parsed = skipped.map(CsvParser::parseLine)
            return Csv(parsed)
        }
    }
}

data class Csv(val lines: List<CsvLine>)

data class CsvLine(val values: List<String>)
