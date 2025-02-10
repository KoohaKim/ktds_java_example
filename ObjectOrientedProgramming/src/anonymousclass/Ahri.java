package anonymousclass;

public class Ahri implements Unit{

	private String characterName;
	private String playerName;
	private int level;
	private int hp;
	private int mana;
	private int money;
	private int attackDamage;
	private int defence;
	private float attackSpeed;
	
	
	
	public Ahri(String playerName) {
		this.playerName = playerName;
		this.level = 1;
		this.hp = 100;
		this.mana = 100;
		this.attackDamage = 20;
		this.defence = 10;
		this.attackSpeed = 1.5f;
	}
	
	
	
	@Override
	public int getHp() {
		return this.hp;
	}


	@Override
	public void setHp(int hp) {
		this.hp = hp;		
	}


	@Override
	public int getDefence() {
		return this.defence;
	}



	@Override
	public void move() {
		System.out.println(this.playerName + "이동중");
	}

	@Override
	public void basicAttack(Unit otherCharacter) {
		int otherCharacterHp = otherCharacter.getHp();
		//상대 캐릭터에게 가할 공격 포인트
		int attackDamage = this.attackDamage - otherCharacter.getDefence();
		if(attackDamage < 0) {
			attackDamage = 0;
		}
		
		otherCharacterHp -= attackDamage;
		otherCharacter.setHp(otherCharacterHp);
	}

	@Override
	public void skillAttack(Unit otherCharacter) {
		int otherCharacterHp = otherCharacter.getHp();
		//상대 캐릭터에게 가할 공격 포인트
		int attackDamage = (this.attackDamage + this.level) 
				- otherCharacter.getDefence();
		if(attackDamage < 0) {
			attackDamage = 0;
		}
		
		otherCharacterHp -= attackDamage;
		otherCharacter.setHp(otherCharacterHp);
	}

	@Override
	public void recall() {
		System.out.println(this.characterName +"가 귀환함, playerName: " + this.playerName);		
	}

	@Override
	public void buyItem() {
		this.money -=100;
		System.out.println(this.money);
		
	}

	@Override
	public void sellItem() {
		this.money +=100;
		System.out.println(this.money);
	}

	@Override
	public void speak() {
		String[] script = new String[] {
			"얍!","호이호이","크아악"	
		};
		System.out.println(script[(int)(Math.random() * script.length)]);
	}

	@Override
	public void emotion() {
		System.out.println("^^b");		
	}

	@Override
	public void die() {
		System.out.println(this.characterName + " die");
	}

	@Override
	public void takeMinions() {
		this.money += 3;
		System.out.println(this.money);		
	}
	
}
