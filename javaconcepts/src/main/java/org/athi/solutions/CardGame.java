package org.athi.solutions;

/**
 * Date:   3/23/2019
 *
 * @author amuthukumarasamy
 */
/*
 *
 * Revision Date    Revised By  Description
 * ---------------------------------------------------
 *
 * ---------------------------------------------------
 */
public class CardGame {
    final static char[] ranks = {'2', '3','4','5','6','7','8', '9', 'T', 'J', 'Q', 'K', 'A'};
    //final static String[] ranks = {"2", "3","4","5","6","7","8", "9", "T", "J", "Q", "K", "A"};

    public static void main(String[] args) {
        System.out.println(solution("A586QK", "JJ653K"));
        System.out.println(solution("23A84Q", "K2Q25J"));

        /*Card[][] hands = new Card[2][1];
        Deck myDeck = new Deck();

        //reduced this to 26 iterations because two cards are dealt each iteration
        for (int i = 0; i < 26; i++) {
            System.out.printf("\n Round %s of The War \n", i);

            //You really don't need to loop just once here...
            //Simply assign the card to hands[player][0] since that's the only option
            //for (int c = 0; c < 1; c++)
            for (int player = 0; player < hands.length; player++)
                hands[player][0] = myDeck.dealCard();

            for (int player = 0; player < hands.length; player++) {
                System.out.printf("Player %d: ", player);
                printHand(hands[player]);
            }

            int player1 = hands[0][0].getValue(); //get the value from the Card object
            int player2 = hands[1][0].getValue();

            if (player1 > player2)
                System.out.println("Player One Wins The War");
            else if (player2 > player1)
                System.out.println("Player Two Wins The War");
            else
                System.out.println("The War Is A Tie");

        }
    }

    public static void printHand(Card[] hand) {
        for (int card = 0; card < hand.length; card++)
            System.out.printf("%s", hand[card].toString());
        System.out.println();

    }*/
    }

    public static int solution(String A, String B) {
        // write your code in Java SE 8
        int alecWinCount = 0;
        char firstHand = 0, secondHand = 0;
        int firstHandNum = 0, secondHandNum = 0;
        char[] alec = A.toCharArray();
        char[] bob = B.toCharArray();
        for (int i = 0, n = alec.length; i < n; i++) {
            firstHand = alec[i];

            firstHandNum = new String(ranks).indexOf(firstHand);
            //firstCardNum = (firstHand >= 0 && firstHand <= 13)? firstHand: 0;
            //for (int j = 0, m = bob.length; j < m; j++) {
            secondHand = bob[i];
            secondHandNum = new String(ranks).indexOf(secondHand);;
            //secondHandNum = (secondHand >= 0 && secondHand <= 13)? secondHand: 0;
            //}

            System.out.printf("%s, %s, %d, %d\n", firstHand, secondHand, firstHandNum, secondHandNum);
            if (firstHand > secondHand)
                alecWinCount++;
        }
        System.out.println("Alec win count = " + alecWinCount);
        return alecWinCount+1;
    }
}
