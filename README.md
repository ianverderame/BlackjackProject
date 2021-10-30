#BlackjackProject


## Description

This is my fourth project with Skill Distillery! This is a fully functional game of BlackJack! The program starts by dealing two cards to both the dealer and the player. The dealer's second card is, of course, played face down. The user is shown their two cards and the value of the two cards. If they have "BlackJack" (a hand value of 21 from the first two cards, meaning one is an Ace and the other is a 10, Jack, Queen, or King), the game is ended and the player wins! Otherwise, they have the option to either hit or stay. If they hit, then they are dealt another card, and shown the value of their hand. They are able to continue hitting or choose to stay until they bust, that is, go over 21. If they bust, the game is immediately ended and the player is told that they lost. If the player chooses to hit, and they have a resulting hand value over 21, but they also have an ace in their hand, then the ace's value is reduced from 11 to 1, and they can continue playing. At the end of each round, a counter is displayed with the users total wins, ties, and losses, and they are asked whether they want to play again. If they choose not to, then the final wins, ties, and losses are displayed.


##What I learned

This project really cemented my knowledge of object oriented programming. It was fun to work through the logic loops of how blackjack actually works, too. I think that this was made easier by having a much more concrete idea of the end product, which is a good lesson. In future programs, I think I will take more time on the planning phase so that I better understand the goal I'm working towards. Here, I already understood blackjack, which helped reduce planning time. 

At one point, I was trying to figure out how to reduce the Ace's value from 11 to 1, and I started by subtracting ten from the hand's value at every instance it was needed. I quickly realized that this was both tedious and not following good OOP principles. I instead looped through the hand itself, and if the value was over 21, the hand was looped through again to see if there was an ace. If there was, I subtracted 10 from the value (this couldn't happen on the same loop because the ace could appear before the value reached 21,  the opportunity to subtract 10 wouldn't appear, and the hand value would go over). This, along with a count of wins/losses/ties and getting BlackJack from the start, was extra programming that I wanted to do because I felt the program needed it, and I learned more because of it.

If I were to do this again, I think that I could even more heavily use OOP. I would add the hand as a List in the player classes themselves, rather than in my BlackJack App. This would allow both better encapsulation, and less to manage when I was passing objects through methods.

##Technologies Used
Java, Eclipse, Git, and Stack Overflow (although at one point it was down for maintenance and my brain crashed)