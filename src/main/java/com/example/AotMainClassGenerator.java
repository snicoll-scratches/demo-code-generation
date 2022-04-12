package com.example;

import javax.lang.model.element.Modifier;

import org.springframework.aot.generator.GeneratedType;
import org.springframework.javapoet.ClassName;
import org.springframework.javapoet.CodeBlock;
import org.springframework.javapoet.MethodSpec;

/**
 *
 * @author Stephane Nicoll
 */
public class AotMainClassGenerator {


	public GeneratedType generate(Class<?> applicationClass) {
		GeneratedType generatedType = GeneratedType.of(ClassName.get(applicationClass.getPackageName(),
				applicationClass.getSimpleName() + "__AotMain"), (type) -> type.addModifiers(Modifier.PUBLIC));
		generatedType.addMethod(generateMainMethod(applicationClass));
		return generatedType;
	}

	private MethodSpec.Builder generateMainMethod(Class<?> applicationClass) {
		CodeBlock.Builder code = CodeBlock.builder();
		code.add("// Test\n");
		code.add("$T.main(args)", applicationClass);

		return MethodSpec.methodBuilder("main").addModifiers(Modifier.PUBLIC, Modifier.STATIC)
				.addParameter(String[].class, "args")
				.addCode(code.build());
	}
}
