// 		╭━━━╮	    ╭╮ ╭━╮╭━╮
// 		┃╭━╮┃	    ┃┃ ┃┃╰╯┃┃
// 		┃┃╱╰╋━┳━━┳━━┫╰━┫╭╮╭╮┣━━╮
// 		┃┃╭━┫╭┫╭╮┃╭╮┃╭╮┃┃┃┃┃┃╭╮┃
// 		┃╰┻━┃┃┃╭╮┃╰╯┃┃┃┃┃┃┃┃┃╭╮┃
// 		╰━━━┻╯╰╯╰┫╭━┻╯╰┻╯╰╯╰┻╯╰╯
// 				 ┃┃
//
plugins {
	id("gm-inceptor-build.java-library-conventions")
	id("gm-inceptor-build.publishing-conventions")
	java
}

tasks.register<Jar>("fatJar") {
	manifest {
		attributes["Main-Class"] = "playground.examples.Main"
	}
	duplicatesStrategy = DuplicatesStrategy.EXCLUDE
	from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
	with(tasks.jar.get() as CopySpec)
}

tasks.withType<JavaExec> {
	doFirst {
		println("TODO remove! Hello World - Starting test tasks")
	}

	doLast {
		println("TODO remove! Hello World - Finished test tasks")
	}

	jvmArgs("--add-opens", "java.base/java.nio=ALL-UNNAMED")
}

tasks.withType<Test> {
	jvmArgs("--add-opens", "java.base/java.nio=ALL-UNNAMED")
}

dependencies {
//	implementation(libs.bundles.magma)
}