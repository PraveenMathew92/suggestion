package domain

data class PairingMatrixData(val pair1: String, val pair2: String,  val days: Int) {
    fun contains(member: String): Boolean {
        return member == pair1 || member == pair2
    }

    fun getPair(first: String): String {
        return if (first == pair1) pair2 else pair1
    }
}