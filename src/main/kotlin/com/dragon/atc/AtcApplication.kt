package com.dragon.atc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AtcApplication

fun main(args: Array<String>) {
	runApplication<AtcApplication>(*args)
}
