package actions;

import battleFields.*;
import enumerations.Direct;
import tanks.AbstractTank;

public class Logic {

    private AbstractTank tank;
    private Bullet bullet;
    private BattleField bf;
    private Slider sdr;

    public Logic(Slider sdr, BattleField bf) throws Exception {

        this.sdr = sdr;
        this.bf = bf;
        this.tank = sdr.getAgressor();
        this.bullet = sdr.getBullet();
    }

    // should to be improved
    public void detour(AbstractTank tank) throws Exception {

        String next = null;
        if(tank.getNextQuadrant() instanceof Water){

            turnOpposite();
            tank.move();
            tank.turn(Direct.LEFT);
            tank.move();
            chooseHQDestroyWay();


//            System.out.println(tank.getNextQuadrant().getX() + "_" + tank.getNextQuadrant().getY());




//                next = sdr.getQuadrantYX(tank.getCheckQuadrant().getX(), tank.getCheckQuadrant().getY());
//                tank.moveToQuadrant(sdr.getQtY(next), sdr.getQtX(next));
//            }

        } else if(tank.getNextQuadrant() instanceof Rock) {
            System.out.println(this.tank + " is detouring the Rock!");
            tank.fire();
        }
    }

//    private AbstractComponent[] getNextLine(){
//
//        AbstractComponent[] b = new AbstractComponent[bf.getMNQ()];
//        int x = tank.getX() / 64;
//        for(int i = 0; i < bf.getMNQ(); i++){
//            //b[i] = (AbstractComponents)[x][i];
//            //for(int j = 0; j < bf.getMNQ(); j++){
//                //sdr.getQuadrantYX(tank.getX(), tank.getY();
//                //Abstractcomponent[] b =
//            }
//        }
//        return b;
//    }

    private void turnOpposite(){

        if(tank.direction == Direct.DOWN){
            tank.direction = Direct.UP;
            sdr.repaint();
        }
    }

    private boolean ifTankNearBFBorders() {

        if (tank.getX() == (bf.getMNQ() - 1) * bf.getSquad() && tank.direction == Direct.RIGHT ||
                tank.getX() == 0 && tank.direction == Direct.LEFT ||
                tank.getY() == (bf.getMNQ() - 1) * bf.getSquad() && tank.direction == Direct.DOWN ||
                tank.getY() == 0 && tank.direction == Direct.UP) {
            return true;
        }
        return false;
    }

    public void chooseHQDestroyWay() throws Exception {

        if(tank.getX() == 256) {
            chosenHQDestoyingThirdWay(); // x = 256
        }

        if(tank.getY() < 320){
            if(tank.getX() < bf.getMNQ() / 2 * bf.getSquad()){ // x < 256
                chosenHQDestoyingFirstWay();
            }
            if(tank.getX() >= 320) {
                chosenHQDestoyingSecondWay();
            }
        }

        // x = 0 ???
        if(tank.getY() >= 320 && tank.getX() != 0){
            if(tank.getX() < bf.getMNQ() / 2 * bf.getSquad()){ // x < 256
                chosenHQDestroyingFourthWay();
            }
            if(tank.getX() >= 320){
                chosenHQDestroyingFifthWay();
            }
        }
    }

    private void chosenHQDestoyingFirstWay() throws Exception {

        System.out.println(this.tank + " chose First Way!!!");
        while(!tankOnLineOfFire()){
            tank.direction = Direct.RIGHT;
            tank.move();
            if(!tank.processPurityCheck()){
                tank.turn(Direct.DOWN);
                detour(tank); // 23
            }
        }
        chosenHQDestoyingThirdWay();
        while (bullet.getY()!= ((bf.getMNQ() - 1) * bf.getSquad())){
            tank.move();
            if(bf.scanQuadrant(8, 4) instanceof Black){
                break;
            }

        }
    }

    private void chosenHQDestoyingSecondWay() throws Exception {

        System.out.println(this.tank + " chose Second Way!!!");
        while (tank.getY() != 512) {
            tank.direction = Direct.DOWN;
            tank.move();
            if (!tank.processPurityCheck()) {
                detour(tank); // 23
            }
        }
        tank.turn(Direct.LEFT);
        while (bullet.getX()!= ((bf.getMNQ()/ 2) * bf.getSquad())){
            tank.fire();
            if(bf.scanQuadrant(8, 4) instanceof Black){
                break;
            }
        }
    }

    private void chosenHQDestoyingThirdWay() throws Exception {

        System.out.println(this.tank + " chose Third Way!!!");
        while(true){
            if(bf.scanQuadrant(8, 4) instanceof Black){
                break;
            }
            tank.fire();
            tank.move();
        }
    }

    private void chosenHQDestroyingFourthWay() throws Exception {

        System.out.println(this.tank + " chose Fourth Way!!!");
        while (tank.getY() < 512) {
            tank.direction = Direct.DOWN;
            tank.move();
            if (!tank.processPurityCheck()) {
                detour(tank); // 23
            }
        }
        tank.turn(Direct.RIGHT);
        while(true){
            if(bf.scanQuadrant(8, 4) instanceof Black){
                break;
            }
            tank.fire();
        }
    }

    private void chosenHQDestroyingFifthWay() throws Exception {

        System.out.println(this.tank + " chose Fifth Way!!!");
        while (tank.getY() < 512) {
            tank.direction = Direct.DOWN;
            tank.move();
            if (!tank.processPurityCheck()) {
                detour(tank); // 23
            }
        }
        tank.turn(Direct.LEFT);
        while(true){
            if(bf.scanQuadrant(8, 4) instanceof Black){
                break;
            }
            tank.fire();
        }
    }

    private boolean tankOnLineOfFire() throws Exception {

        if(tank.getX() == 256){
            tank.turn(Direct.DOWN);
            return true;
        }
        return false;
    }
}

