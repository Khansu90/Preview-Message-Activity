package com.example.khansusself_promoapp

data class Message(
    val contactName: String,
    val contactNumber: String,
    val myDisplayName: String,
    val checkBoxJunior: Boolean,
    val checkBoxImmediateStart: Boolean,
    val jobTitle: String?,
    val startDate: String
):java.io.Serializable {


    fun getYourFullJobTitle():String = if (checkBoxJunior) "a Junior $jobTitle" else "an Junior $jobTitle"
    fun date():String = if (checkBoxImmediateStart) "immediately" else "start from $startDate"
}