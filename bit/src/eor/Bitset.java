package eor;

import java.util.Arrays;

//https://leetcode-cn.com/problems/design-bitset/
// 实现一个位图
public class Bitset {
	int count1=0;
	int[] bitMap,mask;
	int size;
	public Bitset(int size) {
		this.size=size;
		bitMap = new int[size];
		mask = new int[size];
		Arrays.fill(mask,1);
	}

	public void fix(int idx) {
		if(bitMap[idx]==0){
			bitMap[idx]=1;
			mask[idx]=0;
			count1++;
		}
	}

	public void unfix(int idx) {
		if(bitMap[idx]==1){
			bitMap[idx]=0;
			mask[idx]=1;
			count1--;

		}
	}

	public void flip() {
		int[] temp = bitMap;
		bitMap = mask;
		mask = temp;
		count1 = size-count1;
	}

	public boolean all() {
		return count1==size;
	}
	public boolean one() {
		return count1>=1;
	}
	public int count() {
		return count1;
	}
	public String toString() {
		StringBuilder res = new StringBuilder();
		for(int i=0;i<size;i++){
			res.append(bitMap[i]);
		}
		return res.toString();
	}
}


//左神解法
class Bitset2 {
		private int[] set;
		private final int size;
		private int zeros;
		private int ones;
		private boolean reverse;

		public Bitset2(int n) {
			// a/b向上取整 (a+(b-1))/b
			set = new int[(n + 31) / 32];
			size = n;
			zeros = n;
			ones = 0;
			reverse = false;
		}

		// 把i这个数字加入到位图
		public void fix(int i) {
			int index = i / 32;
			int bit = i % 32;
			if (!reverse) {
				// 位图所有位的状态，维持原始含义
				// 0 : 不存在
				// 1 : 存在
				if ((set[index] & (1 << bit)) == 0) {
					zeros--;
					ones++;
					set[index] |= (1 << bit);
				}
			} else {
				// 位图所有位的状态，翻转了
				// 0 : 存在
				// 1 : 不存在
				if ((set[index] & (1 << bit)) != 0) {
					zeros--;
					ones++;
					set[index] ^= (1 << bit);
				}
			}
		}

		// 把i这个数字从位图中移除
		public void unfix(int i) {
			int index = i / 32;
			int bit = i % 32;
			if (!reverse) {
				if ((set[index] & (1 << bit)) != 0) {
					ones--;
					zeros++;
					set[index] ^= (1 << bit);
				}
			} else {
				if ((set[index] & (1 << bit)) == 0) {
					ones--;
					zeros++;
					set[index] |= (1 << bit);
				}
			}
		}

		public void flip() {
			reverse = !reverse;
			int tmp = zeros;
			zeros = ones;
			ones = tmp;
		}

		public boolean all() {
			return ones == size;
		}

		public boolean one() {
			return ones > 0;
		}

		public int count() {
			return ones;
		}

		public String toString() {
			StringBuilder builder = new StringBuilder();
			for (int i = 0, k = 0, number, status; i < size; k++) {
				number = set[k];
				for (int j = 0; j < 32 && i < size; j++, i++) {
					status = (number >> j) & 1;
					status ^= reverse ? 1 : 0;
					builder.append(status);
				}
			}
			return builder.toString();
		}
	}