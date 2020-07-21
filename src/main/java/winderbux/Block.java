package winderbux; 

import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    private String data; //our data will be a simple message.
    private long timeStamp; //as number of milliseconds since 1/1/1970.
    
    //Block Constructor.
    public Block(String data,String previousHash) {
	this.data = data;
	this.previousHash = previousHash;
	this.timeStamp = new Date().getTime();
	// must be set after other items instantiated 
	this.hash = calculateHash(); 
    }
    
    
    public String calculateHash() {
	StringBuffer buf = new StringBuffer(previousHash)
	                          .append(Long.toString(timeStamp))
	                          .append(data); 
	
	return StringUtil.applySha256(buf.toString());
    }

    public static Boolean isChainValid() {
	Block currentBlock; 
	Block previousBlock;
	
	//loop through blockchain to check hashes:
	for(int i=1; i < blockchain.size(); i++) {
	    currentBlock = blockchain.get(i);
	    previousBlock = blockchain.get(i-1);
	    //compare registered hash and calculated hash:
	    if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
		System.out.println("Current Hashes not equal");			
		return false;
	    }
		//compare previous hash and registered previous hash
	    if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
		System.out.println("Previous Hashes not equal");
		return false;
	    }
	}
	return true;
    }
    
}
