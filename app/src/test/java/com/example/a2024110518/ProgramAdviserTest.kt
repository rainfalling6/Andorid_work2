package com.example.a2024110518

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ProgramAdviserTest {

    private val adviser = ProgramAdviser()

    @Test
    fun query_validIndex_returnsProgramInfo() {
        val result = adviser.query(0)
        assertTrue(result.contains("SE"))
        assertTrue(result.contains("软件工程"))
    }

    @Test
    fun query_allIndexesReturnNonEmpty() {
        for (i in 0 until adviser.size) {
            assertTrue(adviser.query(i).isNotEmpty())
        }
    }

    @Test
    fun query_outOfRange_returnsNotFoundMessage() {
        assertEquals("未找到对应专业", adviser.query(-1))
        assertEquals("未找到对应专业", adviser.query(adviser.size))
    }
}
