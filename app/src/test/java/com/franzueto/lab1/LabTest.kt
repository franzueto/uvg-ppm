package com.franzueto.lab1

import org.junit.Test
import kotlin.test.*

class LabTest {
    @Test
    fun `Given a list, whem it has multiple elements, then result list should be correct`() {
        val result = processList(
            listOf(10, "Enero", null, true)
        )
        assertNotNull(result)
        assertTrue(result.size == 3)
        assertTrue(
            result[0].originalPos == 0
                    && result[0].originalValue == 10
                    && result[0].type?.lowercase() == "entero"
                    && result[0].info?.lowercase() == "m10"
        )

        assertTrue(
            result[1].originalPos == 1
                    && result[1].originalValue == "Enero"
                    && result[1].type?.lowercase() == "cadena"
                    && result[1].info?.lowercase() == "l5"
        )
        assertTrue(
            result[2].originalPos == 3
                    && result[2].originalValue == true
                    && result[2].type?.lowercase() == "booleano"
                    && result[2].info?.lowercase() == "verdadero"
        )
    }

    @Test
    fun `Given a null list, whem processList is called, then it returns null`() {
        val result = processList(null)
        assertNull(result)
    }

    @Test
    fun `Given a list, whem it has only null items, then it returns an empty list`() {
        // Case 1: multiple null items
        val result = processList(listOf(null, null, null, null, null))
        assertNotNull(result)
        assertTrue(result.isEmpty())

        // Case 2: empty list
        val result2 = processList(emptyList())
        assertNotNull(result2)
        assertTrue(result2.isEmpty())
    }

    @Test
    fun `Given a list, whem it has multiple elements, then result list should be correct in all values`() {
        val result = processList(
            listOf(20, 25, 2, 7, "hola", "", true, false, null, 2.0)
        )
        assertNotNull(result)
        assertTrue(result.size == 9)

        assertTrue(
            result[0].originalPos == 0
                    && result[0].originalValue == 20
                    && result[0].type?.lowercase() == "entero"
                    && result[0].info?.lowercase() == "m10"
        )

        assertTrue(
            result[1].originalPos == 1
                    && result[1].originalValue == 25
                    && result[1].type?.lowercase() == "entero"
                    && result[1].info?.lowercase() == "m5"
        )

        assertTrue(
            result[2].originalPos == 2
                    && result[2].originalValue == 2
                    && result[2].type?.lowercase() == "entero"
                    && result[2].info?.lowercase() == "m2"
        )

        assertTrue(
            result[3].originalPos == 3
                    && result[3].originalValue == 7
                    && result[3].type?.lowercase() == "entero"
                    && result[3].info == null
        )

        assertTrue(
            result[4].originalPos == 4
                    && result[4].originalValue == "hola"
                    && result[4].type?.lowercase() == "cadena"
                    && result[4].info?.lowercase() == "l4"
        )

        assertTrue(
            result[5].originalPos == 5
                    && result[5].originalValue == ""
                    && result[5].type?.lowercase() == "cadena"
                    && result[5].info?.lowercase() == "l0"
        )

        assertTrue(
            result[6].originalPos == 6
                    && result[6].originalValue == true
                    && result[6].type?.lowercase() == "booleano"
                    && result[6].info?.lowercase() == "verdadero"
        )

        assertTrue(
            result[7].originalPos == 7
                    && result[7].originalValue == false
                    && result[7].type?.lowercase() == "booleano"
                    && result[7].info?.lowercase() == "falso"
        )

        assertTrue(
            result[8].originalPos == 9
                    && result[8].originalValue == 2.0
                    && result[8].type == null
                    && result[8].info == null
        )
    }
}

// No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
    var type: String? = null,
    var info: String? = null
)
// -----------------------

//fun processList(inputList: List<Any?>?): List<ItemData>? {
//    val my = ArrayList<ItemData>()
//    //my.add(ItemData(0, 10, "entero", "m10"))
//    //my.add(ItemData(1, "Enero", "cadena", "l5"))
//    //my.add(ItemData(3, true, "booleano", "verdadero"))
//
//    my.add(ItemData(0, 20, "entero", "m10"))
//    my.add(ItemData(1, 25, "entero", "m5"))
//    my.add(ItemData(2, 2, "entero", "m2"))
//    my.add(ItemData(3, 7, "entero"))
//
//    my.add(ItemData(4, "hola", "cadena", "l4"))
//    my.add(ItemData(5, "", "cadena", "l0"))
//
//    my.add(ItemData(6, true, "booleano", "verdadero"))
//    my.add(ItemData(7, false, "booleano", "falso"))
//
//    my.add(ItemData(9, 2.0))
//
//    val x = ""
//
//    when (var result = x.toString()) {
//        " " -> println(" " + )
//        "x" = >
//    }
//
//    for (i in 0..10) {
//        println(i)
//    }
//
//    //return emptyList<ItemData>()
//    return my
//}

fun Int.info(): String? = when {
    this % 10 == 0 -> "M10"
    this % 5 == 0 -> "M5"
    this % 2 == 0 -> "M2"
    else -> null
}

fun processList(inputList: List<Any?>?): List<ItemData>? {
    return inputList?.mapIndexed { index, item ->
        when (item) {
            is Int -> ItemData(index, item, "entero", item.info())
            is String -> ItemData(index, item, "cadena", "L${item.length}")
            is Boolean -> ItemData(index, item, "booleano", if (item) "Verdadero" else "Falso")
            null -> null
            else -> ItemData(index, item)
        }
    }?.filterNotNull()
}