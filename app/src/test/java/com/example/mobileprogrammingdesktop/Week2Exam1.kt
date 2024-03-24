package com.example.mobileprogrammingdesktop
import java.io.File

class Word(val engWord : List<String>, val korMean : List<String>){}

fun main(){
    val wordsList = mutableListOf<String>()
    File("C:\\Users\\s_vpfxm0831\\Desktop\\MobileProgramming\\app\\src\\test\\java\\com\\example\\mobileprogrammingdesktop\\words2.txt").useLines { lines -> lines.forEach { wordsList.add(it) }}
    val engWord = mutableListOf<String>()
    val korMean = mutableListOf<String>()
    val wordsList_size = wordsList.size
    for(i in 0..wordsList_size-1){
        when (i % 2) {
            0 -> {
                engWord.add(wordsList[i])
            }
            else -> {
                korMean.add(wordsList[i])
            }
        }
    }

    val words = Word(engWord, korMean)

    println("201710504 임찬혁")
    println("1)영어단어 검색 2)부분 영단어 검색(입력값으로 시작하는) 3)뜻 검색 4)종료")
    print("메뉴를 선택하세요 : ")
    var inputNumber:String? = readLine()

    while(true){
        when (inputNumber){
            "1" -> {
                print("찾을 영단어를 정확하게 입력하세요 : ")
                val engWordToFind:String? = readLine()
                val index = engWord.indexOf(engWordToFind)
                if(index == -1){
                    println("찾는 단어가 존재하지 않습니다.")
                }else{
                    println(engWord[index]+" : "+korMean[index])
                }
            }
            "2" -> {
                while(true){
                    print("찾을 영단어의 일부를 입력하세요 : ")
                    val engWordStartsWith:String? = readLine()
                    if(engWordStartsWith.isNullOrEmpty()){
                        println("빈칸은 입력하실 수 없습니다.")
                    }
                    else{
                        engWord.forEach{individualEngWord->
                            if(individualEngWord.startsWith(engWordStartsWith))
                                println(individualEngWord)
                        }
                        break
                    }

                }
            }
            "3" -> {
                while(true){
                    print("찾을 뜻을 입력하세요 (뜻의 일부만 포함) : ")
                    val korMeanContain:String? = readLine()
                    if(korMeanContain.isNullOrEmpty()){
                        println("빈칸은 입력하실 수 없습니다.")
                    }
                    else{
                        var korMeanContainExist : Int = 0
                        for(i in 0..wordsList_size/2-1)
                        {
                            if(korMean[i].contains(korMeanContain)) {
                                println(engWord[i]+" : "+korMean[i])
                                korMeanContainExist++
                            }
                        }
                        if(korMeanContainExist == 0){
                            println("찾을 뜻에 해당하는 단어가 없습니다.")
                        }
                        break
                    }

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
        println()
        println("1)영어단어 검색 2)부분 영단어 검색(입력값으로 시작하는) 3)뜻 검색 4)종료")
        print("메뉴를 선택하세요 : ")
        inputNumber = readLine()
    }
}