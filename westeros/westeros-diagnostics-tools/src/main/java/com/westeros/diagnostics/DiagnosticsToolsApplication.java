package com.westeros.diagnostics;

import com.westeros.diagnostics.service.IDiagnosticsServiceClient;
import com.westeros.tools.schedulers.Chron;
import com.westeros.tools.schedulers.Scheduler;
import com.westeros.tools.schedulers.SchedulerThread;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.time.LocalDateTime;

@SpringBootApplication(scanBasePackages = "com.westeros")
@RequiredArgsConstructor
public class DiagnosticsToolsApplication implements CommandLineRunner {

    private final SchedulerThread schedulerThread;
    private final IDiagnosticsServiceClient diagnosticsClient;
    private final Scheduler scheduler;


    public static void main(String[] args) {
        SpringApplication.run(DiagnosticsToolsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        scheduler.forAction(diagnosticsClient::sendDiagnostics)
                .useExecutionTimeProvider(Chron.builder()
                        .start(LocalDateTime.now())

                        .interval(Duration.ofMinutes(5))
                        .build()
                        .buildNextTimeExecutionProvider())
                .schedule();
        new Thread(schedulerThread).start();
    }
}
