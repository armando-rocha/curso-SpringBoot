package com.example.spring;

import java.util.ArrayList;

import javax.xml.validation.Validator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring.modelo.Persona;
import com.example.spring.modelo.block.Block;
import com.example.spring.util.StringUtil;
import com.example.spring.util.Validators;
import com.google.gson.GsonBuilder;

@SpringBootTest
class CursoSpringBoot2ApplicationTests {
	public static ArrayList<Block> blockchain = new ArrayList<Block>(); 
	public static int difficulty = 5;

	
/*	void contextLoads() {
		Persona p1= Persona.builder().nombre("Armando").build();
		System.out.println(p1.getNombre());
		String res = StringUtil.aplicarSHA256("ABCD");
		System.out.println(res);
	}*/
	
	
	/*@Test
	void blockChain() {
		Block b1 = new Block("Hi im the first block", "0");
		//Block b1 = Block.builder().anteriorHash(null).data(null).timeStamp(new Date().getTime()).hash(b1.calcularHash()).build();
		System.out.println(b1.getHash());
		Block b2 = new Block("Hi im the second block", b1.getHash());
		System.out.println(b2.getHash());
		Block b3 = new Block("Hi im the third block", b2.getHash());
		System.out.println(b3.getHash());
		
	
	}*/
	
	@Test
	void blockChainWithArray() {
		blockchain.add(new Block("Hi im the first block", "0"));
		System.out.println("Primer bloque " + blockchain.get(0).getHash());
		blockchain.get(0).mineBlock(difficulty);
		//System.out.println("Primer bloque " + blockchain.get(0).getHash());
		blockchain.add(new Block("Hi im the second block", blockchain.get(blockchain.size()-1).getHash()));

		System.out.println("Segundo bloque " + blockchain.get(1).getHash());
		blockchain.get(1).mineBlock(difficulty);
		//System.out.println("Segundo bloque " + blockchain.get(1).getHash());
		
		blockchain.add(new Block("Hi im the third block", blockchain.get(blockchain.size()-1).getHash()));
		System.out.println("tercer bloque " + blockchain.get(2).getHash());
		blockchain.get(2).mineBlock(difficulty);
		//System.out.println("tercer bloque " + blockchain.get(2).getHash());
		
		String json=  new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);		
		System.out.println(json);
		
		Validators.isChainValid(blockchain,difficulty);
		
		System.out.println(" is a valid Chain " + Validators.isChainValid(blockchain,difficulty));
	}
}
