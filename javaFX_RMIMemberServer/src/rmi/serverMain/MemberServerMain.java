package rmi.serverMain;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.service.IMemberService;
import rmi.service.MemberService;



public class MemberServerMain {
	public static void main(String[] args) {
		try {
			IMemberService memberService = new MemberService();
			
			Registry reg = LocateRegistry.createRegistry(9988);
			
			reg.rebind("member", memberService);
			
			System.out.println("서버 준비 완료");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
