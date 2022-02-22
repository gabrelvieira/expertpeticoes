package br.com.expertpeticoes.curso.controller.onedrive;

public class MainTest {

	public static void main(String[] args) {
		String refresh = "M.R3_BAY.-CUqdUfwHoKmz!IlZGzk2qiwF2U7kdHEqMfvSn7cuagCJ*72C6beyvrvky1!NMmIFsu!6Ssj7qDVDV91YyCcYsrFzj*Fhhaw92ZLZub0epaF!1EJ4zrKc0ExAhHnZWbPjrmQTol62qN8A*gJCuo5q2z5kLKRbt7aIstCQmlMKMCMZtQojh7qB61FG*kvC9prhiICH2I7szkj2crg5934RbSrnK0fvJedhsaz8gWGWRQm3jGk2iu!aB!wwYZCcFQPRJfpr1pyTztI9ca4*x4PSRri1a!0D9g3axS4Oa3TXrlmoVuC*CQZtIiutJFBj9VUs2Q$$";
		OneDrive oneDrive = new OneDrive(refresh, "MjX7Q~JOzNddrpR3K-XZcmRYCtOf61ZBsPnPg", "http://localhost/auth");
		
		oneDrive.setToken("dsfs");
		
		System.out.println(oneDrive.getLink("/Imagens/gabriel/apache.zip"));
		
		System.out.println(oneDrive.getToken());
	}
	
}
