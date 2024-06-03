// 		╭━━━╮	    ╭╮ ╭━╮╭━╮
// 		┃╭━╮┃	    ┃┃ ┃┃╰╯┃┃
// 		┃┃╱╰╋━┳━━┳━━┫╰━┫╭╮╭╮┣━━╮
// 		┃┃╭━┫╭┫╭╮┃╭╮┃╭╮┃┃┃┃┃┃╭╮┃
// 		┃╰┻━┃┃┃╭╮┃╰╯┃┃┃┃┃┃┃┃┃╭╮┃
// 		╰━━━┻╯╰╯╰┫╭━┻╯╰┻╯╰╯╰┻╯╰╯
// 				 ┃┃
//

plugins {
	`maven-publish`
	signing
	id("gm-inceptor-build.base-conventions")
	id("gm-inceptor-build.build-parameters")
}

publishing {
	publications {
		create<MavenPublication>("mavenJava") {
			from(components["java"])

			groupId    = "gm"
			artifactId = "inceptor"
			version    = "0.0.1"

			pom {
				name.set("gm-inceptor")
				description.set("Generic functional core library for Java")
				url.set("https://github.com/graph-massivizer/graph-inceptor")
				//licenses {
				//	license {
				//		name.set("The Apache License, Version 2.0")
				//		url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
				//	}
				//}
				developers {
					developer {
						id.set("DanielThiloSchroeder")
						name.set("Daniel Thilo Schroeder")
						email.set("contact@danielthiloschroeder.org")
					}
					developer {
						id.set("TobiasHerb")
						name.set("Tobias Herb")
						email.set("tobias.herb@esentri.com")
					}
				}
/*				scm {
					connection = 'scm:git:git://github.com:TobiasHerb/magma.git'
					developerConnection = 'scm:git:ssh://github.com/TobiasHerb/magma'
					url = 'https://github.com:TobiasHerb/magma.git'
				}*/
			}
		}
	}
}

signing {
	sign(publishing.publications["mavenJava"])
}
