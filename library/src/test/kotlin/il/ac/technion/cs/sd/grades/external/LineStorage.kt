package il.ac.technion.cs.sd.grades.external

/**
 * This package and class override the external library
 * which was automatically imported to the project (you can view it under
 * the 'External Libraries' directory). This is NOT good practice but
 * was required for this assignment. In the following assignments
 * we will be using a different mechanism to achieve this behavior.
 *
 * You should implement this class for testing your library implementation.
 * Make sure it enforces the timing restrictions specified in the assignment PDF.
 * Note that your implementation will be overridden by staff code.
 * IMPORTANT: 1) DO NOT in any way alter the API of this class.
 *            2) DO NOT create any files under the package defined at the top of this file.
 */
class LineStorage {
    companion object {
        private val lines: MutableList<String> = mutableListOf()

        /** Appends a line to the END of the file */
        fun appendLine(line: String) {
            this.lines.add(line)
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
            return this.lines.size
        }

        /** This function is for clearing the state before each test! */
        fun reset() {
            this.lines.clear()
        }
    }
}