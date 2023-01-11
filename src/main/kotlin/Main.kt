object StockList {
    fun stockSummary(lstOfArt: Array<String>, lstOfCat: Array<String>): String {
        var result: String = ""
        if (lstOfArt.isEmpty() || lstOfCat.isEmpty()) return result

        val mapOfCategory: MutableMap<Char,Int> = lstOfCat.map{ it -> it.get(0) to 0}.toMap().toMutableMap()
        for (art in lstOfArt){
            if(mapOfCategory.containsKey(art.get(0))) {
                    mapOfCategory[art.get(0)] = mapOfCategory[art.get(0)]?.plus(art.split(" ").get(1).toInt()) ?: 0
                }
        }

        for (mapCat in mapOfCategory){
            if(mapCat.value != 0) {
                val elementView: String = String.format("(%c : %d) ", mapCat.key, mapCat.value)
                result += elementView
            }
        }
        result = result.trim().replace(") (", ") - (")
        return result
    }

}

fun main() {
    println(StockList.stockSummary(arrayOf("ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"), arrayOf<String>("A", "B")).toString())
}