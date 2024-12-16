package il.ac.technion.cs.sd.lib

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CsvParserTest {
    @Test
    fun `last line should be ignored if empty`() {
        val csv = CsvParser.parse("a,b\n")
        Assertions.assertEquals(Csv(listOf(CsvLine(listOf("a", "b")))), csv)
    }

    @Test
    fun `parse on empty string returns an empty csv`() {
        val csv = CsvParser.parse("")
        Assertions.assertEquals(Csv(emptyList()), csv)
    }

    @Test
    fun `parse on empty lines returns csv with empty lines`() {
        val emptyLine = CsvLine(emptyList())
        val expected = Csv(listOf(emptyLine, emptyLine, emptyLine, emptyLine, emptyLine))
        val csv = CsvParser.parse("\n".repeat(5))
        Assertions.assertEquals(expected, csv)
    }

    @Test
    fun `parse on representative input parses correctly`() {
        val input = """
            yonatan,elm
            yonatan,java
            21462623,beard
        """.trimIndent()
        val csv = CsvParser.parse(input)
        // Test the lengths!
        Assertions.assertEquals(3, csv.lines.size)
        csv.lines.forEach { Assertions.assertEquals(2, it.values.size) }
        // Test the values!
        Assertions.assertEquals("yonatan", csv.lines[0].values[0])
        Assertions.assertEquals("elm", csv.lines[0].values[1])
        Assertions.assertEquals("yonatan", csv.lines[1].values[0])
        Assertions.assertEquals("java", csv.lines[1].values[1])
        Assertions.assertEquals("21462623", csv.lines[2].values[0])
        Assertions.assertEquals("beard", csv.lines[2].values[1])
    }
}
