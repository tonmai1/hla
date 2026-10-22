package formswing;

import java.util.ArrayList;
import java.util.Iterator;


public class ArrayListManager implements W8StudentManager {
	
	ArrayList<W8StudentMark> data;
	
	public ArrayListManager() {
		
		data = new ArrayList<W8StudentMark>();
				
	}
	
	public void insert(W8StudentMark student) {
		
		data.add(student);
		
	}
	
	public void update(W8StudentMark student) {
		
		for(Iterator<W8StudentMark> it=data.iterator(); it.hasNext();) {
			
			W8StudentMark st = it.next();
			if(st.id == student.id) {
				st.name = student.name;
				st.surname = student.surname;
				st.mark = student.mark;
				String grade = W8Grader.decideGrade(st.mark);
				st.grade = grade;
			}
			
		}
		
	}
	
	public void delete(int idx) {
		
		data.remove(idx);
		
	}
	
	public void view() {
		
		for(Iterator<W8StudentMark> it=data.iterator(); it.hasNext();) {
			W8StudentMark st = it.next();
			System.out.println("st:" + st.toString());			
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("ArrayListManager()");
		
		ArrayListManager students = new ArrayListManager();
		
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
