import java.util.Scanner;
public class Hero{
  private int HP;
  private String name;
  private int level;
  private int decision;
  private Attacks[] attackList = {new Attacks("Quick Attack",5), new Attacks("Lightning Strike",10), new Attacks("Meditate",0), new Attacks("Fireball",10), new Attacks("Earthquake",50), new Attacks("Super Lightning Strike",90)};
/**

meditate could increase experience to increase level or restore HP of the hero

Super lightning strike attack damage needs adjustment

**/
  public Hero(String name, int HP, int level){
    this.name = name;
    this.HP = HP;
    this.level = level;
  }

  public String getStatus(){
    return "Status of " + name + " - \n" + "HP: " + HP + "\nLevel: " + level; 
  }

  public int getHP(){
    return HP;
  }

  public void setHP(int newHP){
    HP = newHP;
  }

  public int getLevel(){
    return level;
  }

  public void setLevel(int newLevel){
    level = newLevel;
  }

  public Attacks[] getAttackList(){
    return attackList;
  }

  public Attacks getAttack(int index){
    return attackList[index];
  }

  public void chooseAttackMove(int num, Hero obj, Scanner inp){
    for(int i = 0; i < num; i++){
      Attacks attack = obj.getAttack(i);
      System.out.println(i+1 + ". " + attack.getAttackName());
    }
    System.out.print("Type a number to indicate your answer: ");
    decision = inp.nextInt();
    Main.setAttackChoice(decision);
    while(decision > num){
      System.out.println("Type a number between 1 and " + num + " to indicate your answer: ");
      decision = inp.nextInt();
      Main.setAttackChoice(decision);
    }
  }

  public void attack(int num, Enemy obj, Hero heroObj){//method is supposed to decrease enemy HP 
    int criticalHit = (int)(Math.random() * 100) + 1;
    if(num == 1){
      Main.animateText("you used Quick Attack...\n");
      if(criticalHit <= 30){
        Main.animateText("A critical hit...\n");
        obj.setEnemyHP(obj.getEnemyHP() - (4*(attackList[num - 1].getAttackDamage() + level)));
        Main.animateText("The opposing " + obj.getName() + " lost " + (4*(attackList[num - 1].getAttackDamage() + level)) + " HP...\n");
        Main.animateText("The opposing " + obj.getName() + " now has " + obj.getEnemyHP() + " HP left.\n");
        System.out.println();
      }
      else{
        obj.setEnemyHP(obj.getEnemyHP() - attackList[num - 1].getAttackDamage());
        Main.animateText("The opposing " + obj.getName() + " lost " + attackList[num - 1].getAttackDamage() + " HP...\n");
        Main.animateText("The opposing " + obj.getName() + " now has " + obj.getEnemyHP() + " HP left.\n");
        System.out.println();
      } 
    }
    else if(num == 2){
      Main.animateText("you used Lightning Strike...\n");
      if(criticalHit <= 50){
        Main.animateText("A critical hit...\n");
        obj.setEnemyHP(obj.getEnemyHP() - (2*(attackList[num - 1].getAttackDamage() + level)));
        Main.animateText("The opposing " + obj.getName() + " lost " + (2*(attackList[num - 1].getAttackDamage() + level)) + " HP...\n");
        Main.animateText("The opposing " + obj.getName() + " now has " + obj.getEnemyHP() + " HP left.\n");
        System.out.println();
      }
      else{
        obj.setEnemyHP(obj.getEnemyHP() - attackList[num - 1].getAttackDamage());
        Main.animateText("The opposing " + obj.getName() + " lost " + attackList[num - 1].getAttackDamage() + " HP...\n");
        Main.animateText("The opposing " + obj.getName() + " now has " + obj.getEnemyHP() + " HP left.\n");
        System.out.println();
      }
    }
    else if(num == 3){
      Main.animateText("you used Meditate...\n");
      heroObj.setHP(heroObj.getHP() + (2 * heroObj.getLevel()));
      if(heroObj.getHP() > 100){
        heroObj.setHP(100);
      }
      Main.animateText("your HP has been restored to " + HP + " HP!\n");
      System.out.println();
    }
    else if(num == 4){
      Main.animateText("you used Fireball...\n");
      if(criticalHit <= 30){
        Main.animateText("A critical hit...\n");
        obj.setEnemyHP(obj.getEnemyHP() - (3*(attackList[num - 1].getAttackDamage() + level)));
        Main.animateText("The opposing " + obj.getName() + " lost " + (3*(attackList[num - 1].getAttackDamage() + level)) + " HP...\n");
        Main.animateText("The opposing " + obj.getName() + " now has " + obj.getEnemyHP() + " HP left.\n");
        System.out.println();
      }
      else{
        obj.setEnemyHP(obj.getEnemyHP() - attackList[num - 1].getAttackDamage());
        Main.animateText("The opposing " + obj.getName() + " lost " + attackList[num - 1].getAttackDamage() + " HP...\n");
        Main.animateText("The opposing " + obj.getName() + " now has " + obj.getEnemyHP() + " HP left.\n");
        System.out.println();
      }
    }
    else{
      Main.animateText("you used " + attackList[num - 1].getAttackName() + "...\n");
      if(criticalHit <= 30){
        Main.animateText("A critical hit...\n");
        obj.setEnemyHP(obj.getEnemyHP() - (attackList[num - 1].getAttackDamage() + level));
        Main.animateText("The opposing " + obj.getName() + " lost " + (attackList[num - 1].getAttackDamage() + level) + " HP...\n");
        Main.animateText("The opposing " + obj.getName() + " now has " + obj.getEnemyHP() + " HP left.\n");
        System.out.println();
      }
      else{
        obj.setEnemyHP(obj.getEnemyHP() - attackList[num - 1].getAttackDamage());
        Main.animateText("The opposing " + obj.getName() + " lost " + attackList[num - 1].getAttackDamage() + " HP...\n");
        Main.animateText("The opposing " + obj.getName() + " now has " + obj.getEnemyHP() + " HP left.\n");
        System.out.println();
      }
    }
  } 
}