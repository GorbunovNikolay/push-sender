package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)


    val token = "e6R9qJDXTvawunS6ss8KmV:APA91bFJAOg8KyPJuL3fqS0K3RizBH3bElLc_Rcj7lBJFspEdWpP-rZAz3GMdvJreoqcKENOKOfPnVthxPMKKo4gvT2T5uiNPSTyAJpEDEjM88nrSsOAjgoRqRxDSLOQdi1P4fNj3lA7"
    val message = Message.builder()
        .putData("action", "LIKE")
        .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent())
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(message)
}


