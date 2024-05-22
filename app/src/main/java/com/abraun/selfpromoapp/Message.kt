package com.abraun.selfpromoapp

import java.io.Serializable

data class Message(
    val contactName: String,
    val contactNumber: String,
    val myDisplayName: String,
    val includeJunior: Boolean,
    val jobTitle: String?,
    val immediateStart: Boolean,
    val startDate: String
): Serializable {
    fun getFullJobDescr(): String = if (includeJunior) "junior $jobTitle" else "$jobTitle"

    fun getAvailability() = if (immediateStart) "immediately" else "from $startDate"
}