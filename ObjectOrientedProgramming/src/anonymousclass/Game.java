package anonymousclass;

public class Game {
	public static void main(String[] args) {
		Unit ahri = new Ahri("faker");

		// 클래스 구현없이 인스턴스를 만드려면 new 추상클래스 혹은 인터페이스() {}
		Unit otherUnit = new Unit() {

			private String characterName = "1회용 히든";
			private String playerName = "김구하";
			private int level = 100;
			private int hp = 1000;
			private int mana = 10000;
			private int money = 99999;
			private int attackDamage = 10000;
			private int defence = 5000;
			private float attackSpeed = 0.1f;

			// 생성자 사용 불가
//			public Ahri(String playerName) {
//				this.playerName = playerName;
//				this.level = 1;
//				this.hp = 100;
//				this.mana = 100;
//				this.attackDamage = 20;
//				this.defence = 10;
//				this.attackSpeed = 1.5f;
//			}
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
				// 상대 캐릭터에게 가할 공격 포인트
				int attackDamage = this.attackDamage - otherCharacter.getDefence();
				if (attackDamage < 0) {
					attackDamage = 0;
				}

				otherCharacterHp -= attackDamage;
				otherCharacter.setHp(otherCharacterHp);
			}

			@Override
			public void skillAttack(Unit otherCharacter) {
				int otherCharacterHp = otherCharacter.getHp();
				// 상대 캐릭터에게 가할 공격 포인트
				int attackDamage = (this.attackDamage + this.level) - otherCharacter.getDefence();
				if (attackDamage < 0) {
					attackDamage = 0;
				}

				otherCharacterHp -= attackDamage;
				otherCharacter.setHp(otherCharacterHp);
			}

			@Override
			public void recall() {
				System.out.println(this.characterName + "가 귀환함, playerName: " + this.playerName);
			}

			@Override
			public void buyItem() {
				this.money -= 100;
				System.out.println(this.money);

			}

			@Override
			public void sellItem() {
				this.money += 100;
				System.out.println(this.money);
			}

			@Override
			public void speak() {
				String[] script = new String[] { "얍!", "호이호이", "크아악" };
				System.out.println(script[(int) (Math.random() * script.length)]);
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

		};

		ahri.move();
		otherUnit.move();

		ahri.basicAttack(otherUnit);
		otherUnit.skillAttack(ahri);

		ahri.speak();
		otherUnit.speak();

	}
}
