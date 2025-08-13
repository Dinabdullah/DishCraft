package com.example.details_domain

data class DetailsDomainModel(
    val id: String?,
    val name: String?,
    val thumbnail: String?,
    val category: String?,
    val area: String?,
    val instructions: String?,
   // val tags: String?,
    val youtube: String?,
    val strSource: String?,
    val ingredients: List<String?>,
    val measures: List<String?>

)