plugins {
    id("java")
}

group = "br.com.iterasys"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation (group ="org.testng", name = "testng", version = "7.10.1")
    testImplementation(group = "io.rest-assured", name = "rest-assured", version = "5.4.0")
    testImplementation("org.slf4j:slf4j-simple:2.0.9")

}

tasks.test {
    useTestNG()
}
