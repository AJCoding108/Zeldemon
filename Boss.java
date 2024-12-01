import java.util.Scanner;
public class Boss extends Enemy{
  private static int choice;
  
  public Boss(String name, int HP){
    super(name,HP);
  }

  public static void bossFight(Enemy obj, Hero heroObj, int maxNum, String color, Scanner userInput){
    Main.animateText(color + "You have encountered the Ultimate Zeldemon, Big Daddy Sooraj man...\n");
    System.out.println();
    while(obj.getEnemyHP() > 0){
      System.out.println("Which attack would you like to use?");
      if(heroObj.getLevel() < 5){
        heroObj.chooseAttackMove(maxNum, heroObj,userInput);
        obj.bossAttack(obj,heroObj);
        if(heroObj.getHP() < 0){
          System.out.println();
          Main.animateText(color + "Game over, try again next time...\n");
          System.exit(0);
        }
        choice = Main.getAttackChoice();
        heroObj.attack(choice, obj, heroObj);
      }
      else if(heroObj.getLevel() >= 5 && heroObj.getLevel() <= 10){
        heroObj.chooseAttackMove(maxNum + 1, heroObj,userInput);
        obj.bossAttack(obj,heroObj);
        if(heroObj.getHP() < 0){
          System.out.println();
          Main.animateText(color + "Game over, try again next time...\n");
          System.exit(0);
        }
        choice = Main.getAttackChoice();
        heroObj.attack(choice, obj, heroObj);
      }
      else if(heroObj.getLevel() > 10){
        heroObj.chooseAttackMove(maxNum + 2, heroObj,userInput);
        obj.bossAttack(obj,heroObj);
        if(heroObj.getHP() < 0){
          System.out.println();
          Main.animateText(color + "Game over, try again next time...\n");
          System.exit(0);
        }
        choice = Main.getAttackChoice();
        heroObj.attack(choice, obj, heroObj);
      }
    }
  }
}