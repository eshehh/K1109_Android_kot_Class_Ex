package com.example.test3_2

// 최고 상위 영역 : 선언과 동시에 초깃값 할당.
val name = "이상용"
val name2:String = "이상용2"
val num1 = 10;

val data4 : Int by lazy {
    println("lazy 테스트")
    10
}

class MyClass2 {
    // 클래스 안에 영역 : 선언과 동시에 초깃값 할당.
//    var name4
    var name = "이상용3"
    var age = 40;
    val name2 = "이상용4"
    // val는 final 느낌 재할당 못한다
}

fun main() {

    val data10 : Array<Int> = Array(3,{0})
    data10[0] = 10
    data10[1] = 20
    data10.set(2,30)

    println(
        """
array size : ${data10.size}
array data : ${data10[0]}, ${data10[1]}, ${data10.get(2)}
"""
    )


    fun some ( data1: Int, data2: Int = 10) : Int {
        return data1 * data2
    }
    println(some(100))
    println(some(data2 = 100, data1 = 20))


    fun some2() : Nothing {
        throw Exception()
    }

    var apple : Int?
     apple = null

    var data13 : Nothing? = null

    var data12: Any = 10
    var data2: Any = "String"
    var data3: Any = MyClass2()

    fun test3() {
        println(data12)
        println(data2)
        println(data3)
    }
    var testxx = test3()
    println(testxx)


    fun sum(no: Int): Int {
        var sum = 0
        for (i in 1..no) {
            sum += i
        }
        return sum
    }

    val name: String = "yong"
    println("name : $name, sum : ${sum(10)}")


    val str1 = "hi \n yong"
    val str2 = """
        hi
        world
        """
    println("str1: $str1")
    println("str2: $str2")

    var data1: Int = 10

    data1 = data1 + 10
    data1 = data1.plus(10)

    // 함수 내부에서는 선언만 하는 것 가능
    var name10: String
    // MyClass2 myclass2 = new MyClass2();
    var myClass2 = MyClass2()
    myClass2.name = "이상용5"
    println("helloworld")
    println(myClass2.name)
    println(myClass2.age)
    println(myClass2.name2)
    println("lazy 테스트 및 결괏값 재할당해서 연산 확인 ")
    println(data4 + 10)

}