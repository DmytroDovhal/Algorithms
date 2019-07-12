package lv_427.logic.kateryna_horokh;

import java.util.Scanner;

import lv_427.exceptions.WrongInputException;
import lv_427.logic.AlgorithmExecutor;

import static lv_427.exceptions.WrongInputException.WRONG_INPUT;

/**
 * Class for finding the total number of ways in which friends can remain single or can be paired
 * up.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
public class FriendPairs implements AlgorithmExecutor {

  private Scanner sc;

  public FriendPairs() {
    this.sc = new Scanner(System.in);
  }

  /** Method is for execute finding process. */
  public void execute() {

    System.out.println("Please enter the number: ");

    boolean isWrongInput = true;

    while (isWrongInput) {
      String input = sc.next();

      if (!input.matches("[0-9]+")) {
        throw new WrongInputException(WRONG_INPUT);
      }

      if (isWrongInput == false) {
        System.out.println("Try again.");
      } else {
        System.out.println("Result: " + findNumberOfWays(input));
        break;
      }
    }
  }

  /**
   * @param input - number which have to check how many ways
   * @return number of ways in which friends can remain single or can be paired up.
   */
  public int findNumberOfWays(String input) {

    int resultInput = Integer.parseInt(input);

    int numberOfWays[] = new int[resultInput + 1];

    // Filling dp[] in bottom-up manner using
    // recursive formula explained above.
    for (int i = 0; i <= resultInput; i++) {
      if (i <= 2) numberOfWays[i] = i;
      else numberOfWays[i] = numberOfWays[i - 1] + (i - 1) * numberOfWays[i - 2];
    }
    return numberOfWays[resultInput];
  }
}