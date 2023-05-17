package com.example.spring.modelo.block;


import java.util.Date;

import com.example.spring.util.StringUtil;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Block {
	
	private String hash;
	private String anteriorHash;
	private String data;
	private long timeStamp;
	private int nonce;
	public Block(String data,String previousHash ) {
		this.data = data;
		this.anteriorHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calcularHash(); //Making sure we do this after we set the other values.
	}
	
	public  String calcularHash() {
		String value = StringUtil.aplicarSHA256(this.anteriorHash+Long.toString(timeStamp)+
				Integer.toString(nonce) +data);
		//System.out.println("Calculado: "+value);
		return value;
	}
	
	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0" 
		System.out.println("Target BEFORE:  " + target);
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = calcularHash();
		}
		
		System.out.println("Block Mined!!! : " + hash);
	}
}
