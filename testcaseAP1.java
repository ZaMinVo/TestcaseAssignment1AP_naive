public class testcaseAP1 {

    public static double min(double a, double b){
        return a < b ? a : b;
    }

    public static int testKnightandWarror() {
        int [] baseHP = {100, 999, 500, 501, 9};
        int [] baseWP = {1, 2};
        int [] baseGround = {1, 2, 6};
        int numberoftest = 2 * 3 * 5;
        for(int i = 0; i < numberoftest; ++i){
            int hp = baseHP[i % 5];
            int wp = baseWP[(i / 5) % 2];
            Battle.GROUND = baseGround[(i / 10) % 3];
            Combatable knight = new Knight(hp, wp);
            Combatable warrior = new Warrior(hp, wp);
            // System.err.println("hp: " + hp + " wp: " + wp + " ground: " + Battle.GROUND);
            if(Battle.GROUND == 1){
                if(knight.getCombatScore() != min(hp * 2.0d, 999.0d) 
                    || (wp == 1 && warrior.getCombatScore() != hp)
                    || (wp != 1 && warrior.getCombatScore() != hp / 10.0d))
                    return i;
            } else if(Battle.GROUND == 2) {
                if(warrior.getCombatScore() != min(hp * 2.0d, 999.0d)
                    || wp == 1 && knight.getCombatScore() != hp
                    || (wp != 1 && knight.getCombatScore() != hp / 10.0d))
                    return i;
            }
            else {
                if(wp == 1 && (knight.getCombatScore() != hp 
                    || warrior.getCombatScore() != hp))
                    return i;
                if (wp != 1 && (warrior.getCombatScore() != hp / 10.0 
                    || knight.getCombatScore() != hp / 10.0))
                    return i;
            }
        }
        return -1;
    }

    public static int testPaladin(){
        int [] baseWP = {1, 2};
        int [] fibo = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040};
        
        for(int i = 0; i < fibo.length * 2 - 1; ++i){
            int hp = fibo[i % fibo.length];
            if(i >= fibo.length){
                hp += 9;
            }
            int wp = baseWP[i % 2];
            if(i < fibo.length && i > 2){
                Combatable paladin = new Paladin(hp, wp);
                if(paladin.getCombatScore() != 1000.0d + (double) i){
                    return i;
                }
            }
            else {
                Combatable paladin = new Paladin(hp, wp);
                if(paladin.getCombatScore() != hp * 3.0d){
                    return i;
                }
            }
        }
        return -1;
    }

    public static int testDeathEater(){
        Complex[] Mana = {new Complex(0, 0), new Complex(3 , 4) ,new Complex(300, 200), new Complex(200, 300), new Complex(33.3, 22.2), new Complex(22.2, 33.33)};
        for(int i = 0; i < Mana.length; ++i){
            DeathEater deathEater = new DeathEater(Mana[i]);
            if(deathEater.getCombatScore() != Mana[i].getMagnitude()){
                return i;
            }
        }
        return -1;
    }

    public static void run() {
        if(testKnightandWarror() == -1)
            System.err.println("testKnightandWarror passed.");
        else
            System.err.println("fail testKnightandWarror: " + testKnightandWarror());
        if(testPaladin() == -1)
            System.err.println("testPaladin passed.");
        else
            System.err.println("fail testPaladin: " + testPaladin());
        if(testDeathEater() == -1)
            System.err.println("testDeathEater passed.");
        else
            System.err.println("fail testDeathEater: " + testDeathEater());
    }

    public static void main(String[] args) {
        run();
    }
}
