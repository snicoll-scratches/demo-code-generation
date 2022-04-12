package com.example;

import org.springframework.aot.generator.GeneratedType;

public class DemoCodeGenerationApplication {

	public static void main(String[] args) {
		AotMainClassGenerator generator  =new AotMainClassGenerator();
		GeneratedType generate = generator.generate(DemoCodeGenerationApplication.class);
		System.out.println(generate.toJavaFile());
	}

}
