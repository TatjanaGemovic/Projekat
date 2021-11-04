package gui;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if(args.length != 0) {
			
			int param = 0;
			String arg0 = args[0];
			try {
				param = Integer.parseInt(arg0);
			} catch (Exception e) {
				System.out.println("Neispravna vrednost ulaza");
				System.exit(0);
			}
			
			switch (param) {
			case 1:	//Osnovni frejm sa toolbar-om i menubar-om
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
				break;
			default:
				System.out.println("Uneli ste nepostojecu vrednost");
				break;
			}
		} else {
			System.out.println("Niste uneli vrednost ulaznog parametra!");
		}
	}

}
