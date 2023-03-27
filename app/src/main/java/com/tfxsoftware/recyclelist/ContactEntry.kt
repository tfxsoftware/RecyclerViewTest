package com.tfxsoftware.recyclelist

import java.io.Serializable

data class ContactEntry (val name: String,
                    val number: String) : Serializable
{
    override fun toString(): String{
        return "$name"
    }
}




