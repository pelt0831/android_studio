package com.example.mobileprogrammingdesktop

fun main(){
    println("201710504 임찬혁")
    print("1)오름차순 2)내림차순 3)차씨 찾기 4)종료 : ")
    var inputNumber:String? = readLine()

    val nameArray = arrayOf("김길동", "오길동", "이길동", "차길동", "차승원", "차은우", "홍길동", "이차돌")

    while(true){
        when (inputNumber){
            "1" -> {
                nameArray.sort()
                for(name in nameArray) {
                    println(name)
                }
            }
            "2" -> {
                nameArray.sortDescending()
                for(name in nameArray){
                    println(name)
                }
            }
            "3" -> {
                nameArray.forEach{name->
                    if(name.startsWith("차"))
                        println(name)
                }
            }
            "4" -> {
                println("프로세스를 종료합니다.")
                break
            }
            else -> {
                println("다시 입력해주세요.")
            }

        }
        print("1)오름차순 2)내림차순 3)차씨 찾기 4)종료 : ")
        inputNumber = readLine()
    }
}
