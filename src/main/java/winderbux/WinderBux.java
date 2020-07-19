package winderbux;

import java.util.ArrayList; 
import com.google.gson.GsonBuilder;

public class WinderBux {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static void main(String[] args) {
	blockchain.add(new Block("Genesis block", "0"));		
	blockchain.add(new Block("Second block",blockchain.get(blockchain.size()-1).hash)); 
	blockchain.add(new Block("Third block",blockchain.get(blockchain.size()-1).hash));
	
	System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(blockchain));
    }

}
