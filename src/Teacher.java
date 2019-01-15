import java.util.Random;
/**
 * Declares the derived class Teacher @see Person
 */
public class Teacher extends Person implements Employee {
	
	private int gradeLevel;
	private certification cer;
	public enum certification {Elementary, MiddleSchool, HighSchool};

	/**
	 * no arg constructor uses random number generation to assign enum variable certification and
	 * int variable gradeLevel. A teacher's level of certification is based on a random number from 1-12 representing
	 * grades 1-12. Once assigned, their specific gradeLevel is decided by randomly selecting from
	 * the range of grades covered within their certification.
	 */
	public Teacher() {
		Random rnd = new Random();
		int num = rnd.nextInt(12);
		if (num >= 0 && num <= 6) {
			cer = certification.Elementary;
			Random ernd = new Random();
			int enumber = ernd.nextInt(6);
			gradeLevel = enumber;
		}
		if (num >=7 && num <= 8) {
			cer = certification.MiddleSchool;
			Random mrnd = new Random();
			int mnumer = mrnd.nextInt(2);
					if (mnumer == 0)
						gradeLevel = 7;
					else
						gradeLevel = 8;
		}
		if (num >= 9 && num <= 12) {
			cer = certification.HighSchool;
			Random hrnd = new Random();
			int hnumber = hrnd.nextInt(4);
					if(hnumber == 0)
						gradeLevel =9;
					else if (hnumber == 1)
						gradeLevel = 10;
					else if (hnumber == 2)
						gradeLevel = 11;
					else
						gradeLevel = 12;
		}
	}

	public Teacher(String n, int a, certification c)
	{
		this.setName(n);
		this.setAge(a);
		cer = c;

		Random rnd = new Random();
		int num = rnd.nextInt(12);
		if (this.getCer() == Teacher.certification.Elementary) {
			if (num >= 0 && num <= 6) {
				Random ernd = new Random();
				int enumber = ernd.nextInt(6);
				this.setGradeLevel(enumber);
			}
		}
		if (this.getCer() == Teacher.certification.MiddleSchool) {
			if (num >= 7 && num <= 8) {
				Random mrnd = new Random();
				int mnumer = mrnd.nextInt(2);
				if (mnumer == 0)
					this.setGradeLevel(7);
				else
					this.setGradeLevel(8);
			}
		}
		if (this.getCer() == Teacher.certification.HighSchool) {
			if (num >= 9 && num <= 12) {
				Random hrnd = new Random();
				int hnumber = hrnd.nextInt(4);
				if (hnumber == 0)
					this.setGradeLevel(9);
				else if (hnumber == 1)
					this.setGradeLevel(10);
				else if (hnumber == 2)
					this.setGradeLevel(11);
				else
					this.setGradeLevel(12);
			}
		}
	}
	public int getGradeLevel(){return gradeLevel;}
	public certification getCer() {return cer;}
	public void setGradeLevel(int level) {gradeLevel = level;}


	/**
	 * functions givePay and getIDnum must be implemented due to the implementation
	 * of the Employee interface within this class.
	 */
	public void givePay(double p) {
		setCash(p);
	 }
	 
	 public int getIDnum() {
		 return this.getID();
	 }
}
