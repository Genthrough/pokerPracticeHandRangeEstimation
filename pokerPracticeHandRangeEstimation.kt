


func createPractice(){
    val myHandandPosition, preflopAction, boardFlop, usedCards = initiateFlop()
    flopResult = showBoard(myHandandPosition, preflopAction, boardFlop)

    val boardTurn, usedCardsAfterTurn = createBoardTurn(usedCards)
    turnResult = showBoard(myHandandPosition, preflopAction, boardFlop, boardTurn)

    val boardRiver, usedCardsAfterRiver = createBoardRiver(usedCardsAfterTurn)
    riverResult =  showBoard(myHandandPosition, preflopAction, boardFlop, boardTurn, boardRiver)

    val isContinuePractice = askContinuePractice(flopResult, turnResult, riverResult)

    return isContinuePractice

}

func initiateFlop(): List<String>, List<String>, List<String>, List<String>{
    val myHandandPosition, preflopAction = gengerateInitialConditions()
    val boardFlop = generateRandomBoardFlop()
    val usedCards = generateUsedCards(listOf(myHandandPosition["hand"]!!, boardFlop))

    return myHandandPosition, preflopAction, boardFlop, usedCards
}

func gengerateInitialConditions(): List<String>, List<String>{
    while(true){
        val myHandandPosition = generateRandomHandAndPosition()
        val preflopAction, isGameEnd = generatePreflopAction(myHandandPosition)

        if(!isGameEnd){
            return myHandandPosition, preflopAction
        }
    }
}

func generateRandomHandAndPosition(): mapOf<String, String>{
    val hand = generateRandomCards(2)
    val position = generateRandomPosition()

    return mapOf("hand" to hand, "position" to position)
}

func generaterandomcards(numCards: Int, usedCards: List<String> = mutableListOf<String>()): List<String>{
    // Implement logic to generate random cards
    generatedCards = mutableListOf<String>()
    while(generatedCards.size < numCards){
        val card = generateRandomCard()
        if(!usedCards.contains(card) && !generatedCards.contains(card)){
            generatedCards.add(card)
        }
    }
    return generatedCards
}

func generateRandomCard(): String{
    // Implement logic to generate a random card
    val ranks = listOf("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A")
    val suits = listOf("H", "D", "C", "S")
    val rank = ranks.random()
    val suit = suits.random()
    return rank + suit
}

func generateRandomPosition(): String{
    // Implement logic to generate a random position
    val positions = listOf("UTG", "HJ", "CO", "BTN", "SB", "BB")
    return positions.random()
}

func generatePreflopAction(myHandandPosition: Map<String, String>): List<MutableMap<String, String>>, isGameEnd: Boolean{
    // Implement logic to generate a random preflop action
    opponentHandandPosition = generateRandomHandAndPosition()
    sortOrder = getSortOrder("preflop")
    remainingParticipants = listOf(myHandandPosition, opponentHandandPosition).sortedBy{ map -> sortOrder.indexOf(map["position"]) }
    // -----------------bookmark-----------------
    return listOf(mutableMapOf()), false
}

func getsortorder(stage: String): List<String>{
    // Implement logic to get the sort order based on the stage of the game
    if(stage == "preflop"){
        return listOf("UTG", "HJ", "CO", "BTN", "SB", "BB")
    } else {
        return listOf("SB", "BB", "UTG", "HJ", "CO", "BTN")
    }
}

func main(){
    isContinuePractice = true
    while(isContinuePractice){
        isContinuePractice = createPractice()
    }

    println("Thank you for practicing! See you next time.")
}