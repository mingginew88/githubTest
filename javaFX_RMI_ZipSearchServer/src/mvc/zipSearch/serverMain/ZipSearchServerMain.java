package mvc.zipSearch.serverMain;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import mvc.zipSearch.service.ZipSearchService;
import mvc.zipSearch.service.ZipSearchServiceInf;

public class ZipSearchServerMain {

	public static void main(String[] args) {
		try {
			ZipSearchServiceInf zipService = new ZipSearchService();
			
			Registry reg = LocateRegistry.createRegistry(9988);
			
			reg.rebind("zipSearch", zipService);
			
			System.out.println("서버 준비 완료");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
