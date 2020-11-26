package Server.serv;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.management.remote.rmi.RMIServer;
import javax.management.remote.rmi.RMIServerImpl_Stub;

public class ServerRMI
extends UnicastRemoteObject 
implements Contract {
	ArrayList<Spectacle> ListSpect = new ArrayList<Spectacle>(); 

	protected ServerRMI() throws RemoteException {
		ListSpect.add(new Spectacle(0266,"Spectacle ba bla ",5));
		System.out.println("List of spectacles initialised ....");
	}


	public String getList() throws RemoteException {
		String str="";
		for(int i=0;i<ListSpect.size();i++) {
			Spectacle c =ListSpect.get(i);
			str+="********************* \n";
			str+="Spectacle  "+c.getId()+" \n Spectacle Name :"+c.getIntitude()+" Places Number :  "+c.getNb_place()+"\n";
		}
		return str ;
	}

	public boolean reserver(int id , int nbr) throws RemoteException {
		for(int i=0;i<ListSpect.size();i++) {
			Spectacle spec = ListSpect.get(i);
			if(spec.getId()==id) {
				if(nbr<= spec.getNb_place()) {
					spec.setNb_place(spec.getNb_place()-nbr);
					if(spec.getNb_place()==0) {
					ListSpect.remove(i);
					}
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
	}

	
public static void main(String[] args) {
	
	System.out.println("Starting RMI Server ....");
	Registry reg ;
	try {
		ServerRMI obj = new ServerRMI();
		
		reg= LocateRegistry.createRegistry(1099);
        System.out.println("java RMI registry created.");
        reg.rebind("RMIServer", obj
        		);
		
		
	} catch (Exception e) {
		System.out.println("Using existing registry");
    	try {
			reg = LocateRegistry.getRegistry();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		e.getMessage();
	}
	
	
	
}
}
