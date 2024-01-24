package main;

import cui.TuincentrumApplicatie;
import domein.DomeinController;

public class StartUp {

	public static void main(String[] args) 
	{
		new TuincentrumApplicatie(new DomeinController()).start();
	}
}



//package main;
//
//import cui.TuincentrumApplicatie;
//import domein.DomeinController;
//import domein.Tuincentrum;
//
//public class StartUp {
//
//	public static void main(String[] args) 
//	{
//		DomeinController dc = new DomeinController();
//		TuincentrumApplicatie tc = new TuincentrumApplicatie(dc);
//		tc.start();
//	}
//
//}
