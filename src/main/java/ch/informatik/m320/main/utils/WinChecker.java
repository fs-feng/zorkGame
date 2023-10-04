package ch.informatik.m320.main.utils;

public class WinChecker {
    //Singleton Setup
    private static final WinChecker instance = new WinChecker();
    public static WinChecker getInstance() {
        return instance;
    }


    private boolean reactorCore, navModul, ration, podKey, powerCable;


    private WinChecker() {
        reactorCore = false;
        navModul = false;
        ration = false;
        podKey = false;
        powerCable = false;
    }


    //methods
    public boolean checkWin() {
        if (reactorCore && navModul && ration && podKey && powerCable) {
            return true;
        } else {
            return  false;
        }
    }


    //getter and setter
    public void setReactorCore(boolean reactorCore) {
        this.reactorCore = reactorCore;
    }

    public void setNavModul(boolean navModul) {
        this.navModul = navModul;
    }

    public void setRation(boolean ration) {
        this.ration = ration;
    }

    public void setPodKey(boolean podKey) {
        this.podKey = podKey;
    }

    public void setPowerCable(boolean powerCable) {
        this.powerCable = powerCable;
    }
}
