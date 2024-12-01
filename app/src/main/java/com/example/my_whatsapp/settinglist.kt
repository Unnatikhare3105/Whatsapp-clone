package com.example.my_whatsapp

data class slist(
    val Icon: Int,
    val title: String,
    val description: String
)

class settinglist {
    var list = listOf<slist>(
        slist(R.drawable.key, "Account", "security notifications,change number"),
        slist(R.drawable.lock, "Privacy", "block contacts,disappearing messages"),
        slist(R.drawable.baseline_face_24,"avtar","create,edit profile picture"),
        slist(R.drawable.switch_account, "lists" , "Manage people and groups"),
        slist(R.drawable.chats, " Chats", "Theme , wallpaper and chat history"),
        slist(R.drawable.baseline_notifications_24, " Notifications", "messages, groups and call-tones"),
        slist(R.drawable.storage, "Storage and data", "network usage and data download"),
        slist(R.drawable.language, "app languages" , "English (device language"),
        slist(R.drawable.baseline_help_outline_24, "help", "Help center contact us, privacy policy"),
        slist(R.drawable.community, "invite the friends", ""),
        slist(R.drawable.update, "create group", "")
    )
}