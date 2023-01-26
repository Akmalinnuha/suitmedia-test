package com.akmalinnuha.testsuitmedia

data class item_data(
    var page: Int = 2,
    val data: ArrayList<Students>
) {
    data class Students(
        val id: Int = 0,
        val email: String = "",
        var first_name: String = "",
        var last_name: String = "",
        var avatar: String = ""
    )
}
