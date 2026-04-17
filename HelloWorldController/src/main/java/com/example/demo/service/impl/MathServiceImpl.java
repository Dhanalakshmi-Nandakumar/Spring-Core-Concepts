package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.service.interfaces.MathService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class MathServiceImpl implements MathService {
	//creating no args constructor
	public MathServiceImpl()
	{
		log.info("MathServiceImpl no-args constructor called and object is {}",this);
	}

	@Override
	public int add(int val1, int val2)
	{
        log.info("Add method called from MathServiceImpl and object is {}",this);
		log.info("MathServiceImpl add method called with val1={} and val2={}", val1, val2);
		return val1 + val2;
	}
	
	@Override
	public int sub(int a, int b)
	{
		log.info("Subtract method called from MathServiceImpl and object is {}",this);
		log.info("MathServiceImpl sub method called with a={} and b={}", a, b);
		return a - b;
	}
	
	@Override
	public int mul(int m1, int m2)
	{
		log.info("Multiply method called from MathServiceImpl and object is {}",this);
		log.info("MathServiceImpl mul method called with m1={} and m2={}", m1, m2);
		return m1 * m2;
	}

}
