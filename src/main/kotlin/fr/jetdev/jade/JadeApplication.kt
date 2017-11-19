package fr.jetdev.jade

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class JadeApplication {

//    @Bean
//    fun controller() = CollaboratorController()


}

fun main(args: Array<String>) {
    SpringApplication.run(JadeApplication::class.java, *args)
}



