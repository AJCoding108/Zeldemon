/**

  list of enemies: Deer pirate, Ghost Goblin, Big Foot, Giant Spider, Buff Deer Pirate, Baby Lightning Dragon, Big Lightning Dragon, no enemy (if hero defeats an enemy, this enemy called "no enemy" replaces the former enemy in that position so that hero cannot battle the former enemy in the same positon again, this is to ensure the prevention of grinding), Mummy Caterpillar, Evil Rabbit Scientist
  
  **/
public class Enemy{
  private int rnd;
  private String name;
  private int HP;
  private int randomNum;
  private Attacks[] bossAttackList = {new Attacks("Ultimate Strike",20),new Attacks("Poison flame",30),new Attacks("Ultimate Recovery",100)};
  
  public Enemy(){
    name = "Giant Spider";
    HP = 60;
  }
  public Enemy(String name, int HP){
    this.name = name;
    this.HP = HP;
  }

  public String getName(){
    return name;
  }

  public int getEnemyHP(){
    return HP;
  }

  public void setEnemyHP(int newEnemyHP){
    HP = newEnemyHP;
  }

  public boolean doesEnemyAttack(){
    rnd = (int)(Math.random() * 3);
    if(rnd == 0 || rnd == 1){
      return true;
    }
    else{
      return false;
    }
  }

  public void enemyAttack(Enemy obj, Hero heroObj, int damage){
    if(obj.getName().equals("Deer Pirate")){
      if(obj.doesEnemyAttack()){
        System.out.println();
        heroObj.setHP(heroObj.getHP() - damage);
        Main.animateText("The opposing " + obj.getName() + " used Wild Charge and inflicted a damage of " + damage + " HP...\n");
        Main.animateText("You now have " + heroObj.getHP() + " HP left.\n");
      }
      else{
        System.out.println();
        Main.animateText("The opposing " + obj.getName() + " used Wild Charge, but you dodged the attack!\n");
      }
    }
    else if(obj.getName().equals("Ghost Goblin")){
      if(obj.doesEnemyAttack()){
        System.out.println();
        heroObj.setHP(heroObj.getHP() - damage);
        Main.animateText("The opposing " + obj.getName() + " used Spooky Face and inflicted a damage of " + damage + " HP...\n");
        Main.animateText("You now have " + heroObj.getHP() + " HP left.\n");
      }
      else{
        System.out.println();
        Main.animateText("The opposing " + obj.getName() + " used Spooky Face, but you dodged the attack!\n");
      }
    }
    else if(obj.getName().equals("Big Foot")){
      if(obj.doesEnemyAttack()){
        System.out.println();
        heroObj.setHP(heroObj.getHP() - damage);
        Main.animateText("The opposing " + obj.getName() + " used Stomp and inflicted a damage of " + damage + " HP...\n");
        Main.animateText("You now have " + heroObj.getHP() + " HP left.\n");
      }
      else{
        System.out.println();
        Main.animateText("The opposing " + obj.getName() + " used Stomp, but you dodged the attack!\n");
      }
    }
    else if(obj.getName().equals("Giant Spider")){
      if(obj.doesEnemyAttack()){
        System.out.println();
        heroObj.setHP(heroObj.getHP() - damage);
        Main.animateText("The opposing " + obj.getName() + " used String Cage and inflicted a damage of " + damage + " HP...\n");
        Main.animateText("You now have " + heroObj.getHP() + " HP left.\n");
      }
      else{
        System.out.println();
        Main.animateText("The opposing " + obj.getName() + " used String Cage, but you dodged the attack!\n");
      }
    }
    else if(obj.getName().equals("Buff Deer Pirate")){
      if(obj.doesEnemyAttack()){
        System.out.println();
        heroObj.setHP(heroObj.getHP() - damage);
        Main.animateText("The opposing " + obj.getName() + " used Super Wild Charge and inflicted a damage of " + damage + " HP...\n");
        Main.animateText("You now have " + heroObj.getHP() + " HP left.\n");
      }
      else{
        System.out.println();
        Main.animateText("The opposing " + obj.getName() + " used Super Wild Charge, but you dodged the attack!\n");
      }
    }
    else if(obj.getName().equals("Mummy Caterpillar")){
      if(obj.doesEnemyAttack()){
        System.out.println();
        heroObj.setHP(heroObj.getHP() - damage);
        Main.animateText("The opposing " + obj.getName() + " used Heat Wave and inflicted a damage of " + damage + " HP...\n");
        Main.animateText("You now have " + heroObj.getHP() + " HP left.\n");
      }
      else{
        System.out.println();
        Main.animateText("The opposing " + obj.getName() + " used Heat Wave, but you dodged the attack!\n");
      }
    }
    else if(obj.getName().equals("Baby Lightning Dragon")){
      if(obj.doesEnemyAttack()){
        System.out.println();
        heroObj.setHP(heroObj.getHP() - damage);
        Main.animateText("The opposing " + obj.getName() + " used Thunder Wave and inflicted a damage of " + damage + " HP...\n");
        Main.animateText("You now have " + heroObj.getHP() + " HP left.\n");
      }
      else{
        System.out.println();
        Main.animateText("The opposing " + obj.getName() + " used Thunder Wave, but you dodged the attack!\n");
      }
    }
    else if(obj.getName().equals("Evil Rabbit Scientist")){
      if(obj.doesEnemyAttack()){
        System.out.println();
        heroObj.setHP(heroObj.getHP() - damage);
        Main.animateText("The opposing " + obj.getName() + " used Chemistry and inflicted a damage of " + damage + " HP...\n");
        Main.animateText("You now have " + heroObj.getHP() + " HP left.\n");
      }
      else{
        System.out.println();
        Main.animateText("The opposing " + obj.getName() + " used Chemistry, but you dodged the attack!\n");
      }
    }
    else if(obj.getName().equals("Daddy Lightning Dragon")){
      if(obj.doesEnemyAttack()){
        System.out.println();
        heroObj.setHP(heroObj.getHP() - damage);
        Main.animateText("The opposing " + obj.getName() + " used Thunder Shock and inflicted a damage of " + damage + " HP...\n");
        Main.animateText("You now have " + heroObj.getHP() + " HP left.\n");
      }
      else{
        System.out.println();
        Main.animateText("The opposing " + obj.getName() + " used Thunder Shock, but you dodged the attack!\n");
      }
    }
    else if(obj.getName().equals("King Kong")){
      if(obj.doesEnemyAttack()){
        System.out.println();
        heroObj.setHP(heroObj.getHP() - damage);
        Main.animateText("The opposing " + obj.getName() + " used Double Kick and inflicted a damage of " + damage + " HP...\n");
        Main.animateText("You now have " + heroObj.getHP() + " HP left.\n");
      }
      else{
        System.out.println();
        Main.animateText("The opposing " + obj.getName() + " used Double Kick, but you dodged the attack!\n");
      }
    }
    else if(obj.getName().equals("Pirate Rathish man")){
      if(obj.doesEnemyAttack()){
        System.out.println();
        heroObj.setHP(heroObj.getHP() - damage);
        Main.animateText("The opposing " + obj.getName() + " used Calculus and inflicted a damage of " + damage + " HP...\n");
        Main.animateText("You now have " + heroObj.getHP() + " HP left.\n");
      }
      else{
        System.out.println();
        Main.animateText("The opposing " + obj.getName() + " used Calculus, but you dodged the attack!\n");
      }
    }
    else{
      System.out.println();
      Main.animateText("There is an error in the game. Try playing again next time!\n");
      System.exit(0);
    }
  }

  public void bossAttack(Enemy boss, Hero hero){
    randomNum = (int)(Math.random() * 4);
    if(randomNum == 0 || randomNum == 1){
      System.out.println();
      Main.animateText(boss.getName() + " used " + bossAttackList[randomNum].getAttackName() + " and inflicted a damage of " + bossAttackList[randomNum].getAttackDamage() + " HP! \n");
      hero.setHP(hero.getHP() - bossAttackList[randomNum].getAttackDamage());
      Main.animateText("You now have " + hero.getHP() + " HP left.\n");
    }
    else if(randomNum == 2){
      System.out.println();
      boss.setEnemyHP(boss.getEnemyHP() + bossAttackList[randomNum].getAttackDamage());
      if(boss.getEnemyHP() > 250){
        boss.setEnemyHP(250);
      }
      Main.animateText(boss.getName() + " used " + bossAttackList[randomNum].getAttackName() + " and restored his HP to " + boss.getEnemyHP() + " HP.\n");
    }
    else if(randomNum == 3){
      randomNum = (int) (Math.random() * 3);
      if(randomNum == 0|| randomNum == 1){
        System.out.println();
        Main.animateText(boss.getName() + " used " + bossAttackList[randomNum].getAttackName() + ", but you dodged the attack!\n");
      }
      else{
        System.out.println();
        Main.animateText(boss.getName() + " used " + bossAttackList[randomNum].getAttackName() + ", but failed miserably!\n");
      }
    }
    else{
      System.out.println();
      Main.animateText("There is an unexpected error in the game, please try again later...\n");
    }
  }
}