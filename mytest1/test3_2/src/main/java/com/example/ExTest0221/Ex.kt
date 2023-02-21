package com.example.ExTest0221

import java.util.*

class Ex {
     val Id: String? = null
     val Pw: String? = null
     val Email: String? = null
     val Phone: String? = null

    fun someFun() {
        val scanner = Scanner(System.`in`)

        println("아이디:")
        val Id: String = scanner.nextLine()
        println("비밀번호:")
        val Pw: String = scanner.nextLine()
        println("이메일:")
        val Email: String = scanner.nextLine()
        println("연락처:")
        val Phone: String = scanner.nextLine()


        println(Id)
        println(Pw)
        println(Email)
        println(Phone)
    }
}




    fun main(){
        val scanner = Scanner(System.`in`)

        println("아이디:")

        val Id: String = scanner.nextLine()
        println("비밀번호:")
        val Pw: String = scanner.nextLine()


        println(Id)
        println(Pw)

    }
