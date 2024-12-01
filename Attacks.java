public class Attacks{
  private String nameOfAttack;
  private int attackDamage;
  public Attacks(String attackName, int damage){
    nameOfAttack = attackName;
    attackDamage = damage;
  }

  public String getAttackName(){
    return nameOfAttack;
  }

  public int getAttackDamage(){
    return attackDamage;
  }

  public void setAttackDamage(int newAttackDamage){
    attackDamage = newAttackDamage;
  }

  public static String attackStatus(Hero obj, int maxNum){
    if(maxNum == 4){
      return "Quick Attack: A very risky attack, if it lands a critical hit, then it deals 4 times its normal damage to the opposing Zeldemon, currently the normal damage of your Quick Attacks deals " + obj.getAttack(0).getAttackDamage() + " HP to the opposing Zeldemon!\n\n" + "Lightning Strike: A very precise attack, if it lands a critical hit, then it deals 2 times its normal damage to the opposing Zeldemon, currently the normal damage of your Lightning strike deals " + obj.getAttack(1).getAttackDamage() + " HP to the opposing Zeldemon!\n\n" + "Meditate: this attack does not deal any damage to the opposing Zeldemon, but instead restores your health, currently Medidate can restore " + (2*obj.getLevel()) + " HP!\n\n" + "Fireball: this attack creates a big fireball that can deal lots of damage to the opposing Zeldemon, if it lands a critical hit, then it could deal 3 times its normal damage to the oppsing Zeldemon, currently the normal damage of your Fireball deals " + obj.getAttack(3).getAttackDamage() + " HP to the opposing Zeldemon!";
    }
    else if(maxNum == 5){
      return "Quick Attack: A very risky attack, if it lands a critical hit, then it deals 4 times its normal damage to the opposing Zeldemon, currently the normal damage of your Quick Attacks deals " + obj.getAttack(0).getAttackDamage() + " HP to the opposing Zeldemon!\n\n" + "Lightning Strike: A very precise attack, if it lands a critical hit, then it deals 2 times its normal damage to the opposing Zeldemon, currently the normal damage of your Lightning strike deals " + obj.getAttack(1).getAttackDamage() + " HP to the opposing Zeldemon!\n\n" + "Meditate: this attack does not deal any damage to the opposing Zeldemon, but instead restores your health, currently Medidate can restore " + (2*obj.getLevel()) + " HP!\n\n" + "Fireball: this attack creates a big fireball that can deal lots of damage to the opposing Zeldemon, if it lands a critical hit, then it could deal 3 times its normal damage to the oppsing Zeldemon, currently the normal damage of your Fireball deals " + obj.getAttack(3).getAttackDamage() + " HP to the opposing Zeldemon!\n\n" + "Earthquake: it is what it sounds like, you create an earthquake to damage the opposing Zeldemon, currently the normal damage of your Earthquake deals " + obj.getAttack(4).getAttackDamage() + " HP to the opposing Zeldemon!";
    }
    else{
      return "Quick Attack: A very risky attack, if it lands a critical hit, then it deals 4 times its normal damage to the opposing Zeldemon, currently the normal damage of your Quick Attacks deals " + obj.getAttack(0).getAttackDamage() + " HP to the opposing Zeldemon!\n\n" + "Lightning Strike: A very precise attack, if it lands a critical hit, then it deals 2 times its normal damage to the opposing Zeldemon, currently the normal damage of your Lightning strike deals " + obj.getAttack(1).getAttackDamage() + " HP to the opposing Zeldemon!\n\n" + "Meditate: this attack does not deal any damage to the opposing Zeldemon, but instead restores your health, currently Medidate can restore " + (2*obj.getLevel()) + " HP!\n\n" + "Fireball: this attack creates a big fireball that can deal lots of damage to the opposing Zeldemon, if it lands a critical hit, then it could deal 3 times its normal damage to the oppsing Zeldemon, currently the normal damage of your Fireball deals " + obj.getAttack(3).getAttackDamage() + " HP to the opposing Zeldemon!\n\n" + "Earthquake: it is what it sounds like, you create an earthquake to damage the opposing Zeldemon, currently the normal damage of your Earthquake deals " + obj.getAttack(4).getAttackDamage() + " HP to the opposing Zeldemon!\n\n" + "Super Lightning Strike: A very powerful move, can deal lots of damage to the oppsing Zeldemon, currently the normal damage of your Super Lightning Strike deals " + obj.getAttack(5).getAttackDamage() + " HP to the opposing Zeldemon!";
    }
  }

  public static void updateAttackStatus(Enemy obj, Hero heroObj,int maxNum){
    if(obj.getName().equals("No Zeldemon Here")){
      for(int i = 0; i < maxNum; i++){
        Attacks attack = heroObj.getAttack(i);
        attack.setAttackDamage(heroObj.getAttack(i).getAttackDamage() + 2);
      }
    }
  }

  public static void learnAttacks(Hero obj){
    if(obj.getLevel() == 5){
      Main.animateText("You learned a new attack called Earthquake!\n");
    }
    else if(obj.getLevel() == 11){
      Main.animateText("You learned a new attack called Super Lightning Strike!\n");
    }
  } 
}