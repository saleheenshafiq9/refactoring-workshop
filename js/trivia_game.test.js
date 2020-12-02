const Game = require("./trivia_game.js")

describe("The test environment", () => {
  
  xit("an example usage", function () {
    let notAWinner = false

    let game = new Game()

    game.add("Chet")
    game.add("Pat")
    game.add("Sue")

    do {
      game.roll(Math.floor(Math.random() * 6) + 1)

      if (Math.floor(Math.random() * 10) == 7) {
        notAWinner = game.wrongAnswer()
      } else {
        notAWinner = game.wasCorrectlyAnswered()
      }
    } while (notAWinner)
  })
})
