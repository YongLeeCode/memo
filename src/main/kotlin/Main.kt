import java.awt.im.InputContext

fun main(args: Array<String>) {
    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    var title_list: ArrayList<String> = arrayListOf<String>("Hello World", "pillow is best!")
    var script_list: ArrayList<String> = arrayListOf<String>("This is a Hello World", "I need to buy a new pillow")

    var choice : Int = 1
    while (choice != 0){
        print("")
        println("0) Exit")
        println("1) Add New memo")
        println("2) Search your memo")
        println("3) Delete memo")
        println("-------------------")
        choice = readln()!!.toInt()
        print("")

        if (choice == 1){
            add_new_memo(title_list, script_list)
        }
        else if (choice == 2){
            search_memo(title_list, script_list)
        }
        else if (choice == 3){
            delete_memo(title_list, script_list)
        }
        else if (choice == 0){
            println("Bye")
        }
        else {
            println("-------------------------------")
            println("type correct number(0, 1, 2, 3)")
            println("-------------------------------")
        }
    }
}

fun add_new_memo(a: ArrayList<String>, b: ArrayList<String>){
    print("Title Name: ")
    var title = readln()

    print("memo: ")
    var memo = readln()

    a.add(title)
    b.add(memo)

    println("")
    println("success to add the memo")
}

fun delete_memo(a: ArrayList<String>, b: ArrayList<String>){

    if(a.size == 0){
        println("No saved memo. Please add new memo.")
        return
    }

    var count = 0
    println("Title")
    println("--------------------------------------------------")
    for(num in a){
        count += 1
        println("$count) $num")
    }
    println("--------------------------------------------------")
    println(">>Which memo do you want to delete?(choose number)<<")
    var pick = readln()!!.toInt()
    pick -= 1
    while (pick > a.size){
        println("Please type correct number: ")
        pick = readln()!!.toInt()
        pick -= 1
    }
    a.remove(a[pick])
    b.remove(b[pick])

    println("success to delete the memo")
}

fun search_memo(a: ArrayList<String>, b: ArrayList<String>){

    if(a.size == 0){
        println("No saved memo. Please add new memo.")
        return
    }

    println("--------------------------")
    println("Select Query")
    println("1) Show All Title")
    println("2) Show All Title and Memo")
    println("3) Show one Title and Memo")
    println("--------------------------")
    print("type number: ")
    var pick = readln()!!.toInt()
    var tf = true
    if (pick > 3 || pick < 1){
        tf = false
    }
    while (tf != true){
        println("Please type correct number: ")
        pick = readln()!!.toInt()
        if (pick <= 3 && pick >= 1){
            tf = true
        }
    }
    if(pick == 1){
        var count = 0
        println("Title")
        println("------------------------------")
        for(num in a.indices){
            count += 1
            println("$count) title: ${a[num]}")
        }
        println("------------------------------")
    }
    else if(pick == 2) {
        var count = 0
        println("Title           /memo")
        for(num in a.indices){
            count += 1
            println("------------------------------")
            println("$count) title: ${a[num]}")
            println("memo: ${b[num]}")
        }
        println("------------------------------")
    }

    else if(pick == 3) {
        var count = 0
        println("Title")
        println("--------------------------------------------------")
        for(num in a){
            count += 1
            println("$count) $num")
        }
        println("--------------------------------------------------")
        println(">>Choose number for reading your memo<<")
        var pick = readln()!!.toInt()
        pick -= 1

        println("")
        println("===================================================")
        println("title: ${a[pick]}")
        println("memo: ${b[pick]}")
        println("===================================================")
        println("")
    }
    else {
        println("error")
    }
}
