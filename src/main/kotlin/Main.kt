/* 1) Creare una sealed class chiamata Numeri che avrà come sottoclassi Interi e Float
2) Entrambe le sottoclassi avranno come parametri del costruttore una lista basata sul tipo della sottoclasse, un id di tipo Stringa,
 un parametro message di tipo Stringa con un valore predefinito
3) Crea una o più ext fun che accetta in input una lista e la trasforma in una lista di String
4) Crea un metodo dove nella signature hai un oggetto "Numeri" e con un when analizzi che tipo di oggetto è facendo stampare a video il tipo trovato.
5) A partire dal punto precedente filtri la lista degli oggetti di tipo "Numeri" secondo un parametro di tua scelta
6) Partendo dal punto 4 utilizzi la ext fun corretta per trasformare la lista risultante nella lista di String e stampare ogni singolo elemento. */

sealed class Numeri(){}

class Interi(val list: List<Int>, val id: String, val message: String = "ciao"):Numeri(){}

class Virgola(val list: List<Float>, val id: String, val message: String = "ciao"):Numeri() {}

fun transformToString(list1: List<Int>): List<String>{
    val list: MutableList<String> = mutableListOf()
    list1.forEach {it -> list.add(it.toString())}
    return list
}

fun transformToString2(list1: List<Float>): List<String>{
    val list: MutableList<String> = mutableListOf()
    list1.forEach {it -> list.add(it.toString())}
    return list
}

fun typeOfObject(myObject:Numeri){
    when(myObject){
        is Interi -> println("Type of the object: Interi")
        is Virgola -> println("Type of the object: Virgola")
    }
}

fun main(){
    val interi = Interi(listOf(5,6,7,12,15,20),"First string")
    val virgola = Virgola(listOf(3.5f,7.2f,15.3f,9.1f,10.5f,2.3f),"First string")

    typeOfObject(interi)
    println("---------------")
    typeOfObject(virgola)
    println("---------------")

    println("Filtered lists of Int:")
    interi.list.filter { it -> it < 12 }.forEach { it -> println(it) }
    println("---------------")
    println("Filtered list of Float:")
    virgola.list.filter { it -> it >= 9.1 || it < 7.2 }.forEach { it -> println(it) }
    println("---------------")

    println("List of Int transformed to String:")
    transformToString(interi.list).forEach { it -> println("$it") }
    println("---------------")
    println("List of Float transformed to String:")
    transformToString2(virgola.list).forEach { it -> println("$it") }





}