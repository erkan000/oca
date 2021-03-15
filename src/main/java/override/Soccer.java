package override;

class Game{
	public void play() throws Exception{
		System.out.println("Playing...");
	}
}

public class Soccer extends Game{
	public void play(){
		System.out.println("Playing Soccer...");      
	}
	public static void main(String[] args){
		Game g = new Soccer();

		//bu satır hata verir, g'nin türü game oldugu için ve g de Exception fırlattığı için.

		//g.play();

	}
}