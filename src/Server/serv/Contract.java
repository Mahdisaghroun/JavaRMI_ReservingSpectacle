package Server.serv;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Contract extends Remote{
	
	public String getList() throws RemoteException  ;
	public boolean reserver(int id , int nbr) throws RemoteException;
	

}
