package Client.cli;

import java.awt.Robot;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

import Server.serv.Contract;

public class ClientRMI {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	while(true) {
	try {
		
		Registry reg = LocateRegistry.getRegistry("localhost");
		Contract obj = (Contract) reg.lookup("RMIServer");
		if(obj instanceof Contract) {
			System.out.println( obj.getList());
			
		}else {
			System.out.println("Object is not an instance of contract ");
		}
		System.out.println("You Want to reserve place for spectacle  Y/N ?");
		String res=sc.nextLine();
		if(res.toUpperCase().equals("Y")){
			int arr []= getParameter();
			if(obj.reserver(arr[0],arr[1])) {
				System.out.println("Success");
				System.out.println(obj.getList());
			}else System.out.println("Failed To reserve places");
		}
		
	} catch (RemoteException | NotBoundException e) {


		e.printStackTrace();
	}}
}
public static int[] getParameter() {
	Scanner sc = new Scanner (System.in);
	System.out.println("Please Enter the ID of Spectacle and number of places ");
	System.out.print("ID :");
	
	int ID=sc.nextInt();
	System.out.print("Number Of Places :");
	
	int nbr = sc.nextInt();
	int [] array= {ID,nbr};
	return array ;
	
}
}
