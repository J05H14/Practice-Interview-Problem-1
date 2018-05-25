package solution;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,3,1,1};
		int[] b = {2,1,2,2};
		System.out.println(solution(5,6,a,b));
	}
	
	/*
	 * total_money is total money you have
	 * total_damage is total damage caused
	 * costs is cost of every card
	 * damages is damage caused to opponent by every card
	 * 
	 * should return true if possible to cause total_damage amount of damage using max total_money
	 * units of money,  false if not
	 * 
	 * EXAMPLE:
	 * total_money = 5
	 * total_damage = 3
	 * costs = [4,5,1]
	 * damages = [1,2,3]
	 * This should return true
	 */
	public static boolean solution(int total_money, int total_damage, int[] costs, int[] damages) {
		//don't want to change the value of money
		int money = total_money;
		int damage = 0;
		for(int i = 0, attempt = 1; attempt < costs.length; i++) {
			//checks to see if its possible to use card, uses if it can
			if(costs[i] <= money) {
				damage += damages[i];
				money -= costs[i];
			}
			//sees if you can return true yet
			if(damage >= total_damage) {
				return true;
			}
			//resets and changes start value for comparisions
			if(damage < total_damage && i == costs.length-1) {
				i = attempt - 1;
				attempt++;
				damage = 0;
				money = total_money;
			}
		}
		return false;
	}
}
