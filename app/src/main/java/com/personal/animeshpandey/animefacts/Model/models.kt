package com.personal.animeshpandey.animefacts.Model



//typical response-->https://animechan.xyz/api/random
//{
//  "id": 7398,
//  "quote": "If you don’t want to die, think!",
//  "anime": "Attack on Titan",
//  "character": "Levi Ackerman"
//}


data class Quote(
        val id:Int,
        val quote:String,
        val anime:String,
        val character:String
)

data class QuoteResponse(val quote:Quote)
