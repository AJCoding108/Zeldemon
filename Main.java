import java.util.Scanner;

//import Attacks;
//import Boss;
//import Enemy;
//import Hero;
//import World;

class Main {
  //sets text color to white
  private static final String defaultText = "\u001B[0m";
  //sets text color to light green
  private static final String lightGreenText = "\033[0;92m";
  //sets text color to red
  private static final String redText = "\u001B[31m";
  //sets text color to yellow 
  private static final String yellowText = "\u001B[33m";
  private static final String cyanText = "\033[0;36m";
  private static final String boldBlueText = "\033[1;34m";
  private static final String purpleText = "\u001B[35m";
  private static int row = 0;
  private static int col = 0;
  private static Hero heroName;
  private static Enemy[][] theZeldemonWorld = new Enemy[5][5];
  private static int numAttacksPermitted = 4;
  private static Scanner input  = new Scanner(System.in);
  private static Enemy noEnemy = new Enemy("No Zeldemon Here",0);
  private static int attackChoice;

  public static void main(String[] args) {
    theZeldemonWorld[0][0] = null;
    theZeldemonWorld[0][1] = new Enemy("Deer Pirate",30);
    theZeldemonWorld[0][2] = new Enemy("Deer Pirate",40);
    theZeldemonWorld[0][3] = new Enemy("Ghost Goblin",50);
    theZeldemonWorld[0][4] = new Enemy("Big Foot",90);
   
    theZeldemonWorld[1][0] = new Enemy("Deer Pirate",30);
    theZeldemonWorld[1][1] = null;
    theZeldemonWorld[1][2] = new Enemy();//Giant Spider with 60 HP
    theZeldemonWorld[1][3] = new Enemy("Buff Deer Pirate",70);
    theZeldemonWorld[1][4] = new Enemy("Mummy Caterpillar",10);

    theZeldemonWorld[2][0] = new Enemy(); //Giant Spider with 60 HP
    theZeldemonWorld[2][1] = null;
    theZeldemonWorld[2][2] = new Enemy("Baby Lightning Dragon",75);
    theZeldemonWorld[2][3] = null;
    theZeldemonWorld[2][4] = new Enemy("Baby Lightning Dragon",75);
      
    theZeldemonWorld[3][0] = new Enemy("Evil Rabbit Scientist",20);
    theZeldemonWorld[3][1] = new Enemy("Ghost Goblin",50);
    theZeldemonWorld[3][2] = null;
    theZeldemonWorld[3][3] = new Enemy("Daddy Lightning Dragon",100); 
    theZeldemonWorld[3][4] = null;

    theZeldemonWorld[4][0] = null;
    theZeldemonWorld[4][1] = new Enemy("King Kong",120);
    theZeldemonWorld[4][2] = new Enemy("Pirate Rathish man", 90);
    theZeldemonWorld[4][3] = null; 
    theZeldemonWorld[4][4] = new Boss("Big Daddy Sooraj man",250);

    System.out.println();
    //sets text color to light green as it prints the information using typewriter effect.  
    animateText(lightGreenText + "Welcome to the world of Zeldemon! In this world there lives many types of Zeldemon, and each one of them have trained from their birth to become the Ultimate Zeldemon...");

    System.out.println();
    System.out.println();
    
    animateText("You are one of the Zeldemon, and are about to embark on a journey to become the Ultimate Zeldemon, are you ready?");

    System.out.println();
    System.out.println();

    System.out.println("type \"y\" for yes, and \"n\" for no: ");
    String choice = input.nextLine();

    while(!choice.equals("y") && !choice.equals("n")){
      System.out.println();
      System.out.println("type \"y\" for yes, and \"n\" for no: ");
      choice = input.nextLine(); 
    }

    if(choice.equals("y")){
      System.out.println();
      animateText("Great! now that you are ready, you can begin your journey to greatness...but wait, before you do, you need a name...");
      System.out.println();
      System.out.println();
      System.out.print("What is your Zeldemon name? ");
      String name = input.nextLine();
      heroName = new Hero(name,100,1);
    }
    else {
      System.out.println();
      animateText("Too bad, you are going on this journey anyway...now what is your Zeldemon name? ");
      String name = input.nextLine();
      heroName  = new Hero(name,100,1);
    } 

    System.out.println();

    animateText("You are in a lush jungle, it is very pretty...\n");
    System.out.println();
   
    while(!(row == 4 && col == 4)){
      System.out.print("What would you like to do?\n1. Move around\n2. Check your status\n3. Check your attack's status\nType a number to indicate what you want to do: ");
      int lifeChoice = input.nextInt();
      int directionChoice;
      while(lifeChoice <= 0 || lifeChoice > 3){
        System.out.println();
        animateText("Type a number between 1 and 3 to indicate what you want to do: ");
        lifeChoice = input.nextInt();
      }
      if(lifeChoice == 1){
        System.out.println();
        System.out.print("Where would you like to go?\n1. Up\n2. Down\n3. Left\n4. Right\nType a number to incdicate where you want to go: ");

        directionChoice = input.nextInt();
        updatePosition(directionChoice);
      
        while(row < 0 || row > 4 || col < 0 || col > 4){
          System.out.println();
          animateText("There is a wall of fire ahead of you, you cannot cross this point\n");
          System.out.println();
          if(row < 0){
            row++;
          }
          else if(row > 4){
            row--;
          }
          else if(col < 0){
            col++;
          }
          else if(col > 4){
            col--;
          }

          System.out.print("Where would you like to go?\n1. Up\n2. Down\n3. Left\n4. Right\nType a number to indicate where you want to go: ");

          directionChoice = input.nextInt();
          updatePosition(directionChoice);
          
        }
        fight();
      }
      if(lifeChoice == 2){
        System.out.println();
        System.out.println(heroName.getStatus());
        System.out.println();
      }
      if(lifeChoice == 3){
        System.out.println();
        if(heroName.getLevel() < 5){
          System.out.println(Attacks.attackStatus(heroName,numAttacksPermitted));
        }
        else if(heroName.getLevel() >= 5 && heroName.getLevel() <= 10){
          System.out.println(Attacks.attackStatus(heroName,numAttacksPermitted + 1));
        }
        else if(heroName.getLevel() > 10){
          System.out.println(Attacks.attackStatus(heroName,numAttacksPermitted + 2));
        }
        System.out.println();        
      }
    }
    System.out.println();
    animateText(redText + "\033[3mSo you've finally made it...\nYou must have crossed many seas to get here...\nBut your journey ends here...\nPrepare yourself for battle, for I am your worst nightmare...\nI am the Ultimate Zeldemon...\nI am Big Daddy Sooraj man!\n\033[0m");
    System.out.println();
    Boss.bossFight(theZeldemonWorld[4][4], heroName, numAttacksPermitted, redText, input);
    animateText(lightGreenText + "You have defeated the Ultimate Zeldemon " + redText + theZeldemonWorld[4][4].getName() + lightGreenText + "!/n");
    System.out.println();
    animateText(purpleText + "You are now the Ultimate Zeldemon!\n");
    //add user input for how did you like the game 
    System.exit(0);
  }

  public static void animateText(String text){
    int i;
    for(i = 0; i < text.length(); i++){
      System.out.printf("%c", text.charAt(i));
      try{
        //the sleep method animates the text to have a typewriter effect, so that each character of the text is printed one at a time with a small delay in between each character. 
        Thread.sleep(25);//0.025s pause between characters
      }
      catch(InterruptedException ex){
        Thread.currentThread().interrupt();
      }
    }
  }

  public static void fight(){
    if(theZeldemonWorld[row][col] == null){
      System.out.println();
      animateText("You have reached a resting point...\n");
      if(heroName.getHP() > 55){
        heroName.setHP(100);
      }
      else{
        heroName.setHP(heroName.getHP() + 45);
      }
      animateText("You HP has been restored to " + heroName.getHP() + " HP!\n");
      System.out.println();
    }
    else if(theZeldemonWorld[row][col].getName().equals("No Zeldemon Here")){
      System.out.println();
      animateText("There are no wild Zeldemon in this area...\n");
      System.out.println();
    }
    else if(theZeldemonWorld[row][col].getName().equals("Deer Pirate")){
      System.out.println();
      int deerPirateDamage = 2;
      animateText("You have encountered a wild " + theZeldemonWorld[row][col].getName() + "...\n");
      System.out.println();
      while(theZeldemonWorld[row][col].getEnemyHP() > 0){
        System.out.println("Which attack would you like to use?");
        if(heroName.getLevel() < 5){
          heroName.chooseAttackMove(numAttacksPermitted, heroName, input); 
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,deerPirateDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
        else if(heroName.getLevel() >= 5 && heroName.getLevel() <= 10){
          heroName.chooseAttackMove(numAttacksPermitted + 1, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,deerPirateDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
        else{
          heroName.chooseAttackMove(numAttacksPermitted + 2, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,deerPirateDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
      }
      animateText("You defeated the opposing " + theZeldemonWorld[row][col].getName() + "!\n");
      heroName.setLevel(heroName.getLevel() + 1);
      animateText("Your level increased to level " + heroName.getLevel() + "!\n");
      Attacks.learnAttacks(heroName);
      heroName.setHP(heroName.getHP() + 10);
      if(heroName.getHP() > 100){
        heroName.setHP(100);
      }
      animateText("Your HP has been restored to " + heroName.getHP() + " HP!\n");
      theZeldemonWorld[row][col] = noEnemy;
      Attacks.updateAttackStatus(theZeldemonWorld[row][col],heroName,numAttacksPermitted);
      System.out.println();
    }
    else if(theZeldemonWorld[row][col].getName().equals("Ghost Goblin")){
      System.out.println();
      int goblinGhostDamage = 5;
      animateText("You have encountered a wild " + theZeldemonWorld[row][col].getName() + "...\n");
      System.out.println();
      while(theZeldemonWorld[row][col].getEnemyHP() > 0){
        System.out.println("Which attack would you like to use?");
        if(heroName.getLevel() < 5){
          heroName.chooseAttackMove(numAttacksPermitted, heroName,input); 
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,goblinGhostDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
        else if(heroName.getLevel() >= 5 && heroName.getLevel() <= 10){
          heroName.chooseAttackMove(numAttacksPermitted + 1, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,goblinGhostDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
        else{
          heroName.chooseAttackMove(numAttacksPermitted + 2, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,goblinGhostDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
      }
      animateText("You defeated the opposing " + theZeldemonWorld[row][col].getName() + "!\n");
      heroName.setLevel(heroName.getLevel() + 1);
      animateText("Your level increased to level " + heroName.getLevel() + "!\n");
      Attacks.learnAttacks(heroName);
      heroName.setHP(heroName.getHP() + 10);
      if(heroName.getHP() > 100){
        heroName.setHP(100);
      }
      animateText("Your HP has been restored to " + heroName.getHP() + " HP!\n");
      theZeldemonWorld[row][col] = noEnemy;
      Attacks.updateAttackStatus(theZeldemonWorld[row][col],heroName,numAttacksPermitted);
      System.out.println();
    }
    else if(theZeldemonWorld[row][col].getName().equals("Big Foot")){
      System.out.println();
      int bigFootDamage = 10;
      animateText("You have encountered a wild " + redText + theZeldemonWorld[row][col].getName() + lightGreenText + "...\n");
      System.out.println();
      while(theZeldemonWorld[row][col].getEnemyHP() > 0){
        System.out.println("Which attack would you like to use?");
        if(heroName.getLevel() < 5){
          heroName.chooseAttackMove(numAttacksPermitted, heroName,input); 
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,bigFootDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
        else if(heroName.getLevel() >= 5 && heroName.getLevel() <= 10){
          heroName.chooseAttackMove(numAttacksPermitted + 1, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,bigFootDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
        else{
          heroName.chooseAttackMove(numAttacksPermitted + 2, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,bigFootDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
      }
      animateText("You defeated the opposing " + redText + theZeldemonWorld[row][col].getName() + lightGreenText + "!\n");
      heroName.setLevel(heroName.getLevel() + 1);
      animateText("Your level increased to level " + heroName.getLevel() + "!\n");
      Attacks.learnAttacks(heroName);
      heroName.setHP(heroName.getHP() + 15);
      if(heroName.getHP() > 100){
        heroName.setHP(100);
      }
      animateText("Your HP has been restored to " + heroName.getHP() + " HP!\n");
      theZeldemonWorld[row][col] = noEnemy;
      Attacks.updateAttackStatus(theZeldemonWorld[row][col],heroName,numAttacksPermitted);
      System.out.println();
    }
    else if(theZeldemonWorld[row][col].getName().equals("Giant Spider")){
      System.out.println();
      int giantSpiderDamage = 7;
      animateText("You have encountered a wild " + yellowText + theZeldemonWorld[row][col].getName() + lightGreenText + "...\n");
      System.out.println();
      while(theZeldemonWorld[row][col].getEnemyHP() > 0){
        System.out.println("Which attack would you like to use?");
        if(heroName.getLevel() < 5){
          heroName.chooseAttackMove(numAttacksPermitted, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,giantSpiderDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
        else if(heroName.getLevel() >= 5 && heroName.getLevel() <= 10){
          heroName.chooseAttackMove(numAttacksPermitted + 1, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,giantSpiderDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
        else{
          heroName.chooseAttackMove(numAttacksPermitted + 2, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,giantSpiderDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
      }
      animateText("You defeated the opposing " + yellowText + theZeldemonWorld[row][col].getName() + lightGreenText + "!\n");
      heroName.setLevel(heroName.getLevel() + 1);
      animateText("Your level increased to level " + heroName.getLevel() + "!\n");
      Attacks.learnAttacks(heroName);
      heroName.setHP(heroName.getHP() + 15);
      if(heroName.getHP() > 100){
        heroName.setHP(100);
      }
      animateText("Your HP has been restored to " + heroName.getHP() + " HP!\n");
      theZeldemonWorld[row][col] = noEnemy;
      Attacks.updateAttackStatus(theZeldemonWorld[row][col],heroName,numAttacksPermitted);
      System.out.println();
    }
    else if(theZeldemonWorld[row][col].getName().equals("Buff Deer Pirate")){
      System.out.println();
      int buffDeerPirateDamage = 9;
      animateText("You have encountered a wild " + theZeldemonWorld[row][col].getName() + "...\n");
      System.out.println();
      while(theZeldemonWorld[row][col].getEnemyHP() > 0){
        System.out.println("Which attack would you like to use?");
        if(heroName.getLevel() < 5){
          heroName.chooseAttackMove(numAttacksPermitted, heroName,input); 
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,buffDeerPirateDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
        else if(heroName.getLevel() >= 5 && heroName.getLevel() <= 10){
          heroName.chooseAttackMove(numAttacksPermitted + 1, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,buffDeerPirateDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
        else{
          heroName.chooseAttackMove(numAttacksPermitted + 2, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,buffDeerPirateDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
      }
      animateText("You defeated the opposing " + theZeldemonWorld[row][col].getName() + "!\n");
      heroName.setLevel(heroName.getLevel() + 1);
      animateText("Your level increased to level " + heroName.getLevel() + "!\n");
      Attacks.learnAttacks(heroName);
      heroName.setHP(heroName.getHP() + 10);
      if(heroName.getHP() > 100){
        heroName.setHP(100);
      }
      animateText("Your HP has been restored to " + heroName.getHP() + " HP!\n");
      theZeldemonWorld[row][col] = noEnemy;
      Attacks.updateAttackStatus(theZeldemonWorld[row][col],heroName,numAttacksPermitted);
      System.out.println();
    }
    else if(theZeldemonWorld[row][col].getName().equals("Mummy Caterpillar")){
      System.out.println();
      int mummyCaterpillarDamage = 25;
      animateText("You have encountered a wild " + theZeldemonWorld[row][col].getName() + "...\n");
      System.out.println();
      while(theZeldemonWorld[row][col].getEnemyHP() > 0){
        System.out.println("Which attack would you like to use?");
        if(heroName.getLevel() < 5){
          heroName.chooseAttackMove(numAttacksPermitted, heroName,input); 
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,mummyCaterpillarDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
        else if(heroName.getLevel() >= 5 && heroName.getLevel() <= 10){
          heroName.chooseAttackMove(numAttacksPermitted + 1, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,mummyCaterpillarDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
        else{
          heroName.chooseAttackMove(numAttacksPermitted + 2, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,mummyCaterpillarDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
      }
      animateText("You defeated the opposing " + theZeldemonWorld[row][col].getName() + "!\n");
      heroName.setLevel(heroName.getLevel() + 1);
      animateText("Your level increased to level " + heroName.getLevel() + "!\n");
      Attacks.learnAttacks(heroName);
      heroName.setHP(heroName.getHP() + 1);
      if(heroName.getHP() > 100){
        heroName.setHP(100);
      }
      animateText("Your HP has been restored to " + heroName.getHP() + " HP!\n");
      theZeldemonWorld[row][col] = noEnemy;
      Attacks.updateAttackStatus(theZeldemonWorld[row][col],heroName,numAttacksPermitted);
      System.out.println();
    }
    else if(theZeldemonWorld[row][col].getName().equals("Baby Lightning Dragon")){
      System.out.println();
      int babyLightningDragonDamage = 20;
      animateText("You have encountered a wild " + cyanText + theZeldemonWorld[row][col].getName() + lightGreenText + "...\n");
      System.out.println();
      while(theZeldemonWorld[row][col].getEnemyHP() > 0){
        System.out.println("Which attack would you like to use?");
        if(heroName.getLevel() < 5){
          heroName.chooseAttackMove(numAttacksPermitted, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,babyLightningDragonDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
        else if(heroName.getLevel() >= 5 && heroName.getLevel() <= 10){
          heroName.chooseAttackMove(numAttacksPermitted + 1, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,babyLightningDragonDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
        else{
          heroName.chooseAttackMove(numAttacksPermitted + 2, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,babyLightningDragonDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
      }
      animateText("You defeated the opposing " + cyanText + theZeldemonWorld[row][col].getName() + lightGreenText + "!\n");
      heroName.setLevel(heroName.getLevel() + 1);
      animateText("Your level increased to level " + heroName.getLevel() + "!\n");
      Attacks.learnAttacks(heroName);
      heroName.setHP(heroName.getHP() + 15);
      if(heroName.getHP() > 100){
        heroName.setHP(100);
      }
      animateText("Your HP has been restored to " + heroName.getHP() + " HP!\n");
      theZeldemonWorld[row][col] = noEnemy;
      Attacks.updateAttackStatus(theZeldemonWorld[row][col],heroName,numAttacksPermitted);
      System.out.println();
    }
    else if(theZeldemonWorld[row][col].getName().equals("Evil Rabbit Scientist")){
      System.out.println();
      int evilRabbitDamage = 30;
      animateText("You have encountered a wild " + theZeldemonWorld[row][col].getName() + "...\n");
      System.out.println();
      while(theZeldemonWorld[row][col].getEnemyHP() > 0){
        System.out.println("Which attack would you like to use?");
        if(heroName.getLevel() < 5){
          heroName.chooseAttackMove(numAttacksPermitted, heroName,input); 
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,evilRabbitDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
        else if(heroName.getLevel() >= 5 && heroName.getLevel() <= 10){
          heroName.chooseAttackMove(numAttacksPermitted + 1, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,evilRabbitDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
        else{
          heroName.chooseAttackMove(numAttacksPermitted + 2, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,evilRabbitDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
      }
      animateText("You defeated the opposing " + theZeldemonWorld[row][col].getName() + "!\n");
      heroName.setLevel(heroName.getLevel() + 1);
      animateText("Your level increased to level " + heroName.getLevel() + "!\n");
      Attacks.learnAttacks(heroName);
      heroName.setHP(heroName.getHP() + 2);
      if(heroName.getHP() > 100){
        heroName.setHP(100);
      }
      animateText("Your HP has been restored to " + heroName.getHP() + " HP!\n");
      theZeldemonWorld[row][col] = noEnemy;
      Attacks.updateAttackStatus(theZeldemonWorld[row][col],heroName,numAttacksPermitted);
      System.out.println();
    }
    else if(theZeldemonWorld[row][col].getName().equals("Daddy Lightning Dragon")){
      System.out.println();
      int daddyDragonDamage = 25;
      animateText("You have encountered a wild " + boldBlueText + theZeldemonWorld[row][col].getName() + lightGreenText + "...\n");
      System.out.println();
      while(theZeldemonWorld[row][col].getEnemyHP() > 0){
        System.out.println("Which attack would you like to use?");
        if(heroName.getLevel() < 5){
          heroName.chooseAttackMove(numAttacksPermitted, heroName,input); 
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,daddyDragonDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
        else if(heroName.getLevel() >= 5 && heroName.getLevel() <= 10){
          heroName.chooseAttackMove(numAttacksPermitted + 1, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,daddyDragonDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
        else{
          heroName.chooseAttackMove(numAttacksPermitted + 2, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,daddyDragonDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
      }
      animateText("You defeated the opposing " + boldBlueText + theZeldemonWorld[row][col].getName() + lightGreenText + "!\n");
      heroName.setLevel(heroName.getLevel() + 1);
      animateText("Your level increased to level " + heroName.getLevel() + "!\n");
      Attacks.learnAttacks(heroName);
      heroName.setHP(heroName.getHP() + 20);
      if(heroName.getHP() > 100){
        heroName.setHP(100);
      }
      animateText("Your HP has been restored to " + heroName.getHP() + " HP!\n");
      theZeldemonWorld[row][col] = noEnemy;
      Attacks.updateAttackStatus(theZeldemonWorld[row][col],heroName,numAttacksPermitted);
      System.out.println();
    }
    else if(theZeldemonWorld[row][col].getName().equals("King Kong")){
      System.out.println();
      int kingKongDamage = 30;
      animateText("You have encountered a wild " + redText + theZeldemonWorld[row][col].getName() + lightGreenText + "...\n");
      System.out.println();
      while(theZeldemonWorld[row][col].getEnemyHP() > 0){
        System.out.println("Which attack would you like to use?");
        if(heroName.getLevel() < 5){
          heroName.chooseAttackMove(numAttacksPermitted, heroName,input); 
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,kingKongDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
        else if(heroName.getLevel() >= 5 && heroName.getLevel() <= 10){
          heroName.chooseAttackMove(numAttacksPermitted + 1, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,kingKongDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
        else{
          heroName.chooseAttackMove(numAttacksPermitted + 2, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,kingKongDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
      }
      animateText("You defeated the opposing " + redText + theZeldemonWorld[row][col].getName() + lightGreenText + "!\n");
      heroName.setLevel(heroName.getLevel() + 1);
      animateText("Your level increased to level " + heroName.getLevel() + "!\n");
      Attacks.learnAttacks(heroName);
      heroName.setHP(heroName.getHP() + 40);
      if(heroName.getHP() > 100){
        heroName.setHP(100);
      }
      animateText("Your HP has been restored to " + heroName.getHP() + " HP!\n");
      theZeldemonWorld[row][col] = noEnemy;
      Attacks.updateAttackStatus(theZeldemonWorld[row][col],heroName,numAttacksPermitted);
      System.out.println();
    }
    else if(theZeldemonWorld[row][col].getName().equals("Pirate Rathish man")){
      System.out.println();
      int pirateRathishDamage = 35;
      animateText("You have encountered a wild " + purpleText + theZeldemonWorld[row][col].getName() + lightGreenText + "...\n");
      System.out.println();
      while(theZeldemonWorld[row][col].getEnemyHP() > 0){
        System.out.println("Which attack would you like to use?");
        if(heroName.getLevel() < 5){
          heroName.chooseAttackMove(numAttacksPermitted, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,pirateRathishDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
        else if(heroName.getLevel() >= 5 && heroName.getLevel() <= 10){
          heroName.chooseAttackMove(numAttacksPermitted + 1, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,pirateRathishDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
        else{
          heroName.chooseAttackMove(numAttacksPermitted + 2, heroName,input);
          theZeldemonWorld[row][col].enemyAttack(theZeldemonWorld[row][col],heroName,pirateRathishDamage);
          if(heroName.getHP() < 0){
          System.out.println();
          animateText(redText + "Game over, try again next time...\n");
          System.exit(0);
          }
          heroName.attack(Main.getAttackChoice(), theZeldemonWorld[row][col], heroName);
        }
      }
      animateText("You defeated the opposing " + purpleText + theZeldemonWorld[row][col].getName() + lightGreenText + "!\n");
      heroName.setLevel(heroName.getLevel() + 1);
      animateText("Your level increased to level " + heroName.getLevel() + "!\n");
      Attacks.learnAttacks(heroName);
      heroName.setHP(heroName.getHP() + 35);
      if(heroName.getHP() > 100){
        heroName.setHP(100);
      }
      animateText("Your HP has been restored to " + heroName.getHP() + " HP!\n");
      theZeldemonWorld[row][col] = noEnemy;
      Attacks.updateAttackStatus(theZeldemonWorld[row][col],heroName,numAttacksPermitted);
      System.out.println();
    }
    else{
      System.out.println();
      animateText("You are in a scorching desert, it is not very pretty...\n");
    }
  }

  public static int getAttackChoice(){
    return attackChoice;
  }

  public static void setAttackChoice(int choice){
    attackChoice = choice;
  }
  
  public static void updatePosition(int choice){
    if(choice == 1){
      row++;
    }
    if(choice == 2){
      row--;
    }
    if(choice == 3){
      col--;
    }
    if(choice == 4){
      col++;
    }
  }
}
