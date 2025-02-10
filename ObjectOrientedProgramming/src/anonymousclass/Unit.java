package anonymousclass;

/**
 * LOL 캐릭터
 * 이동
 * 기본 공격
 * 스킬 공격
 * 귀환
 * 아이템 구매
 * 아이템 판매
 * 대사 외치기
 * 감정 표현
 * 사망
 * 미니언 잡기
 *  
 */
public interface Unit {
	public void move();
	public void basicAttack(Unit otherCharacter);
	public void skillAttack(Unit otherCharacter);
	public void recall();
	public void buyItem();
	public void sellItem();
	public void speak();
	public void emotion();
	public void die();
	public void takeMinions();
	
	public int getHp();
	public void setHp(int hp);
	public int getDefence();
}
