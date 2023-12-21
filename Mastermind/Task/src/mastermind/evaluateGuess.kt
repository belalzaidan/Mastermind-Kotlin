package mastermind

data class Evaluation(var rightPosition: Int, var wrongPosition: Int)


fun evaluateGuess(secret: String, guess: String): Evaluation {
    val secretList = secret.toMutableList()
    val guessList = guess.toMutableList()
    val evaluation = Evaluation(0,0)

    for (i in 0 until 4){
        if (secret[i] == guess[i]){
            secretList[i] = ' '
            guessList[i] = ' '
            evaluation.rightPosition++
        }
    }
    for (i in 0 until 4){
        if (secretList.contains(guessList[i]) && guessList[i] != ' '){
            secretList[secretList.indexOf(guessList[i])] = ' '
            guessList[i] = ' '
            evaluation.wrongPosition++
        }
    }


    return evaluation
}
