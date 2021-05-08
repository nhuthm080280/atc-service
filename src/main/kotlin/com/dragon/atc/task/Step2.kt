package com.dragon.atc.task

import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import java.lang.Exception

class Step2 : Tasklet {
    @Throws(Exception::class)
    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus? {
        println("Step2 start..")
        // ... your code
        println("Step2 done..")
        return RepeatStatus.FINISHED
    }
}
