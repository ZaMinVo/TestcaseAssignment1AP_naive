public class testcaseAP1 {

    public static double min(double a, double b){
        return a < b ? a : b;
    }

    public static int testKnightandWarror() {
        int [] baseHP = {100, 999, 500, 501, 9, 1000, 1999, 2000, 9991, 10000};
        int [] baseWP = {1, 2}; 
        int [] baseGround = {1, 2, 4, 6};
        int numberoftest = baseGround.length * baseHP.length * baseWP.length;
        for(int i = 0; i < numberoftest; ++i){
            int hp = baseHP[i % baseHP.length];
            int wp = baseWP[(i / baseHP.length) % 2];
            Battle.GROUND = baseGround[(i / baseHP.length / baseWP.length) % 3];
            Combatable knight = new Knight(hp, wp);
            Combatable warrior = new Warrior(hp, wp);
            if(Battle.GROUND == 1 || Battle.GROUND == 4){
                if(knight.getCombatScore() != min(hp * 2.0d, 999.0d) 
                    || (wp == 1 && warrior.getCombatScore() != min(hp, 999.0))
                    || (wp != 1 && warrior.getCombatScore() != min(hp / 10.0d, 999.0))){
                    System.err.println("hp " + hp + " wp " + wp + " ground " + Battle.GROUND);
                    System.err.println("output knight " + knight.getCombatScore() + " warrior " + warrior.getCombatScore());
                    System.err.println("expect knight " + min(hp * 2.0d, 999.0d) + " warrior " + min((wp == 1) ? hp : hp / 10.0, 999.0));
                    return i;
                }
            } else if(Battle.GROUND == 2) {
                if(warrior.getCombatScore() != min(hp * 2.0d, 999.0d)
                    || wp == 1 && knight.getCombatScore() != min(hp, 999)
                    || (wp != 1 && knight.getCombatScore() != min(hp / 10.0d, 999))){
                        System.err.println("hp " + hp + " wp " + wp + " ground " + Battle.GROUND);
                        System.err.println("output knight " + knight.getCombatScore() + " warrior " + warrior.getCombatScore());
                        System.err.println("expect knight " + min((wp == 1) ? hp : hp / 10.0, 999.0) + " warrior " + min(hp * 2.0d, 999.0));
                        return i;
                    }
            }
            else {
                if(wp == 1 && (knight.getCombatScore() != min(hp, 999) 
                    || warrior.getCombatScore() != min(hp, 999))){
                        System.err.println("hp " + hp + " wp " + wp + " ground " + Battle.GROUND);
                        System.err.println("output knight " + knight.getCombatScore() + " warrior " + warrior.getCombatScore());
                        System.err.println("expect knight " + min(hp, 999.0) + " warrior " + min(hp, 999.0));
                        return i;
                    }
                else if (wp != 1 && (warrior.getCombatScore() != min(hp / 10.0d, 999)
                    || knight.getCombatScore() != min(hp / 10.0d, 999))){
                        System.err.println("hp " + hp + " wp " + wp + " ground " + Battle.GROUND);
                        System.err.println("output knight " + knight.getCombatScore() + " warrior " + warrior.getCombatScore());
                        System.err.println("expect knight " + min(hp / 10.0d, 999.0) + " warrior " + min(hp / 10.0d, 999.0));
                        return i;
                    }
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
                    System.err.println("hp " + hp + " wp " + wp);
                    System.err.println("output " + paladin.getCombatScore());
                    System.err.println("expect " + 1000.0d + (double) i);
                    return i;
                }
            }
            else {
                Combatable paladin = new Paladin(hp, wp);
                if(paladin.getCombatScore() != hp * 3.0d){
                    System.err.println("hp " + hp + " wp " + wp);
                    System.err.println("output " + paladin.getCombatScore());
                    System.err.println("expect " + hp * 3.0d);
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
                System.err.println("Mana " + Mana[i].toString());
                System.err.println("output " + deathEater.getCombatScore());
                System.err.println("expect " + Mana[i].getMagnitude());
                return i;
            }
        }
        return -1;
    }

    public static void run() {
        int test1 = testKnightandWarror(), test2, test3;
        if(test1 == -1)
            System.err.println("testKnightandWarror passed.");
        else
            System.err.println("fail testKnightandWarror: " + test1);
        test2 = testPaladin();
        if(test2 == -1)
            System.err.println("testPaladin passed.");
        else
            System.err.println("fail testPaladin: " + test2);
        test3 = testDeathEater();
        if(test3 == -1)
            System.err.println("testDeathEater passed.");
        else
            System.err.println("fail testDeathEater: " + test3);
    }

    public static void main(String[] args) {
        run();
    }
}
