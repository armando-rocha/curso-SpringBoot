package com.example.spring.modelo.block;

import java.util.Date;

import com.example.spring.modelo.Persona;

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
	private String prevousHash;
	private String data;
	private long timeStamp;
}
