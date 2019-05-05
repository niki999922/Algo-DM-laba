import java.io.File
import java.lang.Long.max

fun main() {
    val input = File("rps2.in").readLines()
    val input1 = input[0].split(' ')
    val input2 = input[1].split(' ')
    val r1 = input1[0].toLong()
    val s1 = input1[1].toLong()
    val p1 = input1[2].toLong()
    val r2 = input2[0].toLong()
    val s2 = input2[1].toLong()
    val p2 = input2[2].toLong()
    File("rps2.out").writeText(max(0, max(r1 - r2 - p2, max(s1 - s2 - r2, p1 - p2 - s2))).toString())
}
