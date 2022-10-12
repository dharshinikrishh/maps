package maps2;

import java.time.zone.ZoneOffsetTransitionRule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class StudentUIForm {

	public static void main(String[] args) {
	
		
		StudentServerCode server = new StudentServerCode();
		
		Scanner sc = new Scanner(System.in);
		Scanner scStr = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("\n\n\n        *** Application ***");
			System.out.println("1. Add Student ");
			System.out.println("2. Update Student Profile");
			System.out.println("3. Add Student Marks. ");
			System.out.println("4. View Student Marks by Roll Number & Stream. ");
			System.out.println("5. View Students Based on Stream. ");
			System.out.println("6. View Student Marks (High to low) Based on Stream.");
			System.out.println("7. View Student Based on State.");
			System.out.println("8. Get Student Profile Based on Roll Number & Stream ");
			System.out.println("9. View All Students"); // print entire map
			System.out.println("10. Add Students Certificates");
			
			System.out.println("0. EXIT");
			System.out.println("\n\t Enter Option ");
			
			switch (sc.nextInt()) {
			case 1:
				
				System.out.println("Enter Student Name ");
				String studentName = scStr.nextLine();
				
				System.out.println("Enter Student Stream ");
				System.out.println("IT/CS/ELE/MCA");
				String studentStream = scStr.nextLine();
				studentStream = studentStream.trim().toUpperCase();
				
				int rollNum = getRandom();
				
				Student basicStudent = new Student(rollNum, studentName, studentStream);
				
				int count = server.insertStudent(basicStudent);
				System.out.println(" Student Added in Stream "+studentStream+" total Students are :- "+count);
				break;

			case 2:
				
				System.out.println("Enter Student Roll Number ");
				int rollNumber = sc.nextInt();
				
				System.out.println("Enter Student Stream ");
				String searchStream = scStr.nextLine();
				searchStream = searchStream.trim().toUpperCase();
				
				Student s = server.getStudentBasedOnRollNumberAndStream(rollNumber, searchStream);
				
				if(s != null)
				{
					// if student is not null then only update the profile otherwise render msg

					System.out.println("Enter House Number ");
					String houseNumber = scStr.nextLine();
					
					System.out.println("Enter City ");
					String city = scStr.nextLine();
					
					System.out.println("Enter State ");
					String state = scStr.nextLine();
					
					System.out.println("Enter Email ");
					String email = scStr.nextLine();
					
					System.out.println("Enter Phone Number ");
					long phoneNumber = sc.nextLong();
					
					StudentDetails profile = new StudentDetails(houseNumber, city, state, phoneNumber, email);
					
					Student updatedStudent = server.updateStudentProfile(s, profile);
					printStudents(updatedStudent);
				}
				else
				{
					System.out.println(" \n STUDENT NOT FOUND WRONG ROLL NUMBER OR STREAM \n");
					System.out.println("Entered Roll Number "+rollNumber);
					System.out.println("Entered Stream "+searchStream);
				}
				
				break;

			case 3:
				
				System.out.println("Enter the student roll number: ");
				int rollno=sc.nextInt();
				
				System.out.println("Enter the Student Stream");
				System.out.println("IT/CS/ELE/MCA");
				String searchstream = scStr.nextLine();
				searchstream = searchstream.trim().toUpperCase();
				
				Student s1=server.getStudentBasedOnRollNumberAndStream(rollno, searchstream);
				if (s1!= null) 
				{
				//entering the subject wise marks of desiredStudent
				
				Subject java=new Subject("OOPSJava", "abc",85);
				Subject st=new Subject("testing", "dsy",72);
				Subject db=new Subject("database", "abc",99);
				Subject os=new Subject("operatingststem", "abc",75);
				Subject cloud=new Subject("cloud", "abc",68);
				
				List<Subject> subjectList=new ArrayList<>();
				subjectList.add(java);
				subjectList.add(st);
				subjectList.add(db);
				subjectList.add(os);
				subjectList.add(cloud);
		
				
				//it takes student info and the student marks as list of students
				Student desiredStudentwithMarks=server.addStudentMarks(s1,subjectList);
				
				printStudents(s1);
				
				}

				break;
		
			case 4:
				System.out.println("Enter the student roll number: ");
				int rollno1=sc.nextInt();
				
				System.out.println("Enter the Student Stream");
				System.out.println("IT/CS/ELE/MCA");
				String searchstream1 = scStr.nextLine();
				searchstream1 = searchstream1.trim().toUpperCase();
				
				Student s2=server.getStudentBasedOnRollNumberAndStream(rollno1, searchstream1);
				printStudents(s2);
				
				//server.getStudentBasedOnRollNumberAndStream(0, null);
				
				break;

			case 5:
				System.out.println("Enter Student Stream ");
				System.out.println("IT/CS/ELE/MCA");
				String searchedStream = scStr.nextLine();
				searchedStream = searchedStream.trim().toUpperCase();
				
				List<Student> allStudents =  server.getStudentByStream(searchedStream);
				for (Student student : allStudents) {
					printStudents(student);
				}
				
				break;

			case 6:
				System.out.println("Enter Student Stream ");
				System.out.println("IT/CS/ELE/MCA");
				String searchedStream1 = scStr.nextLine();
				searchedStream1 = searchedStream1.trim().toUpperCase();
				
				
				server.getStudentByStreamSortedByMarks(null);
				break;
				
			case 7:
				System.out.println("Enter Student State ");
				String searchedState = scStr.nextLine();
				searchedState = searchedState.trim().toUpperCase();
				
				List<Student> allStudentsDetails =  server.getStudentByState(searchedState);
				for (Student student : allStudentsDetails) 
				{
					printStudents(student);
				}
			case 10:
			{
				System.out.println("Enter Student Roll Number ");
				int rollNo2= sc.nextInt();
				System.out.println("Enter Student Stream ");
				String searchStream2= scStr.nextLine();

				Student s3= server.getStudentBasedOnRollNumberAndStream(rollNo2, searchStream2);
				if (s3 != null) {
					System.out.println("Enter the Certification Name ");
					String certificateName = scStr.nextLine();
					
					System.out.println("Enter the Certification Domain ");
					String domain= scStr.nextLine();
					Certificates c=new Certificates(certificateName, domain);
					List<Certificates> certificateList = getCertificates();
					
					certificateList.add(c);
					
					Student studentWithCertificates=server.addStudentCertificates(s3,certificateList);
	                printStudents(studentWithCertificates);
					
				}
				
			}

			case 0:				
			default:
				System.exit(0);
			}//end switch
			
		}//end while
		
	}//end of Main

	
	private static List<Certificates> getCertificates() {
		// TODO Auto-generated method stub
		Certificates c1=new Certificates("java","Training ");
		Certificates c2=new Certificates("Singer","Singing");
		Certificates c3=new Certificates("TC","Graduation");
		Certificates c4=new Certificates("MarkList","Graduation");
		
		List<Certificates> certificateList = new ArrayList<>();
		certificateList.add(c1);
		certificateList.add(c2);
		certificateList.add(c3);
		certificateList.add(c4);
		
		return certificateList;
	}


	public static void printStudents(Student student)
	{
		
			
			System.out.print("\n"+student.getRollNum()+"\t");
			System.out.print(student.getName()+"\t");
			System.out.print(student.getStream()+"\t");
			
			System.out.println("\n Student Profile \n");
			StudentDetails profile = student.getProfile();
			if(profile != null)
			{
				System.out.print(profile.getHouseNumber()+" "+profile.getCity()+" "+profile.getState()+" \t");
				System.out.print(profile.getPhoneNumber()+" \t");
				System.out.print(profile.getEmail()+" \t");
			}
			else
			{
				System.out.println(" *** Profile Not Update !!!");
			}
			
			List<Subject> subjects = student.getAllSubjects();
			
			System.out.println("\n  Subject Details \n");
			
			if(subjects != null)
			{
				for (Subject subject : subjects) {
					System.out.println(subject.getSubjectName()+" - "+subject.getMarksObtain());
				}
			}
			else
			{
				System.out.println("  Marks Not Updated By Faculty !!! ");
			}
			List<Certificates> certificates = student.getAllCertificates();
			System.out.println("\n   Certificates \n");
			if(certificates != null)
			{
				for(Certificates certificate : certificates)
				{
					System.out.println(certificate.getCertificateName()+"-"+certificate.getDomain());
				}
			}
			else
			{
				System.out.println("Certificates are not updated");
			}
			System.out.println("\n____________________________________________________________________________\n");
			
		
	}
	
	public static int getRandom()
	{
		return new Random().nextInt(1000);
	}

	
}