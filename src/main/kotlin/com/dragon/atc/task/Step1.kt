package com.dragon.atc.task

import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import java.lang.Exception

class Step1 : Tasklet {
    @Throws(Exception::class)
    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus? {
        println("Step1 start..")
        // ... your code
        println("Step1 done..")
        return RepeatStatus.FINISHED
    }
}
