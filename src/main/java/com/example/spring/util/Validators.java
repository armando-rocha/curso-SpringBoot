package com.example.spring.util;

import java.util.ArrayList;

import com.example.spring.modelo.block.Block;

public class Validators {
	public static Boolean isChainValid(ArrayList<Block> blockchain, int difficulty) {
		Block currentBlock; 
		Block previousBlock;
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');
		//loop through blockchain to check hashes:
		for(int i=1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			
			
			//compare registered hash and calculated hash:
			if(!currentBlock.getHash().equals(currentBlock.calcularHash()) ){
				System.out.println("Current Hashes not equal");			
				return false;
			}
			//compare previous hash and registered previous hash
			if(!previousBlock.getHash().equals(currentBlock.getAnteriorHash()) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
			
			if(currentBlock.getHash().substring(0,difficulty-1).equals(hashTarget)) {
				System.out.println("Current hash has not been Mined"+ currentBlock.toString());
				return false;
			}
		}
		return true;
	}
}
