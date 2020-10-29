/**
 * Data element class
 * @author Yared Fikremariam
 *
 */
public class CourseDBElement implements Comparable {

	protected String cid;
	protected int crn;
	protected int crdt;
	protected String rm;
	protected String ins;
	
	
	/**
	 * No arg constructor
	 */
	public CourseDBElement() {
		cid = "";
		crn = 0;
		crdt= 0;
		rm = "";
		ins= "";
		
	}
	
	/**
	 * Constructor 
	 * @param cid Course ID
	 * @param crn CRN
	 * @param cr Credits
	 * @param room Room Number
	 * @param ins Instructor
	 */
	public CourseDBElement(String cid,int crn,int cr,String room,String ins) {
		
		this.cid = cid;
		this.crn = crn;
		this.crdt= cr;
		this.rm = room;
		this.ins= ins;
		
	}
	
	
	
	
	/**
	 * Compares this cde to the given cde
	 */
	@Override
	public int compareTo(CourseDBElement element) {
		
		return this.compareTo(element);
	}
	
	@Override
	public int hashCode()
	{
		return crn;
		
	}

	public int getCRN() {
		
		return this.crn;
	}
	
	@Override
	public String toString()
	{
		return "Course:"+cid+" CRN:"+crn+" Credits:"+crdt+" Instructor:"+ins+" Room:"+rm;
		
		
	}

	public void setCRN(int parseInt) {
		// TODO Auto-generated method stub
		
	}

}
