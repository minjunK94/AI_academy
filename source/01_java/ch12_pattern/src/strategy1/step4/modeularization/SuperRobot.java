package strategy1.step4.modeularization;

import strategy1.step4.interfaces.*;

public class SuperRobot extends Robot{
	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl knife;
	public SuperRobot() {
//		fly = new FlyYes();
//		missile = new MissileYes();
//		knife = new KnifeLazer();
		setFly(new FlyYes());
		setMissile(new MissileYes());
		setKnife(new KnifeLazer());
	}
	@Override
	public void actionFly() {
		fly.fly();
	}
	@Override
	public void actionMissile() {
		missile.missile();
	}
	@Override
	public void actionKnife() {
		knife.knife();
	}
	public void setFly(FlyImpl fly) {
		this.fly = fly;
	}
	public void setMissile(MissileImpl missile) {
		this.missile = missile;
	}
	public void setKnife(KnifeImpl knife) {
		this.knife = knife;
	}

}
