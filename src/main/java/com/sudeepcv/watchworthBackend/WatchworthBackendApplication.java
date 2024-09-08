package com.sudeepcv.watchworthBackend;

import com.sudeepcv.watchworthBackend.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class WatchworthBackendApplication {
	@Autowired
	private VideoRepository videoRepository;

	public static void main(String[] args) {
		SpringApplication.run(WatchworthBackendApplication.class, args);
	}

	// This cron expression schedules the task to run every 5 minute
	@Scheduled(cron = "0 */5 * * * ?")
	public void deleteAllVideos() {
		System.out.println("Deleting all videos from the database...");
		videoRepository.deleteAll(); // Deletes all video records
		System.out.println("All videos deleted.");
	}

}
