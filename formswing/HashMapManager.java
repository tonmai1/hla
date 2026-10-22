package formswing;

import java.util.HashMap;
import java.util.Iterator;

public class HashMapManager implements W8StudentManager {
	
	HashMap<Integer, W8StudentMark> data;
	
	public HashMapManager() {
		
		data = new HashMap<Integer, W8StudentMark>();
		
	}
	
	public void insert(W8StudentMark student) {
		
		Integer key = Integer.valueOf((int)student.id);
		data.put(key, student);
		
	}
	
	public void update(W8StudentMark student) {
		
		Integer key = Integer.valueOf((int)student.id);
		W8StudentMark st = data.get(key);
		st.setName(student.name);
		st.setSurname(student.surname);
		st.setMark(student.mark);
		st.setGrade(student.grade);
		
	}
	
	public void delete(int key) {
		
		data.remove(Integer.valueOf(key));
	}
	
	public void view() {
		
		data.forEach((key, value) -> {
			System.out.println("key:" + key + ", value:" + value);
		});
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("HashMapManager()");
		
		HashMapManager students = new HashMapManager();
		
		W8StudentMark student = new W8StudentMark(1, "john", "deer", 76);
		students.insert(student);
		student = new W8StudentMark(2, "alan", "kennedy", 49);
		students.insert(student);
		student = new W8StudentMark(3, "david", "beckham", 73);
		students.insert(student);
		
		students.view();
		
		student = new W8StudentMark(2, "KENNEDY", "ALAN", 60);
		students.update(student);
		
		students.view();
		
		students.delete(0);
		
		students.view();
		
		
	}


}
