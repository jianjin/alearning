public class SortHeap{


	private static int[] sort = new int[]{1,0,10,20,3};
	public static void main(String[] args) {
		buildHeap(sort);
		heapsort(sort);
		print(sort);
	}

	static void heapsort(int [] data){
		for (int i = data.length - 1; i >= 0; i--) {
			int temp = data[0];
			data[0] = data[i];
			data[i] = temp;
			maxHeapify(data, i, 0);
		}
	}

	public static void buildHeap(int [] data){
		for(int i = getParentIndex(data.length - 1); i >=0 ; i--){
			maxHeapify(data, data.length, i);
		}
	}

	public static void maxHeapify(int [] data, int heapsize, int index){
		// System.out.println("heapify "+index+" "+data[index]);
		int left = getChildLeft(index);
		int right = getChildRight(index);

		//System.out.println("heapify "+index+" "+data[index]+" "+left+" "+right);

		int largest = index;
		if( left < heapsize && data[largest] < data[left]){
			largest = left;
		}

		if(right < heapsize && data[largest] < data[right]){
			largest = right;
		}

		if(largest != index){
			int tmp = data[index];
			data[index] = data[largest];
			data[largest] = tmp;
			maxHeapify(data, heapsize, largest);
		}
	}

	public static int getParentIndex(int current){
		return (current -1 ) >> 1;
	}

	public static int getChildLeft(int index){
		return (index << 1) + 1;
	}

	public static int getChildRight(int index){
		return (index << 1) + 2;
	}

	private static void print(int[] data){
		int pre = -2;
		for (int i = 0; i < data.length; i++) {
			if (pre < (int)getLog(i+1)) {
				pre = (int)getLog(i+1);
				System.out.println();
			} 
			System.out.print(data[i] + " |");
		}
	}
 
	/**
	 * 以2为底的对数
	 * @param param
	 * @return
	 */
	private static double getLog(double param){
		return Math.log(param)/Math.log(2);
	}


}