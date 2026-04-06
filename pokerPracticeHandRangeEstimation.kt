data class PlayerContext(
    val hand: List<String>,
    val position: String
)

data class PokerGame(
    val deck: MutableList<String>,
    val user: PlayerContext,
    val board: MutableList<String> = mutableListOf(),
    val preflopActions: MutableList<String> = mutableListOf()
)


fun runPracticeRound(){
    var isGameEnd = false
    while(!isGameEnd){
        val deck = createDeck().apply { shuffle() }
        val (userContext, preflopActions, isGameEnd) = generatePreflopScenario(deck)
    }
    val game = PokerGame(deck, userContext, preflopActions = preflopActions.toMutableList())

    dealToBoard(game, 3)
    showBoard(game, "flop")

    dealToBoard(game, 1)
    showBoard(game, "turn")

    dealToBoard(game, 1)
    showBoard(game, "river")

    val isContinuePractice = askContinuePractice()

    return isContinuePractice
}

fun createDeck(): MutableList<String> {
    val ranks = listOf("2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A")
    val suits = listOf("H", "D", "C", "S")
    return ranks.flatMap { r -> suits.map { s -> r + s } }.toMutableList()
}

fun dealToBoard(game: PokerGame, count: Int) {
    repeat(count) {
        if (game.deck.isNotEmpty()) {
            game.board.add(game.deck.removeAt(0))
        }
    }
}

fun generatePreflopScenario(deck: MutableList<String>): PlayerContext, List<Map<String, String>>, Boolean{
    while(true){
        val userHand = listOf(deck.removeAt(0), deck.removeAt(0))
        val userPosition = listOf("UTG", "HJ", "CO", "BTN", "SB", "BB").random()
        val (preflopActions, isGameEnd) = generatePreflopActions(userHand, userPosition)

        return PlayerContext(userHand, userPosition), preflopActions, isGameEnd
    }
}
fun generatePreflopAction(userHand: List<String>, userPosition: String): List<MutableMap<String, String>>, isGameEnd: Boolean{
    opponentHand = generateRandomCards(2)
    opponentPosition = listOf("UTG", "HJ", "CO", "BTN", "SB", "BB").random()
    sortOrder = getSortOrder("preflop")
    remainingParticipants = 
    // -----------------bookmark-----------------
    return listOf(mutableMapOf()), false
}

fun generateRandomCards(numCards: Int): List<String>{
    // Implement logic to generate random cards
    var generatedCards = mutableListOf<String>()
    while(generatedCards.size < numCards){
        val card = generateRandomCard()
        if(!generatedCards.contains(card)){
            generatedCards.add(card)
        }
    }
    return generatedCards
}

fun generateRandomCard(): String{
    // Implement logic to generate a random card
    val ranks = listOf("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A")
    val suits = listOf("H", "D", "C", "S")
    val rank = ranks.random()
    val suit = suits.random()
    return rank + suit
}


fun getsortorder(stage: String): List<String>{
    // Implement logic to get the sort order based on the stage of the game
    if(stage == "preflop"){
        return listOf("UTG", "HJ", "CO", "BTN", "SB", "BB")
    } else {
        return listOf("SB", "BB", "UTG", "HJ", "CO", "BTN")
    }
}

fun main(){
    isContinuePractice = true
    while(isContinuePractice){
        isContinuePractice = runPracticeRound()
    }

    println("Thank you for practicing! See you next time.")
}