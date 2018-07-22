package domain

import junit.framework.Assert.*
import org.junit.Test

internal class PairingMatrixDataTest {

    @Test
    fun `contains should give true if a pair contains the given member`() {
        val data = PairingMatrixData(pair1 = "pair1", pair2 = "pair2", days = 9)
        assertTrue(data.contains("pair1"))
        assertFalse(data.contains("pair3"))
    }

    @Test
    fun `getPair should give the pair`() {
        val data = PairingMatrixData(pair1 = "pair1", pair2 = "pair2", days = 9)
        assertEquals("pair2", data.getPair("pair1"))
        assertEquals("pair1", data.getPair("pair2"))
    }
}