package com.westeros;

import com.westeros.diagnostics.service.IDiagnosticsServiceClient;
import com.westeros.tools.schedulers.Chron;
import com.westeros.tools.schedulers.Scheduler;
import com.westeros.tools.schedulers.SchedulerThread;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.LocalDateTime;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class DiagnosticsConfiguration {
    private final SchedulerThread schedulerThread;
    private final IDiagnosticsServiceClient diagnosticsServiceClient;
    private final Scheduler scheduler;

    @PostConstruct
    public void runScheduler(){
        scheduler.forAction(diagnosticsServiceClient::sendDiagnostics)
                .useExecutionTimeProvider(Chron.builder()
                        .start(LocalDateTime.now())

                        .interval(Duration.ofSeconds(5))
                        .build()
                        .buildNextTimeExecutionProvider())
                .onSingleActionCompleted(()->log.info("Diagnostics sent."))
                .schedule();
        new Thread(schedulerThread).start();

    }
}
