/**
 * 
 */
package introUnit;

/**
 * @author Student 6
 * This class is designed to contrast with the ProceduralExample. It embodies an Object Oriented Approach.
 */
public class OOPExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student jillian = new Senior("Jillian", "Programmer");
		Student joseph = new Freshman("Joseph");
		Student jordan = new Sophomore("Jordan");
		jillian.talk();
		joseph.talk();
		jordan.talk();
		}

}
