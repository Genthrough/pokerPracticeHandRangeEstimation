


func createPractice(){
    val myHand, preflopAction, boardFlop, remainingCards = initiateFlop()
    flopResult = showBoard(myHand, preflopAction, boardFlop)

    val boardTurn, remainingCardsAfterTurn = createBoardTurn(remainingCards)
    turnResult = showBoard(myHand, preflopAction, boardFlop, boardTurn)

    val boardRiver, remainingCardsAfterRiver = createBoardRiver(remainingCardsAfterTurn)
    riverResult =  showBoard(myHand, preflopAction, boardFlop, boardTurn, boardRiver)

    val isContinuePractice = askContinuePractice(flopResult, turnResult, riverResult)

    return isContinuePractice

}

func initiateFlop(): List<String>, List<String>, List<String>, List<String>{
    val myHand, preflopAction = gengerateInitialConditions()
    val boardFlop = generateRandomBoardFlop()
    val remainingCards = generateRemainingCards(myHand, boardFlop)

    return myHand, preflopAction, boardFlop, remainingCards
}

func gengerateInitialConditions(): List<String>, List<String>{
    
    return myHand, preflopAction
}

func main(){
    isContinuePractice = true
    while(isContinuePractice){
        isContinuePractice = createPractice()
    }

    println("Thank you for practicing! See you next time.")
}