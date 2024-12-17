package il.ac.technion.cs.sd.lib

class LineStorageInner {
    companion object {
        private val lines: MutableList<String> = mutableListOf()

        /** Appends a line to the END of the file */
        fun appendLine(line: String) {
            lines.add(line)
        }

        /** Returns the line at index lineNumber (0-indexed) */
        fun read(lineNumber: Int): String {
            val line = lines[lineNumber]
            val delay: Long = line.length.toLong()
            Thread.sleep(delay)
            return line
        }

        /** Returns the total number of lines in the file */
        fun numberOfLines(): Int {
            Thread.sleep(100)
            return lines.size
        }

        /** This function is for clearing the state before each test! */
        fun reset() {
            lines.clear()
        }
    }
}
