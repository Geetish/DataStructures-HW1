

public class MyArray {
	private String[] strArray;
	private static int cnt;
	
	//Constructor
	public MyArray(int size){
		strArray = new String[size];
	}
	
	/*
	 * This method is used to add elements into the array
	 * @param str The String that is to be inserted into the array
	 * 
	 */
	public void add(String str){
		// Array full condition
		if(strArray.length == cnt){
			strArray = createNewArray(strArray.length);
		}
		strArray[cnt]=str;
		cnt++;
	}
	
	/*
	 * This method is used to create a new array which has
	 * a size twice that of the older one 
	 * @param size The old size of the array
	 * @return the newly created array
	 * 
	 */
	
	private String[] createNewArray(int size){
		// If the size is 0 then create a new array of size 1
		if(size==0) 
			return new String[1];
		else{
			String[] tempArray=new String[(size*2)];
			System.arraycopy(strArray, 0, tempArray, 0, strArray.length);
			return tempArray;
		}
	}
	
	/* This method returns the capacity of the array
	 * @return the capacity of the array
	 * 
	 */
	
	public int getCapacity(){
		return strArray.length;
	}
	
	/* This method returns the number of elements in the array
	 * @return the number of elements
	 * 
	 */
	public int size(){
		return cnt;
	}
	
	/* This method is used to display the elements of the array
	 * 
	 */
	public void display(){
		StringBuilder str=new StringBuilder();
		for(int i=0;i<cnt;i++){
			str.append(" "+strArray[i]);
			if(i%10==0 && i!=0){
				str.append("\n");
			}
		}
		System.out.println(str);
	}
	
	/* This method is used to remove duplicates from the Array
	 * 
	 */
	public void removeDups(){
		int uniqueIndex= 0;
		int j=0;
		for(int i=1;i<cnt;i++){
			j=0;
			for(;j<=uniqueIndex;j++){
				if(strArray[j].equals(strArray[i])){
					break;
				}
			}
			if(j==uniqueIndex+1){
				uniqueIndex+=1;
				strArray[uniqueIndex] = strArray[i];
			}
		}
		cnt=uniqueIndex+1;
	}
	
	/* This method is used to search for an element in the array
	 * 
	 */
	public boolean search(String str){
		for(int i=0;i<cnt;i++){
			if(strArray[i].equals(str)){
				return true;
			}
		}
		return false;
	} 
}
