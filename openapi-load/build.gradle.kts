plugins {
    kotlin("jvm")
	jacoco
}

configure<SourceSetContainer> {
	named("main") {
		java.srcDir("src/main/kotlin")
	}
}

dependencies {
	implementation(kotlin("stdlib-jdk8"))
	api("io.swagger.parser.v3:swagger-parser:2.0.19")
	implementation("org.kohsuke.metainf-services:metainf-services:1.8")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.9")
	implementation("com.squareup.okhttp3:okhttp:4.2.0")
	implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.9.9")
	implementation("com.amazonaws:aws-java-sdk-cognitoidp:1.11.699")
	implementation("org.json:json:20170516")

	testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

jacoco {
	toolVersion = "0.8.5"
}

tasks.jacocoTestReport {
	reports {
		xml.isEnabled = true
	}
}

tasks.test {
	finalizedBy(tasks.jacocoTestReport)
}
tasks.jacocoTestReport {
	dependsOn(tasks.test)
}
