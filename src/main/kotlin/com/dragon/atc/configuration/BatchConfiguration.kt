package com.dragon.atc.configuration

import com.dragon.atc.task.Step1
import com.dragon.atc.task.Step2
import org.springframework.batch.core.*
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.Scheduled
import java.lang.Exception
import java.util.Date

@Configuration
@EnableBatchProcessing
class BatchConfiguration(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,
    private val jobLauncher: JobLauncher
) {
    @Scheduled(cron = "*/10 * * * * *")
    @Throws(Exception::class)
    fun perform() {
        println("Job Started at :" + Date())
        val param = JobParametersBuilder().addString("JobID", System.currentTimeMillis().toString()).toJobParameters()
        val execution = jobLauncher.run(processOrderJob(), param)
        println("Job finished with status :" + execution.status)
    }

    @Bean
    fun processOrderJob() = jobBuilderFactory.get("processOrderJob")
        .start(step1()).next(step2())
        .build()

    @Bean
    fun step1() = stepBuilderFactory.get("step1")
        .tasklet(Step1())
        .build()

    @Bean
    fun step2() = stepBuilderFactory.get("step2")
        .tasklet(Step2())
        .build()
}
